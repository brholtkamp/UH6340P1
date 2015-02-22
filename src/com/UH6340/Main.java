package com.UH6340;

import com.UH6340.SQLParsing.*;

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
        System.out.println("Hello world!");

        SQLHandler handler = new SQLHandler();
        for (String query : queries) {
            handler.handleMessage(query);
        }
    }
}
