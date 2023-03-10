package com.vehicle;

import com.techelevator.farm.Tractor;

import java.util.ArrayList;
import java.util.List;

public class Roadway {

    public static void main(String[] args){

        Bike huffy = new Bike();
        Motorcycle rolly = new Motorcycle();
        Tractor pully = new Tractor("Pully");

        rolly.setSpeed(30);
        String rollyToString = rolly.toString();

        PullysKid tuggy = new PullysKid("Tuggy");

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(huffy);
        vehicles.add(rolly);
        vehicles.add(pully);
        vehicles.add(tuggy);

        for(Vehicle vehicle : vehicles){
            System.out.println("----------");
            System.out.println(vehicle + vehicle.turn("right"));
        }
    }

}
