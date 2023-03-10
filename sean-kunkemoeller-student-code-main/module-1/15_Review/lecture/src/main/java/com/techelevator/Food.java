package com.techelevator;

public class Food extends Item {

    public Food(String sku) {
        super(sku);
        setTaxable(false);
    }
}
