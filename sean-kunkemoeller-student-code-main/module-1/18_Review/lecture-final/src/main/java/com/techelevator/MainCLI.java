package com.techelevator;

import com.techelevator.application.Main;
import com.techelevator.models.reader.InventoryBuilder;

import java.io.FileNotFoundException;

public class MainCLI {

    public static void main(String[] args) {
        InventoryBuilder inventoryBuilder = null;
        try {
            inventoryBuilder = new InventoryBuilder("inventory.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Main main = new Main(inventoryBuilder);
        main.run();
    }
    
}
