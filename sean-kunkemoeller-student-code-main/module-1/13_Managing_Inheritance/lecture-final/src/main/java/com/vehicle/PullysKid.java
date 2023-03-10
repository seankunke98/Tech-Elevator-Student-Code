package com.vehicle;

import com.techelevator.farm.Tractor;

public class PullysKid extends Tractor {

    public PullysKid(String name) {
        super(name);
        speed = 5;
    }

    @Override
    public String turn(String direction) {
        if(speed > 2){
            System.out.println("blink hazards");
        }
        return super.turn(direction);
    }
}
