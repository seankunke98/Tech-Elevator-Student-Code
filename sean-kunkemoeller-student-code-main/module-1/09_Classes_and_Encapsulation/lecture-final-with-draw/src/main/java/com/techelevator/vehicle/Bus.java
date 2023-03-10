package com.techelevator.vehicle;

public class Bus {
    //member variables

     private int numOfPassengers;
     private boolean isDoorOpen = false;
     private int gallonsOfGas = 40;
     private String routeName;

     private static final int NUMBER_OF_SEATS = 40;


     //this constructor requires a string for the route - so we overload the constructor
     public Bus(String routeName){
          this.routeName = routeName;
          gallonsOfGas = 50;
     }
     //because we added a constructor, we no longer have the default constructor
     //so we add an empty constructor / no arg constructor
     public Bus(){

     }

     //getters and setters:
     public String getRouteName(){
          return this.routeName;
     }

     public void setRouteName(String routeName){
          this.routeName = routeName;
     }

     public boolean isDoorOpen(){
          return this.isDoorOpen;
     }

     public int getGallonsOfGas(){
          return this.gallonsOfGas;
     }

     //derived property getRemainingSeats that is based off of seats on bus - num of Passengers
     public int getRemainingSeats(){
          return NUMBER_OF_SEATS - numOfPassengers;
     }



     //Methods

     public void addGas(int gallonsOfGas){
          this.gallonsOfGas += gallonsOfGas;
     }

     //overload addGas()
     public void addGas(int gallonsOfGas, int milesTraveled){
          //do something
     }

     public void addGas(int gallonsOfGas, boolean areYouHappy){
          //do something
     }


     public void openDoor(){
          //maybe we would have some qualifiers before we try to open the door
          //like bus is stopped
          this.isDoorOpen = true;
     }

     public void closeDoor(){
          //maybe we would have some qualifiers before we try to shut the door
          this.isDoorOpen = false;
     }

}
