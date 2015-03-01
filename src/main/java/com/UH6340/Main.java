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
            "INSERT INTO employee (2, \"Bob\", \"Production\")",
            "INSERT INTO salary (2, 95000)",
            "INSERT INTO head (2, \"Production\")",
            "SELECT * FROM employee, salary WHERE id = id",
            "SELECT * FROM employee, head WHERE id = boss",
            "SELECT name, division FROM employee",
            "SELECT * FROM head WHERE division = \"Production\""
    };

    static String[] testQueries2 = {
            "CREATE teachers (teacherid INT, firstname STRING, lastname STRING)",
            "CREATE classes (classid INT, name STRING, coursenumber STRING)",
            "CREATE students (studentid INT, firstname STRING, lastname STRING)",
            "CREATE enrollment (classid INT, studentid INT)",
            "CREATE classlisting (classid INT, teacherid INT)",
            "INSERT INTO teachers (1, \"Bob\", \"A\")",
            "INSERT INTO teachers (2, \"Sally\", \"B\")",
            "INSERT INTO classes (1, \"Economics\", \"1000\")",
            "INSERT INTO classes (2, \"CS\", \"1000\")",
            "INSERT INTO students (1, \"Alice\", \"C\")",
            "INSERT INTO students (2, \"Daniel\", \"D\")",
            "INSERT INTO students (3, \"Emily\", \"E\")",
            "INSERT INTO students (4, \"Frank\", \"F\")",
            "INSERT INTO enrollment (1, 1)",
            "INSERT INTO enrollment (2, 2)",
            "INSERT INTO enrollment (3, 1)",
            "INSERT INTO enrollment (4, 2)",
            "INSERT INTO enrollment (1, 3)",
            "INSERT INTO enrollment (2, 3)",
            "INSERT INTO enrollment (3, 4)",
            "INSERT INTO classlisting (1, 1)",
            "INSERT INTO classlisting (2, 2)",
            "SELECT firstname FROM students WHERE studentid = \"1\"",
            "SELECT * FROM students, enrollment WHERE studentid = studentid",
            "SELECT * FROM teachers, classlisting WHERE teacherid = teacherid",
            "SELECT * FROM classes, classlisting WHERE classid = classid",
            "INSERT INTO enrollment (\"1\", \"abc\")"
    };

    public static void main(String[] args) {
        try {
            DBHandler db = new DBHandler();

            String command = "";
            Scanner input = new Scanner(System.in);
            System.out.println("DB Loaded and Ready!  Please issue commands ending with a newline, or type \"quit\" to close the DB, or \"test\" or \"test2\" to run test queries");
            while (!command.equals("quit")) {
                System.out.print("DB: ");
                command = input.nextLine();

                if (!command.equals("quit") && !command.equals("test") && !command.equals("test2")) {
                    db.handleCommand(command);
                } else if (command.equals("test")) {
                    for (String query : testQueries) {
                        db.handleCommand(query);
                    }
                } else if (command.equals("test2")) {
                    for (String query : testQueries2) {
                        db.handleCommand(query);
                    }
                } else {
                    // Quitting
                    System.out.println("Goodbye!");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
