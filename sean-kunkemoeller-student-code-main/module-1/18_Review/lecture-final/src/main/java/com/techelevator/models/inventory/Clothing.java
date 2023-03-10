package com.techelevator.models.inventory;


import java.math.BigDecimal;

public class Clothing extends Item {

    private double taxRate = 6.0;

    public Clothing(String sku) {
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
