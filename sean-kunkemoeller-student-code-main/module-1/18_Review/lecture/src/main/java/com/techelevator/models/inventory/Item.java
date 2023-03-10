package com.techelevator.models.inventory;

import java.math.BigDecimal;

public abstract class Item {

    private BigDecimal price;
    private String name;
    private String description;
    private String sku;


    //constructor
    public Item(String sku) {
        this.sku = sku;
    }

    public BigDecimal getPrice() {
        return price;
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

}
