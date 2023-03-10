package com.vehicle;

public class Motorcycle implements Vehicle{

    private int speed;

    @Override
    public String turn(String direction) {
        System.out.println("lean towards " + direction);
        if(speed > 25 && direction.equals("left")){
          return "press on left side of handle";
        } else if(speed > 25 && direction.equals("right")){
            return "press on right side of handle";
        }
        return "turn handle bars towards " + direction;
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "speed=" + speed +
                '}';
    }

    @Override
    public void accelerate() {
        System.out.println("twist the throttle");
        speed++;
    }


    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
