package com.UH6340;

import com.UH6340.DB.DBHandler;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            DBHandler db = new DBHandler();

            String command = "";
            Scanner input = new Scanner(System.in);
            System.out.println("DB Loaded and Ready!  Please issue commands ending with a newline, or type \"EXIT\" to close the DB");
            while (!command.equals("EXIT")) {
                System.out.print("DB: ");
                command = input.nextLine();

                if (!command.equals("EXIT")) {
                    db.handleCommand(command);
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
