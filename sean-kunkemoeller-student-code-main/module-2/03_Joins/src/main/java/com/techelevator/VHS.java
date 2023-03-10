package com.techelevator;

public class VHS extends MovieRental {
    private double rentalPrice = 0.99;


    public VHS(String title, String format, boolean isPremiumMovie) {
        super(title, format, isPremiumMovie);
    }


    @Override
    public double getRentalPrice() {
        return rentalPrice;
    }


    @Override
    public String toString() {
        return "MOVIE -" +
                " {" + getTitle() + "} " + " {" + getFormat() + "} " + rentalPrice
                ;
    }
}
