package com.techelevator.farm;

import java.math.BigDecimal;

public class Cat extends FarmAnimal{
    private int price;
    public Cat(String name, String sound){
        super(name, sound);
    }


    public String eat(){
        return "Eating cat food";
    }

    @Override
    public String getSound(){
        return "meow";

    }

    @Override
    public BigDecimal getPrice() {
        return new BigDecimal(price);
    }
}
