package com.techelevator;

import java.math.BigDecimal;

public class FlowerShop {
    // attributes or properties
    private String bouquetType;
    private int numberOfRoses;
    // derived property so we will have a getSubtotal method
    private BigDecimal subtotal;

    public FlowerShop(String bouquetType, int numberOfRoses){
        this.bouquetType = bouquetType;
        this.numberOfRoses = numberOfRoses;
        setTheSubtotal();
    }

    public String getBouquetType() {
        return bouquetType;
    }

    public void setBouquetType(String bouquetType) {
        this.bouquetType = bouquetType;
    }

    public int getNumberOfRoses() {
        return numberOfRoses;
    }

    public void setNumberOfRoses(int numberOfRoses) {
        this.numberOfRoses = numberOfRoses;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public void setTheSubtotal(){
        this.subtotal = new BigDecimal("19.99");
        BigDecimal additionalRose = new BigDecimal("2.99");
        BigDecimal roseCost  = additionalRose.multiply(new BigDecimal(this.numberOfRoses));
        subtotal = subtotal.add(roseCost);
//        return subtotal;
    }

    @Override
    public String toString(){
        return "ORDER - " + this.bouquetType + " - " +
                this.numberOfRoses + " - " + getSubtotal();
    }
}
