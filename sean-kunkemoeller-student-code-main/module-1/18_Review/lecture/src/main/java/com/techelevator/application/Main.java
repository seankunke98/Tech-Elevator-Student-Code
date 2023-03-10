package com.techelevator.application;

import com.techelevator.models.inventory.Item;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;
import com.techelevator.models.reader.InventoryBuilder;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private Map<String, Item> inventory = new HashMap<>();

    public Main(InventoryBuilder inventoryBuilder) {
        inventory = inventoryBuilder.getInventory();
    }

    public void run() {
        while(true) {
            UserOutput.displayHomeScreenBanner();
            UserOutput.displayHomeScreenOptions();
            String choice = UserInput.getHomeScreenOption();
            UserOutput.displayMessage(choice);
            if(choice.equals("display")) {
                // display the items
                UserOutput.displayInventoryItems(inventory);
            }
            else if(choice.equals("purchase")) {
                // make a purchase
                UserOutput.displayMessage("Enter the SKU of the item you wish to purchase:");
                String itemKey = UserInput.getItemKeyUserSelected();
                UserOutput.displayMessage("You selected " + inventory.get(itemKey).getName() + " at a price of: $ " + inventory.get(itemKey).getPrice());
            }
            else if(choice.equals("exit")) {
                // good bye
                break;
            }
        }
    }
    
}
