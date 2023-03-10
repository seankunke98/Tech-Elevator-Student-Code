package com.vehicle;

public class Motorcycle implements Vehicle {

    int speed;


    @Override
    public String turn(String direction) {
        System.out.println("lean towards " + direction);
        if(speed > 25 && direction.equals("left")){
            return "press on left side of handlebars";
        } else if(speed > 25 && direction.equals("right")){
            return "press on right side of handlebars";
        }
        return "turn handlebars towards " + direction;
    }

    @Override
    public void accelerate() {
        System.out.println("twist the throttle");
        speed++;
    }

    @Override
    public String toString() {
        return "Rolly{" +
                "speed=" + speed +
                '}';
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
