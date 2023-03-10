package com.techelevator.models.reader;

import com.techelevator.models.inventory.Clothing;
import com.techelevator.models.inventory.Food;
import com.techelevator.models.inventory.Homegood;
import com.techelevator.models.inventory.Item;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.FileAlreadyExistsException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class InventoryBuilder {

    public Map<String, Item> getInventory() {
        String filePath = "inventory.csv";
        File inventoryFile = new File(filePath);
        Map<String, Item> inventory = new HashMap<>();

        try(Scanner reader = new Scanner(inventoryFile)) {
            while (reader.hasNextLine()) {
                String[] itemFields = reader.nextLine().split("\\|");
                if (itemFields[4].trim().toUpperCase().equals("F")) {
                    Food foodItem = new Food(itemFields[0]);
                    foodItem.setName(itemFields[1]);
                    foodItem.setDescription(itemFields[2]);
                    foodItem.setPrice(new BigDecimal(itemFields[3]));
                    inventory.put(foodItem.getSku(), foodItem);
                } else if (itemFields[4].trim().toUpperCase().equals("C")) {
                    Clothing clothingItem = new Clothing(itemFields[0]);
                    clothingItem.setName(itemFields[1]);
                    clothingItem.setDescription(itemFields[2]);
                    clothingItem.setPrice(new BigDecimal(itemFields[3]));
                    inventory.put(clothingItem.getSku(), clothingItem);
                } else if (itemFields[4].trim().toUpperCase().equals("H")) {
                    Homegood homegoodItem = new Homegood(itemFields[0]);
                    homegoodItem.setName(itemFields[1]);
                    homegoodItem.setDescription(itemFields[2]);
                    homegoodItem.setPrice(new BigDecimal(itemFields[3]));
                    inventory.put(homegoodItem.getSku(), homegoodItem);
                } else {
                    System.out.println("Invalid item type - " + itemFields[0]);
                }

            }
        } catch (FileNotFoundException e){
            System.out.println("");
        }
//        Food cake = new Food("001");
//        cake.setName("Cake");
//        cake.setDescription("A chocolate cake");
//        cake.setPrice(new BigDecimal("10"));
//
//        Clothing flipflops = new Clothing("002");
//        flipflops.setName("Flip Flop Sandals");
//        flipflops.setDescription("Protect your feet, but only the bottoms");
//        flipflops.setPrice(new BigDecimal("7"));
//
//        Homegood catClock = new Homegood("cat01");
//        catClock.setName("Cat O'Clock");
//        catClock.setDescription("Covered in fur");
//        catClock.setPrice(new BigDecimal("100"));
//
//        Homegood frogMug = new Homegood("f22");
//        frogMug.setName("Frog Mug");
//        frogMug.setDescription("Greenish and not a toad");
//        frogMug.setPrice(new BigDecimal("5.25"));
//
//
//
//        inventory.put(cake.getSku(), cake);
//        inventory.put(flipflops.getSku(), flipflops);
//        inventory.put(catClock.getSku(), catClock);
//        inventory.put(frogMug.getSku(), frogMug);

        return inventory;
    }
}
