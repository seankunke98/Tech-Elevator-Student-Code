package com.techelevator;

import java.math.BigDecimal;

public abstract class Item {


    private boolean isTaxable;
    private double taxRate;
    private BigDecimal price;
    private String name;
    private String description;
    private String sku;
    private boolean isPerishable;

    //constructor
    public Item(String sku) {
        this.sku = sku;
    }

    public BigDecimal getPrice() {
        return price;
    }


    public boolean isTaxable() {
        return isTaxable;
    }

    public void setTaxable(boolean taxable) {
        isTaxable = taxable;
    }

    public double getTaxRate() {
        if(isTaxable){
            taxRate = 0.7;
            return taxRate;
        } else
        return taxRate = 0;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSku() {
        return sku;
    }


    public boolean isPerishable() {
        return isPerishable;
    }

    public void setPerishable(boolean perishable) {
        isPerishable = perishable;
    }
}
