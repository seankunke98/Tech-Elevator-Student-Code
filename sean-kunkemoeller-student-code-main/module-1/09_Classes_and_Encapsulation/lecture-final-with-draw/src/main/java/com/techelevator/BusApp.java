package com.techelevator;

import com.techelevator.vehicle.Bus;

public class BusApp {

    public static void main(String[] args){
        /*
        Instantiate a bus
         */
        Bus bussie = new Bus();
        bussie.setRouteName("matrix");
        boolean isBussiesDoorOpen = bussie.isDoorOpen();
        System.out.println(bussie.getRouteName());

        Bus busso = new Bus("cat-mando");

        System.out.println("Busso is heading to: " + busso.getRouteName() );

        System.out.println(bussie.getRemainingSeats());
        System.out.println(busso.getRemainingSeats());


        System.out.println(bussie.getRemainingSeats());
        System.out.println(busso.getRemainingSeats());

        Bus lateBus = new Bus();
        System.out.println("Late Bus remaining seats: " + lateBus.getRemainingSeats());
        whenShouldClassEnd();
    }

    private static int whenShouldClassEnd(){
        return 1300;
    }
}
