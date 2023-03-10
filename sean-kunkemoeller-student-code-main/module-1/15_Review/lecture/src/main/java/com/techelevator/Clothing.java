package com.techelevator;

public class Clothing extends Item {


    public Clothing(String sku) {
        super(sku);
        setTaxable(true);
    }
}
