package com.techelevator.models.reader;

import com.techelevator.models.inventory.Clothing;
import com.techelevator.models.inventory.Food;
import com.techelevator.models.inventory.Homegood;
import com.techelevator.models.inventory.Item;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InventoryBuilder {

    private String path;
    private Map<String, Item> inventory = new HashMap<>();

    public InventoryBuilder(String path) throws FileNotFoundException {
        this.path = path;
        inventory = readInventoryCSV();
    }

    public Map<String, Item> getInventory(){
        return inventory;
    }

    private Map<String, Item> readInventoryCSV() throws FileNotFoundException {
        File csv = new File(this.path);
        try(Scanner scanFile = new Scanner(csv)){
            while(scanFile.hasNextLine()){
                String lineFromFile = scanFile.nextLine();
                Item item = itemFromFile(lineFromFile);
                inventory.put(item.getSku(), item);
            }
        }
        return inventory;
    }

    private Item itemFromFile(String line){
        String[] itemArray = line.split("\\|");
        Item item = null;
        if(itemArray[4].equalsIgnoreCase("F")){
            item = new Food(itemArray[0]);
        } else if (itemArray[4].equalsIgnoreCase("C")) {
            item = new Clothing(itemArray[0]);
        } else {
            item = new Homegood(itemArray[0]);
        }
        item.setName(itemArray[1]);
        item.setDescription(itemArray[2]);
        item.setPrice(new BigDecimal(itemArray[3]));
        return item;
    }
}
