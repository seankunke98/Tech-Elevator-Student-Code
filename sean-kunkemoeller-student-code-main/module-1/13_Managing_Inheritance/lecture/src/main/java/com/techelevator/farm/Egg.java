package com.techelevator.farm;

import java.math.BigDecimal;

public class Egg extends FarmAnimal implements Sellable {
    private String name;
    private BigDecimal price;

    public Egg() {
        name = "Egg";
        price = new BigDecimal("0.25");
    }

    public String getName() {
        return name;
    }

    @Override
    public String eat() {
        return null;
    }

    public BigDecimal getPrice() {
        return price;
    }
}