package com.techelevator;

import com.techelevator.vehicle.Bus; //imported class created before

public class BusApp {

    public static void main(String[] args){ //void does not return anything, static allows you to access a class
        //instantiate a bus;
        Bus bussie = new Bus();
        bussie.setRouteName("matrix");
        boolean isBussieDoorOpen = bussie.isDoorOpen();
        System.out.println(bussie.getRouteName());

        Bus busso = new Bus("Bozoland");

        System.out.println("Busso is heading to: " + busso.getRouteName());

        System.out.println(bussie.getRemainingSeats());
        System.out.println(busso.getRemainingSeats());



        System.out.println(bussie.getRemainingSeats());
        System.out.println(busso.getRemainingSeats());

        Bus lateBus = new Bus();
        System.out.println("Late Bus Remaining Seats: " + lateBus.getRemainingSeats());
    whenShouldClassEnd();
    }
    private static int whenShouldClassEnd(){
        return 1300;
    }
}
