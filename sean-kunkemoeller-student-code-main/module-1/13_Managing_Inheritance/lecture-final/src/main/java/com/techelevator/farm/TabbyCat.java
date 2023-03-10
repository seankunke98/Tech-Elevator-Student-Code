package com.techelevator.farm;

public class TabbyCat extends Cat{

    public TabbyCat(String name, String sound) {
        super(name, sound);
    }

    @Override
    public String eat() {
        return "meow mix meow";
    }
}
