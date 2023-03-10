package com.techelevator.vehicle;

public class Bus {


    //write member variables:
    /* routeName
    numOfPassengers
    gallonsOfGas
    isDoorOpen
     */

    private int numOfPassengers; //member variable
    private boolean isDoorOpen; //default of boolean is false
    private int gallonsOfGas = 50;
    private String routeName;
    private static final int NUMBER_OF_SEATS = 40;

    //this constructor requires a string for the route - so we overload the constructor
    public Bus(String routeName){
        this.routeName = routeName; //whenever you give a route name it will create a new bus with that routeName
    }
    //because we added a constructor we no longer have the default constructor
    //so we add an empty one / no argument constructor
    public Bus() {

    }

    //give access to routeName
    //getters and setters:
    public String getRouteName(){
        return this.routeName;   //getter method to retrieve routeName in another class
    }
    //give permission to update the value of routeName
    //with a setter
    public void setRouteName(String routeName){
        this.routeName = routeName; //updated private member variable with what was passed in from BusApp method
    }
    public boolean isDoorOpen(){
        return isDoorOpen;
    }
    public int getGallonsOfGas(){
        return this.gallonsOfGas;
    }
    public void addGas(int gallonsOfGas){
        this.gallonsOfGas += gallonsOfGas; //increases gallonsOfGas when input is added
    }
    public void openDoor(){
        this.isDoorOpen = true;
    }
    public void closeDoor(){
        //maybe we would have some qualifiers before we try to shut the door
        this.isDoorOpen = false;
    }
    //derived property getRemainingSeats that is based off of seats on bus - numOfPassengers
    public int getRemainingSeats(){
        return NUMBER_OF_SEATS - numOfPassengers;
    }

    //what a bus can do - methods
 public void addGas(int gallonsOfGas, boolean )
    }


}
