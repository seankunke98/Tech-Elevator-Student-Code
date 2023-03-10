package com.techelevator.farm;

public class Tractor implements Singable, Sellable{

    @Override
    public String getSound() {
        return "Vrroomm!";
    }

    @Override
    public String getName() {
        return "Tractor";
    }

    @Override
    public double getPrice() {
        return 500.00;
    }
}
