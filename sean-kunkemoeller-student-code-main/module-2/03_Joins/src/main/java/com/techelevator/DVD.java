package com.techelevator;

public class DVD extends MovieRental {

    private double rentalPrice = 1.99;

    public DVD(String title, String format, boolean isPremiumMovie) {
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
