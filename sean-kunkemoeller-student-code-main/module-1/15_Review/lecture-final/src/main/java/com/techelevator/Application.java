package com.techelevator;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {

    /*
          After implementing the Taxable interface on Pet and Clothing,
          I provided an override to the getPrice() in each so that I can
          treat the items generically and still have each maintain their state for
          taxRate.
          Then, as I loop over the Items in my map, I am checking the instance of
          the objects to see if that object is an instanceof Taxable.
          If it is, then I am asking the user of the system to enter the
          taxRate and apply it to the price displayed for the item.
          I made this design decision to demonstrate the use of instanceof.
          Another approach suggested by a few of you to have the Item class implement
          Taxable, and then we could have one getPrice() method that calculates the price
          based on the increase if there was a taxRate set, otherwise, just return
          the price. That type of design would then setup for the next phase of
          our app, to add items to inventory!

          * */

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        Inventory inventoryBuilder = new Inventory();
        System.out.println("Welcome to Java Purple Mart");
        System.out.println();

        Map<String, Item> inventory = inventoryBuilder.getInventory();

        System.out.println("Items for Sale");

        for ( Map.Entry<String, Item> mapEntry : inventory.entrySet()) {
            Item something = new Food("123");
           something.setName("yummy");
           something.setPrice(new BigDecimal("3"));
           something.setDescription("super yummy food thing");

            System.out.print( mapEntry.getValue().getSku() );
            System.out.print( " : " + mapEntry.getValue().getName() );
            System.out.print( " ( " + mapEntry.getValue().getDescription() + " ) ");
            System.out.println( " $" + mapEntry.getValue().getPrice() );

            if(mapEntry.getValue() instanceof Taxable){
                System.out.println("Please enter the tax rate for: " + mapEntry.getValue().getName());
                String userEnteredTaxRate = userInput.nextLine();
                ((Taxable) mapEntry.getValue()).setTaxRate(Double.parseDouble(userEnteredTaxRate));
            }

        }

        System.out.println();
        System.out.print("Item to purchase >>>");
        String skuToPurchase = userInput.nextLine();

        Item selectedItem = inventory.get(skuToPurchase);

        System.out.println("You selected to purchase a " + selectedItem.getName() + " at a price of: " + selectedItem.getPrice());


    }

}
