package com.techelevator.farm;

public class Pig extends FarmAnimal {
    public Pig(){
        super("Pig", "oink!");
    }

    @Override
    public String getSound(){
        return "oink!";
    }

}
