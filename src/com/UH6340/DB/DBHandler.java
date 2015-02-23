package com.UH6340.DB;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Brian Holtkamp on 2/22/2015.
 */
public class DBHandler {
    File dbInfoFile;
    ArrayList<File> tableFiles = new ArrayList<File>();

    public DBHandler() throws IOException, ParseException {
        // Attempt to open the DB information
        dbInfoFile = new File("db.txt");

        // Check to see if the DB information already exists
        if (!dbInfoFile.isFile()) {
            try {
                // Setup the basic file structure
                JSONObject baseConfiguration = new JSONObject();
                JSONArray tables = new JSONArray();
                baseConfiguration.put("tables", tables);

                // Setup a writer to make the basic file
                FileWriter writer;
                writer = new FileWriter(dbInfoFile);
                writer.write(baseConfiguration.toJSONString());
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
                JSONObject dbFileContents = (JSONObject)parser.parse(reader);

                // Get all of the table names out and make sure the files exist
                JSONArray tables = (JSONArray)dbFileContents.get("tables");
                for (Object table : tables) {
                    JSONObject JSONtable = (JSONObject) table;
                    File newTable = new File("tables/" + JSONtable.get("name").toString() + ".txt");

                    if (newTable.isFile()) {
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
}
