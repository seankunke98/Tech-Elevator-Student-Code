package com.techelevator.models.inventory;

import java.math.BigDecimal;

public class Homegood extends Item{

    private double taxRate = 7.0;

    public Homegood(String sku) {
        super(sku);
    }

    @Override
    public BigDecimal getPrice() {
        BigDecimal price = super.getPrice();
        BigDecimal amountToIncreasePrice = price.multiply(BigDecimal.valueOf(taxRate / 100));
        price = price.add(amountToIncreasePrice);
        return price;
    }

}
