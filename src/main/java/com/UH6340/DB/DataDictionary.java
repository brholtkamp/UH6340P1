package com.UH6340.DB;

import org.antlr.v4.runtime.misc.Pair;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Brian Holtkamp on 2/22/2015.
 * Consists of tuples of the table information
 *  String  String  String  String
 *  Table   Field   Type    File
 */
public class DataDictionary {

    public class Table {
        public HashMap<String, String> fields;
        public ArrayList<String> fieldOrder;
        public String fileName;

        Table() {
            fields = new HashMap<String, String>();
            fieldOrder = new ArrayList<String>();
        }
    }

    HashMap<String, Table> dictionary;
    ArrayList<String> tableOrder;
    File dictionaryFile;

    public DataDictionary() throws IOException {
        try {
            // Attempt to open the file
            dictionaryFile = new File("db.txt");
            dictionary = new HashMap<String, Table>();
            tableOrder = new ArrayList<String>();

            // Create a directory for the tables
            File tablesFolder = new File("tables");
            if (!tablesFolder.isDirectory()) {
                System.out.println("No tables directory present, creating ./tables");
                if (!tablesFolder.mkdir()) {
                    throw new IOException("Unable to create tables directory");
                }
            }

            // See if the file exists
            if (!dictionaryFile.isFile()) {
                System.out.println("No past database information found, creating new db.txt");
                // File doesn't exist, needs to be written
                if (!dictionaryFile.createNewFile()) {
                    throw new IOException("Unable to create db.txt");
                }
            } else {
                // File exists, load up the dictionary
                BufferedReader reader = new BufferedReader(new FileReader(dictionaryFile));

                // Consume the file line by line
                for (String dictionaryLine; (dictionaryLine = reader.readLine()) != null; ) {
                    // Split on comma to get the entry details
                    String[] lineContents = dictionaryLine.split(",");

                    // Add the list to the dictionary
                    if (dictionary.containsKey(lineContents[0])) {
                        dictionary.get(lineContents[0]).fields.put(lineContents[1], lineContents[2]);
                        dictionary.get(lineContents[0]).fieldOrder.add(lineContents[1]);
                    } else {
                        Table entry = new Table();

                        // Add into the list
                        entry.fileName = lineContents[3];
                        entry.fields.put(lineContents[1], lineContents[2]);
                        entry.fieldOrder.add(lineContents[1]);

                        // Add to the ordering
                        tableOrder.add(lineContents[0]);

                        // Add to the dictionary
                        dictionary.put(lineContents[0], entry);
                    }
                }

                if (dictionary.size() > 0) {
                    // Output our loaded dictionary
                    System.out.println("Loaded the following data dictionary entries");
                    printDictionary();
                } else {
                    System.out.println("Loaded an empty data dictionary");
                }
            }
        } catch (IOException ex) {
            throw new IOException("Unable to write dictionary file");
        }
    }

    public void updateDictionary() throws IOException {
        StringBuilder buffer = new StringBuilder();

        // Build up the buffer from the contents of the current dictionary
        for (String table : tableOrder) {
            for (String field : dictionary.get(table).fieldOrder) {
                buffer.append(table);
                buffer.append(",");

                buffer.append(field);
                buffer.append(",");

                buffer.append(dictionary.get(table).fields.get(field));
                buffer.append(",");

                buffer.append(dictionary.get(table).fileName);
                buffer.append(",");

                buffer.append("\n");
            }
        }

        // Write it out to the file
        try {
            FileWriter writer = new FileWriter(dictionaryFile);
            writer.write(buffer.toString());
            writer.close();
        } catch (IOException ex) {
            throw new IOException("Unable to update dictionary file");
        }
    }

    public void addTable(String tableName, ArrayList<Pair<String, String>> fields) throws IOException {
        for (String table : dictionary.keySet()) {
            if (table.equals(tableName)) {
                throw new IOException("Table named " + tableName + " already exists");
            }
        }

        // Make a backup of our current state
        HashMap<String, Table> backup = new HashMap<String, Table>(dictionary);

        // Create a new entry
        Table entry = new Table();

        // Iterate through all fields
        for (Pair<String, String> field : fields) {
            entry.fields.put(field.a, field.b);
            entry.fieldOrder.add(field.a);
        }

        // Add in the filename
        entry.fileName = tableName + ".txt";

        // Add to the table ordering
        tableOrder.add(tableName);

        // Add it to the dictionary
        dictionary.put(tableName, entry);

        // Store the changes
        try {
            updateDictionary();

            // Create a file for that table
            File newTable = new File("tables/" + tableName + ".txt");
            if (!newTable.createNewFile()) {
                throw new FileAlreadyExistsException(tableName + ".txt");
            }
        } catch (IOException ex) {
            dictionary = backup;
            throw new IOException("Unable to add new entry to the dictionary, reverting to original state");
        }
    }

    public File getTableFileHandle(String tableName) throws FileNotFoundException, FileAlreadyExistsException {
        if (checkIfTableExists(tableName)) {
            // Table was found, create a new file handle to it and return it
            return new File("tables/" + dictionary.get(tableName).fileName);
        } else {
            throw new FileNotFoundException("Table named " + tableName + " does not exist within dictionary");
        }
    }

    public boolean checkIfTableExists(String tableName) {
        for (String table : dictionary.keySet()) {
            if (table.equals(tableName)) {
                return true;
            }
        }

        return false;
    }

    public boolean checkifTableHasField(String tableName, String field) {
        if (checkIfTableExists(tableName)) {
            if (dictionary.get(tableName).fields.containsKey(field)) {
                return true;
            }
        }

        return false;
    }

    public int getIndexOfField(String tableName, String field) {
        if (checkifTableHasField(tableName, field)) {
            return dictionary.get(tableName).fieldOrder.indexOf(field);
        }

        return -1;
    }


    public Table getTable(String tableName) throws Exception {
        if (checkIfTableExists(tableName)) {
            return dictionary.get(tableName);
        } else {
            throw new Exception("Table " + tableName + " does not exist");
        }
    }

    public void printDictionary() {
        System.out.println("Table Name    Attribute Name    Data Type    File Location");
        for (String table : tableOrder) {
            for (String field : dictionary.get(table).fieldOrder) {
                System.out.printf("%-14s%-18s%-13s%-15s\n", table, field, dictionary.get(table).fields.get(field), dictionary.get(table).fileName);
            }
        }
        System.out.println("");
    }
}
