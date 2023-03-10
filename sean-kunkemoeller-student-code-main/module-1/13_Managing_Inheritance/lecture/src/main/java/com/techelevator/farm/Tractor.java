package com.techelevator.farm;

import com.vehicle.Vehicle;

public class Tractor implements Singable, Vehicle {

    private String name;
    private String sound;
    protected int speed;

    public Tractor(String name) {
        this.name = name;
        this.sound = "vroom!";
    }

    public String getName() {
        return name;
    }

    public String getSound() {
        return sound;
    }


    @Override
    public String toString() {
        return name + " [ " + speed + " ] ";
    }

    @Override
    public void sleep(boolean isAsleep) {

    }

    @Override
    public String turn(String direction) {
        return "turn steering wheel towards " + direction;
    }

    @Override
    public void accelerate() {
        System.out.println("press the gas");
        speed++;
    }
    protected String playJohnDever(){
        return "Thank God I'm a country boy";
    }

    public void setName(String name) {
        this.name = name;
    }
}