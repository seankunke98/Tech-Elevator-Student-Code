package com.techelevator.farm;

public class Tractor implements Singable, Sellable {


    @Override
    public String getSound() {
        return "vroom!";
    }
    @Override
    public String getName(){
        return "Tractor";
    }

    @Override
    public double getPrice() {
        return 500.00;
    }
}
