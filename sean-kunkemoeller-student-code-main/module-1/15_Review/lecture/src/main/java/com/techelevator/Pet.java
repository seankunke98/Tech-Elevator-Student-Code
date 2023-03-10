package com.techelevator;

public class Pet extends Item {

    public Pet(String sku) {
        super(sku);
        setTaxable(true);
    }
}
