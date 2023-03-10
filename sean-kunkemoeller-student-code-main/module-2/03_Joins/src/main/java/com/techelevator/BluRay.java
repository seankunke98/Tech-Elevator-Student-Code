package com.techelevator;

public class BluRay extends MovieRental {
    private double rentalPrice = 2.99;

    public BluRay(String title, String format, boolean isPremiumMovie) {
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
