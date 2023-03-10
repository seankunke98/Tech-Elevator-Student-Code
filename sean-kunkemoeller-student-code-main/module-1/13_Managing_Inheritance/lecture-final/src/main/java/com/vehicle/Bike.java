package com.vehicle;

public class Bike implements Vehicle{

    @Override
    public String turn(String direction) {
        if(direction.equals("left")){
            return "turn handle bars left";
        }
        return "turn handle bars right";
    }

    @Override
    public String toString() {
        return "Bike ";
    }

    @Override
    public void accelerate() {
        System.out.println("pedal faster!!");
    }
}
