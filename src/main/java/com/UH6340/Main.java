package com.UH6340;

import com.UH6340.DB.DBHandler;

import java.util.Scanner;

public class Main {
    static String[] testQueries =  {
            "CREATE employee (id INT, name STRING, division STRING)",
            "CREATE salary (id INT, salary INT)",
            "CREATE head (boss INT, division STRING)",
            "INSERT INTO employee (1, \"Alicia\", \"Direction\")",
            "INSERT INTO salary (1, 100000)",
            "INSERT INTO employee (2, \"Bob\", \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\")",
            "INSERT INTO employee (2, 2, 2)",
            "INSERT INTO employee (2, 2)",
            "INSERT INTO salary (2, 95000)",
            "INSERT INTO head (2, \"Production\")",
            "SELECT * FROM employee, salary WHERE id = id",
            "SELECT * FROM employee, head WHERE id = boss",
            "SELECT name, division FROM employee",
            "SELECT * FROM table WHERE division = \"Direction\""
    };

    public static void main(String[] args) {
        try {
            DBHandler db = new DBHandler();

            String command = "";
            Scanner input = new Scanner(System.in);
            System.out.println("DB Loaded and Ready!  Please issue commands ending with a newline, or type \"quit\" to close the DB, or \"test\" to run test queries");
            while (!command.equals("quit")) {
                System.out.print("DB: ");
                command = input.nextLine();

                if (!command.equals("quit") && !command.equals("test")) {
                    db.handleCommand(command);
                } else if (command.equals("test")) {
                    for (String query : testQueries) {
                        System.out.println("DB: " + query);
                        db.handleCommand(query);
                    }
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
