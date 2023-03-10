package com.techelevator;

public class RectangleWall extends Wall {
    private int height;
    private int length;
    public RectangleWall(String name, String color, int length, int height) {
        super(name, color);
        this.height = height;
        this.length = length;
    }
    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }
    @Override
    public int getArea() {
        return getHeight() * getLength();
    }

    @Override
    public String toString() {

        return getName() + " (" + getLength() + "x" + getHeight() + ") " + "rectangle";
    }
}
