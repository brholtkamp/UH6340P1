package com.UH6340.DB;

import org.antlr.v4.runtime.misc.Pair;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Brian Holtkamp on 2/22/2015.
 */

public class DBHandler {
    File dbInfoFile;
    JSONObject dbInfo;
    ArrayList<File> tableFiles = new ArrayList<File>();

    public DBHandler() throws IOException, ParseException {
        // Attempt to open the DB information
        dbInfoFile = new File("db.txt");

        // Check to see if the DB information already exists
        if (!dbInfoFile.isFile()) {
            try {
                // Setup the basic file structure
                dbInfo = new JSONObject();
                dbInfo.put("tables", new JSONArray());

                // Setup a writer to make the basic file
                FileWriter writer = new FileWriter(dbInfoFile);
                writer.write(dbInfo.toJSONString());
                writer.close();
            } catch (IOException ex) {
                throw new IOException("Unable to write new db.txt");
            }
        } else {
            // DB information already exists, grab it and check the status of the database
            try {
                // Parse the DB information
                FileReader reader = new FileReader(dbInfoFile);
                JSONParser parser = new JSONParser();
                dbInfo = (JSONObject)parser.parse(reader);

                // Get all of the table names out and make sure the files exist
                JSONArray tables = (JSONArray)dbInfo.get("tables");
                for (Object tableObject : tables) {
                    JSONObject table = (JSONObject) tableObject;
                    File newTable = new File("tables/" + table.get("name").toString() + ".txt");

                    if (newTable.isFile()) {
                        // Output found tables
                        System.out.println("Found table: " + table.get("name"));
                        JSONObject fields = (JSONObject)table.get("fields");
                        for (Object field : fields.entrySet()) {
                            System.out.println("\t\t" + ((Map.Entry<String, String>)field).getKey() + ":" + ((Map.Entry<String, String>)field).getValue());
                        }
                        System.out.println();

                        tableFiles.add(newTable);
                    } else {
                        throw new FileNotFoundException("Database table " + newTable.toString() + " does not exist");
                    }
                }
            } catch (IOException ex) {
                throw new IOException("Unable to load up database files: " + ex.getMessage());
            } catch (ParseException ex) {
                throw new ParseException(ex.getPosition(), ex.getErrorType(), ex.getUnexpectedObject());
            }
        }
    }

    public boolean addTable(String name, ArrayList<Pair<String, String>> fields) throws IOException {
        // Check to see if a table file of the same name already exists
        for (File table : tableFiles) {
            if (table.getName().equals(name + ".txt")) {
                System.err.println("Table file already exists");
                return false;
            }
        }

        // Check to see if a table of the same name exists in our DB information
        JSONArray tables = (JSONArray)dbInfo.get("tables");
        for (Object table : tables) {
            if (((JSONObject)table).get("name").toString().equals(name)) {
                System.err.println("Table file already exists");
                return false;
            }
        }

        // Create the JSON scheme for the new file
        JSONObject newTable = new JSONObject();
        newTable.put("name", name);

        // Add in the field information
        JSONObject newFields = new JSONObject();
        for (Pair<String, String> field : fields) {
            newFields.put(field.a, field.b);
        }
        newTable.put("fields", newFields);

        // Add the information to the DB information
        ((JSONArray)dbInfo.get("tables")).add(newTable);

        // Create the new file
        try {
            // Write our new file as a blank database file
            File newTableFile = new File("tables/" + name + ".txt");
            FileWriter writer = new FileWriter(newTableFile);
            writer.write("{}");
            writer.close();

            // Update our DB information file
            writer = new FileWriter(dbInfoFile);
            writer.write(dbInfo.toJSONString());
            writer.close();

            System.out.println("Added table: " + name);
            for (Pair<String, String> field : fields) {
                System.out.println("\t\t" + field.a + ":" + field.b);
            }
        } catch (FileAlreadyExistsException ex) {
            throw new FileAlreadyExistsException("A table file of the same name already exists");
        } catch (IOException e) {
            throw new IOException("Unable to write new table to file");
        }

        return true;
    }
}
