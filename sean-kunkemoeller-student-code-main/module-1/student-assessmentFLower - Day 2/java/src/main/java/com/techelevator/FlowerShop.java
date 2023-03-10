package com.techelevator;

import java.math.BigDecimal;
import java.util.Arrays;

public class FlowerShop {
    // attributes or properties
    private String bouquetType;
    private int numberOfRoses;
    // derived property so we will have a getSubtotal method
    //private BigDecimal subtotal;

    public FlowerShop(String bouquetType, int numberOfRoses){
        this.bouquetType = bouquetType;
        this.numberOfRoses = numberOfRoses;
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

    public BigDecimal deliveryTotal (boolean sameDayDelivery, String zipCode){
        BigDecimal delivery = new BigDecimal("0.00");
        if(zipCode.startsWith("2")){
            delivery = delivery.add(new BigDecimal("3.99"));
            if (sameDayDelivery) {
                delivery = delivery.add(new BigDecimal("5.99"));
            }
        } else if (zipCode.startsWith("3")){
            delivery = delivery.add(new BigDecimal("6.99"));
            if (sameDayDelivery) {
                delivery = delivery.add(new BigDecimal("5.99"));
            }
        } else if (zipCode.startsWith("1")){
            return delivery;

        }  else {
            delivery = delivery.add(new BigDecimal("19.99"));
        }

        return delivery;
    }


    public BigDecimal getSubtotal(){
        BigDecimal subtotal = new BigDecimal("19.99");
        BigDecimal additionalRose = new BigDecimal("2.99");
        BigDecimal roseCost  = additionalRose.multiply(new BigDecimal(this.numberOfRoses));
        subtotal = subtotal.add(roseCost);
        return subtotal;
    }

    @Override
    public String toString(){
        return "ORDER - " + this.bouquetType + " - " +
                this.numberOfRoses + " - " + getSubtotal();
    }
}
