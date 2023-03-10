package com.techelevator;

public class Elevator {
    //data members:
    private int currentFloor = 1;
    private int numberOfFloors;
    private boolean doorOpen;


    public Elevator(int totalNumberOfFloors) {
        this.numberOfFloors = totalNumberOfFloors;
    }
    //method:
    public void openDoor() {
        doorOpen = true;
    }
    public void closeDoor() {
        doorOpen = false;
    }
    public void goUp(int desiredFloor) {
        if (!doorOpen){
            if (desiredFloor <= numberOfFloors) {
                if (desiredFloor > currentFloor) {
                    currentFloor = desiredFloor;
                }
            }
        }
    }
    public void goDown(int desiredFloor) {
        if (doorOpen != true) {
            if (desiredFloor >=1 ) {
                if (desiredFloor < currentFloor){
                    currentFloor = desiredFloor;
                }
            }
        }
    }
    //getters:

    public int getCurrentFloor() {
        return currentFloor;
    }
    public int getNumberOfFloors() {
        return numberOfFloors;
    }
    public boolean isDoorOpen() {
        return doorOpen;
    }

}
