package com.techelevator;


import java.math.BigDecimal;

public class Clothing extends Item implements Taxable{

    private double taxRate;

    public Clothing(String sku) {
        super(sku);
        setTaxable(true);
    }

    @Override
    public BigDecimal getPrice() {
        BigDecimal price = super.getPrice();
        BigDecimal amountToIncreasePrice = price.multiply(BigDecimal.valueOf(taxRate / 100));
        price = price.add(amountToIncreasePrice);
        return price;
    }

    @Override
    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }
}
