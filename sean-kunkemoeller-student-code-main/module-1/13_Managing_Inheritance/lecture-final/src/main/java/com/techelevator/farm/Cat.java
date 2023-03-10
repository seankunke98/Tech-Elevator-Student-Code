package com.techelevator.farm;

public abstract class Cat extends FarmAnimal{

    public Cat(String name, String sound){
        super(name, sound);
    }

    public abstract String eat();

//    @Override
//    public String getSound(){
//        return "Meow";
//    }
}
