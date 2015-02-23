package com.UH6340;

import com.UH6340.DB.DBHandler;
import com.UH6340.SQL.SQLHandler;
import com.UH6340.SQL.SQLParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main {
    static String[] queries =  {
                            "CREATE employee (id INT, name STRING, division STRING)",
                            "CREATE salary (id INT, salary INT)",
                            "CREATE head (boss INT, division STRING)",
                            "INSERT INTO employee (1, \"Alicia\", \"Direction\")",
                            "INSERT INTO salary (1, 100000)",
                            "INSERT INTO employee (2, \"Bob\", \"Production\")",
                            "INSERT INTO salary (2, 95000)",
                            "INSERT INTO head (2, \"Production\")",
                            "SELECT * FROM employee, salary WHERE id = id",
                            "SELECT * FROM employee, head WHERE id = boss",
                            "SELECT name, division FROM employee",
                            "SELECT * FROM table WHERE division = \"Direction\""
                        };

    public static void main(String[] args) {
        // Test the SQL handler


        // Setup our DB handler to make life easier
        try {
            SQLHandler handler = new SQLHandler();
            DBHandler dbHandler = new DBHandler();

            for (String query : queries) {
                System.out.println(query);
                handler.handleMessage(query);
                if (handler.getCommandType() == SQLParser.RULE_tableCreation) {
                    dbHandler.addTable(handler.getTables().get(0), handler.getFields());
                }
            }
        } catch (IOException ex) {
            System.err.println("Unable to perform database operation:\n" + ex.getMessage());
        } catch (ParseException ex) {
            System.err.println("Unable to parse database files:\n" + ex.getErrorType() + " " + ex.getUnexpectedObject() + " at " + ex.getPosition());
        }
    }
}
