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

public class DBCommandHandler {
    DataDictionaryHandler dictionary;
    SQLCommandHandler sql;

    public DBCommandHandler() throws Exception {
        try {
            dictionary = new DataDictionaryHandler();
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
        // Resolve projection and grab indicies of tables
        // Grab relevant pieces from table
        // Print out data in terminal
    }

    private void insertIntoTable(String tableName, ArrayList<String> values) throws Exception {
        // Check to see if the table exists
        if (dictionary.checkIfTableExists(tableName)) {
            ArrayList<String> tableDataTypes = dictionary.getTableDatatypes(tableName);

            // Check to see if this is a valid insertion
            if (values.size() == dictionary.getTableDatatypes(tableName).size() && checkDatatypes(values, tableDataTypes)) {
                // Craft the new tuple
                StringBuilder buffer = new StringBuilder();
                for (String value : values) {
                    buffer.append(value);
                    buffer.append(",");
                }
                buffer.append("\n");

                // Append to the file
                BufferedWriter table = new BufferedWriter(new FileWriter(dictionary.getTable(tableName), true));
                table.append(buffer.toString());
                table.close();
            } else {
                throw new Exception("Insertion operation on " + tableName + " failed due to schema mismatch" + "\nExpected schema: " + tableDataTypes.toString());
            }
        } else {
            throw new Exception("Table " + tableName + " doesn't exist in the database");
        }
    }

    private boolean checkDatatypes(ArrayList<String> values, ArrayList<String> tableDataTypes) {
        boolean typeMatch = true;

        for (int i = 0; i < values.size(); i++) {
            // Check to see if it's an integer
            if (values.get(i).matches("^\\d+") && !tableDataTypes.get(i).equals("INT")) {
                typeMatch = false;
            }

            // Check to see if it's a string
            if (!values.get(i).matches("^\\d+") && tableDataTypes.get(i).equals("INT")) {
                typeMatch = false;
            }
        }

        return typeMatch;
    }

    private void createTable(String tableName, ArrayList<Pair<String, String>> fields) throws IOException {
        try {
            dictionary.addTable(tableName, fields);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
