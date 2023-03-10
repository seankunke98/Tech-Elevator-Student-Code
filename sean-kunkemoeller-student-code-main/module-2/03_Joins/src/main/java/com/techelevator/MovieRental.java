package com.techelevator;

public class MovieRental {
    private String title;
    private String format;
    private boolean isPremiumMovie;
    private double rentalPrice;
    double lateFee;

    public MovieRental(String title, String format, boolean isPremiumMovie){
        this.title = title;
        this.format = format;
        this.isPremiumMovie = isPremiumMovie;
    }

    public String getTitle() {
        return title;
    }

    public double getRentalPrice() {
        if(format == "VHS" && isPremiumMovie){
            rentalPrice = 1.99;
        } else if(format == "DVD" && isPremiumMovie){
            rentalPrice = 2.99;
        } else if(format == "Blu_ray" && isPremiumMovie){
            rentalPrice = 3.99;
        } else if(format == "VHS"){
            rentalPrice = .99;
        } else if(format == "DVD"){
            rentalPrice = 1.99;
        } else if(format == "Blu_ray"){
            rentalPrice = 2.99;
        }
        return rentalPrice + lateFee;
    }
    public void isLate(int daysLate){
        if(daysLate == 0){
            lateFee = 0;
        } else if (daysLate == 1){
            lateFee = 1.99;
        } else if (daysLate == 2){
            lateFee = 3.99;
        } else if (daysLate >= 3){
            lateFee = 19.99;
        }
    }



    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setPremiumMovie(boolean premiumMovie) {
        isPremiumMovie = premiumMovie;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Movie {" + title + "}" + " {" + format + "} " + "{" + rentalPrice + "}";
    }

}
