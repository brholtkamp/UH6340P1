package com.UH6340.DB;

import org.antlr.v4.runtime.misc.Pair;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Brian Holtkamp on 2/22/2015.
 * Consists of tuples of the table information
 *  String  String  String  String
 *  Table   Field   Type    File
 */
public class DataDictionaryHandler {
    ArrayList<ArrayList<String>> dictionary;
    File dictionaryFile;

    public DataDictionaryHandler() throws Exception {
        try {
            // Attempt to open the file
            dictionaryFile = new File("db.txt");

            // See if the file exists
            if (!dictionaryFile.isFile()) {
                // File doesn't exist, needs to be written
                if (!dictionaryFile.createNewFile()) {
                    throw new Exception("Failed to create db.txt file");
                }
            } else {
                dictionary = new ArrayList<ArrayList<String>>();

                // File exists, load up the dictionary
                BufferedReader reader = new BufferedReader(new FileReader(dictionaryFile));

                // Consume the file line by line
                for (String dictionaryLine; (dictionaryLine = reader.readLine()) != null;) {
                    ArrayList<String> entry = new ArrayList<String>();

                    // Split on comma to get the entry details
                    String[] lineContents = dictionaryLine.split(",");

                    // Add into the list
                    entry.addAll(Arrays.asList(lineContents));

                    // Add the list to the dictionary
                    dictionary.add(entry);
                }

                // Output our loaded dictionary
                System.out.println("Loaded the following data dictionary entries");
                printDictionary();
            }
        } catch (IOException ex) {
            throw new IOException("Unable to write dictionary file");
        }
    }

    public void updateDictionary() throws IOException {
        StringBuilder buffer = new StringBuilder();

        // Build up the buffer from the contents of the current dictionary
        for (ArrayList<String> entry : dictionary) {
            for (String value : entry) {
                buffer.append(value);
                buffer.append(",");
            }
            buffer.append("\n");
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

    public boolean addTable(String tableName, ArrayList<Pair<String, String>> fields) throws IOException {
        for (ArrayList<String> entry : dictionary) {
            if (entry.get(0).equals(tableName)) {
                return false;
            }
        }

        // Make a backup of our current state
        ArrayList<ArrayList<String>> backup = new ArrayList<ArrayList<String>>();
        for (ArrayList<String> entry : dictionary) {
            ArrayList<String> backupEntry = new ArrayList<String>();
            for (String value : entry) {
                backupEntry.add(value);
            }
            backup.add(backupEntry);
        }

        // Iterate through all of the fields
        for (Pair<String, String> field : fields) {
            // Create a new entry
            ArrayList<String> entry = new ArrayList<String>();

            // Add in the table name,
            entry.add(tableName);

            // Add in the field
            entry.add(field.a);

            // Add in the type
            entry.add(field.b);

            // Add in the location (same as the table name + .txt)
            entry.add(tableName + ".txt");

            // Add it to the dictionary
            dictionary.add(entry);
        }

        // Store the changes
        try {
            updateDictionary();

            // Create a file for that table
            File newTable = new File("tables/" + tableName + ".txt");
            if (!newTable.createNewFile()) {
                throw new FileAlreadyExistsException(tableName + ".txt");
            }

            return true;
        } catch (IOException ex) {
            dictionary = backup;
            throw new IOException("Unable to add new entry to the dictionary, reverting to original state");
        }
    }

    public File getTable(String name) throws FileNotFoundException, FileAlreadyExistsException {
        // See if that table exists
        boolean tableFound = false;
        String tableLocation = "";
        for (ArrayList<String> entry : dictionary) {
            if (entry.get(0).equals(name)) {
                tableFound = true;
                tableLocation = entry.get(3);
            }
        }

        if (tableFound) {
            // Table was found, create a new file handle to it and return it
            return new File("tables/" + tableLocation);
        } else {
            throw new FileNotFoundException("Table named " + name + " does not exist within dictionary");
        }
    }

    public boolean checkIfTableExists(String tableName) {
        boolean exists = false;
        for (ArrayList<String> entry : dictionary) {
            if (entry.get(0).equals(tableName)) {
                exists = true;
            }
        }

        return exists;
    }

    public ArrayList<String> getTableDatatypes(String tableName) {
        ArrayList<String> datatypes = new ArrayList<String>();
        for (ArrayList<String> entry : dictionary) {
            if (entry.get(0).equals(tableName)) {
                datatypes.add(entry.get(2));
            }
        }

        return datatypes;
    }

    public void printDictionary() {
        System.out.println("Table Name    Attribute Name    Data Type    File Location");
        for (ArrayList<String> entry : dictionary) {
            System.out.printf("%-14s%-18s%-13s%-15s\n", entry.get(0), entry.get(1), entry.get(2), entry.get(3));
        }
        System.out.println("");
    }

}
