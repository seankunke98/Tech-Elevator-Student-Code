package com.techelevator;

public class Cake {

    //state aka what it knows about its self
    private String icingColor;
    private boolean hasSprinkles;

    //behavior aka what it can do
    public String getIcingColor(){
        return icingColor;
    }

    public void setIcingColor(String icingColor){
        this.icingColor = icingColor;
    }
    public boolean isHasSprinkles(){
        return hasSprinkles;
    }
    public void setHasSprinkles(boolean hasSprinkles){
        this.hasSprinkles = hasSprinkles;
    }
}
