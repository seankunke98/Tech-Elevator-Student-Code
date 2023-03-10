package com.vehicle;

public class Bike implements Vehicle {


    @Override
    public String toString() {
        return "Bike ";
    }

    @Override
    public String turn(String direction) {
        return "turn steering wheel towards " + direction;
    }

    @Override
    public void accelerate() {

    }
}
