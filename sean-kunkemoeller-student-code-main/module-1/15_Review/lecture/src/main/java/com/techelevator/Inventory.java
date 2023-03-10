package com.techelevator;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Inventory {

    public Map<String, Item> getInventory() {
        Food cake = new Food("001");
        cake.setName("Cake");
        cake.setDescription("A chocolate cake");
        cake.setPerishable(true);
        cake.setPrice(new BigDecimal("10"));

        Clothing flipflops = new Clothing("002");
        flipflops.setName("Flip Flop Sandals");
        flipflops.setDescription("Protect your feet, but only the bottoms");
        flipflops.setPerishable(false);
        flipflops.setPrice(new BigDecimal("7"));

        Pet cat = new Pet("cat01");
        cat.setName("Cat");
        cat.setDescription("Covered in fur");
        cat.setPerishable(true);
        cat.setPrice(new BigDecimal("100"));

        Pet frog = new Pet("f22");
        frog.setName("Frog");
        frog.setDescription("Greenish and not a toad");
        frog.setPerishable(true);
        frog.setPrice(new BigDecimal("5.25"));


        Map<String, Item> inventory = new HashMap<String, Item>();

        inventory.put(cake.getSku(), cake);
        inventory.put(flipflops.getSku(), flipflops);
        inventory.put(cat.getSku(), cat);
        inventory.put(frog.getSku(), frog);

        return inventory;
    }
}
