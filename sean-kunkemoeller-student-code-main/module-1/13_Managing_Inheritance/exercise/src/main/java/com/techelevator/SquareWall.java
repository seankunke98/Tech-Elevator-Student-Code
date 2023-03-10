package com.techelevator;

public class SquareWall extends RectangleWall {
    private int sideLength;



    public SquareWall(String name, String color, int sideLength) {
        super(name, color, sideLength, sideLength);
        this.sideLength = sideLength;
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public int getSideLength(){
        return sideLength;
    }

    @Override
    public int getArea() {
        return getHeight() * getLength();
    }

    @Override
    public String toString() {

        return getName() + " (" + getSideLength() + "x" + getSideLength() + ") " + "square";
    }
}
