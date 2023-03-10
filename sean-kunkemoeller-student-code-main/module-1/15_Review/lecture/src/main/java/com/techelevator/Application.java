package com.techelevator;

import java.util.Map;
import java.util.Scanner;

public class Application {
    public static void main(String[] args){

        Scanner userInput = new Scanner(System.in);
        Inventory inventoryBuilder = new Inventory();
        System.out.println("Welcome to Java Purple Mart");
        System.out.println();

        Map<String, Item> inventory = inventoryBuilder.getInventory();
        System.out.println("Items for sale");

        for(Map.Entry<String, Item> mapEntry : inventory.entrySet()){
            System.out.println( mapEntry.getValue().getSku() );
            System.out.println( " : " + mapEntry.getValue().getName() );
            System.out.println( " ( " + mapEntry.getValue().getDescription() );
            System.out.println( " $" + mapEntry.getValue().getPrice());
        }

        System.out.println();
        System.out.println("Item to purchase >>>");
        String skuToPurchase = userInput.nextLine();

        Item selectedItem = inventory.get(skuToPurchase);

        System.out.println("You selected to purchase a: " + selectedItem.getName());


    }
}
