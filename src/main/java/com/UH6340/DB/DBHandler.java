package com.UH6340.DB;

import com.UH6340.SQL.SQLCommandHandler;
import com.UH6340.SQL.SQLParser;
import org.antlr.v4.runtime.misc.Pair;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Brian Holtkamp on 2/23/2015.
 * Used to provide an easy interface with the database, accepts SQL strings to handle actions
 */

public class DBHandler {
    DataDictionary dictionary;
    SQLCommandHandler sql;

    public DBHandler() throws Exception {
        try {
            dictionary = new DataDictionary();
            sql = new SQLCommandHandler();
        } catch (IOException ex) {
            throw new IOException(ex.getMessage());
        }
    }

    public void handleCommand(String sqlCommand) {
        try {
            // Parse the command
            sql.handleMessage(sqlCommand);

            switch (sql.getQueryType()) {
                case SQLParser.RULE_tableCreation:
                    createTable(sql.getTables().get(0), sql.getFields());
                    break;
                case SQLParser.RULE_tableInsertion:
                    insertIntoTable(sql.getTables().get(0), sql.getValues());
                    break;
                case SQLParser.RULE_tableSelection:
                    selectFromTable(sql.getTables(), sql.getSelections(), sql.getQueries());
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            System.err.println("Unable to process SQL command: " + sqlCommand + "\n" + ex.getMessage() + "\n");
        }
    }

    private void selectFromTable(ArrayList<String> tables, ArrayList<String> selections, ArrayList<Pair<String, String>> queries) {
        System.out.println("Select " + tables + " from " + selections.toString() + " where " + queries.toString());

        // Figure out what fields belong to what tables

        // Get the relevant incidies for the tables

        // Grab relevant pieces from table

        // Print out data in terminal
    }

    private void insertIntoTable(String tableName, ArrayList<String> values) throws IOException {
        // Check to see if the table exists
        if (dictionary.checkIfTableExists(tableName)) {
            DataDictionary.Table table = dictionary.getTable(tableName);

            // Check to see if this is a valid insertion
            if (values.size() == table.fields.size() && checkDatatypes(values, table)) {
                // Craft the new tuple && append to the file
                addToTable(tableName, craftTuple(values));
            } else {
                throw new IOException("Insertion operation on " + tableName + " failed due to schema mismatch" + "\nExpected schema: " + table.fieldOrder.toString().substring(1, table.fieldOrder.toString().length() - 1));
            }
        } else {
            throw new IOException("Table " + tableName + " doesn't exist in the database");
        }
    }

    private void addToTable(String tableName, String tuple) throws IOException {
        try {
            BufferedWriter tableFile = new BufferedWriter(new FileWriter(dictionary.getTableFileHandle(tableName), true));
            tableFile.append(tuple);
            tableFile.close();
        } catch (IOException ex) {
            throw new IOException("Failed to write insertion to file");
        }
    }

    private String craftTuple(ArrayList<String> values) {
        StringBuilder buffer = new StringBuilder();
        for (String value : values) {
            buffer.append(value);
            buffer.append(",");
        }
        buffer.append("\n");
        return buffer.toString();
    }

    private boolean checkDatatypes(ArrayList<String> values, DataDictionary.Table table) {
        for (int i = 0; i < values.size(); i++) {
            // Check to see if it's an integer
            if (values.get(i).matches("^\\d+")) {
                if (table.fields.get(table.fieldOrder.get(i)).equals("INT")) {
                    // Valid INT
                } else {
                    return false;
                }
            } else {
                if (table.fields.get(table.fieldOrder.get(i)).equals("STRING")) {
                    // Valid STRING
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    private void createTable(String tableName, ArrayList<Pair<String, String>> fields) throws IOException {
        try {
            dictionary.addTable(tableName, fields);
        } catch (IOException ex) {
            throw ex;
        }
    }
}
