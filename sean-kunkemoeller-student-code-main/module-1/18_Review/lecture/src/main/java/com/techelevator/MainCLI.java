package com.techelevator;

import com.techelevator.application.Main;
import com.techelevator.models.reader.InventoryBuilder;

public class MainCLI {
    public static void main(String[] args) {
        InventoryBuilder inventoryBuilder = new InventoryBuilder();
        Main main = new Main(inventoryBuilder);
        main.run();
    }
    
}
