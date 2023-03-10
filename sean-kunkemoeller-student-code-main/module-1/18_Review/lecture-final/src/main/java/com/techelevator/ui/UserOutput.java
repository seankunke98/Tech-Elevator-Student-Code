package com.techelevator.ui;

import com.techelevator.models.inventory.Item;

import java.math.BigDecimal;
import java.util.Map;


/**
 * Responsibilities: This class should handle formatting and displaying ALL
 * messages to the user
 * 
 * Dependencies: None
 */
public class UserOutput {

    public static void displayMessage(String message) {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    public static void displayHomeScreenBanner() {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Home");
        System.out.println("***************************************************");
        System.out.println();
    }

    public static void displayHomeScreenOptions(){
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("D) Display Items");
        System.out.println("P) Purchase");
        System.out.println("E) Exit");

        System.out.println();
        System.out.print("Please select an option: ");
    }

    public static void displayInventoryItems(Map<String, Item> inventory){
        for (Map.Entry<String, Item> itemEntry : inventory.entrySet()){
            System.out.println("[" + itemEntry.getKey() + "] " + itemEntry.getValue().getName() + " : " + itemEntry.getValue().getPrice());
        }
    }


}
