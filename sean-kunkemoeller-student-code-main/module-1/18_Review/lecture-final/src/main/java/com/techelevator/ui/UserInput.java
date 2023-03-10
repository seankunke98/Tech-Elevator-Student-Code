package com.techelevator.ui;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 * 
 * Dependencies: None
 */
public class UserInput {
    private static Scanner scanner = new Scanner(System.in);

    public static String getHomeScreenOption() {

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();
       // System.out.println("option = " + option);
        if (option.equals("d")) {
            return "display";
        }
        else if (option.equals("p")) {
            return "purchase";
        }
        else if (option.equals("e")) {
            return "exit";
        }
        else {
            return "";
        }

    }

    public static String getItemKeyUserSelected(){
        String itemKey = scanner.nextLine();
        return itemKey;
    }

    
}
