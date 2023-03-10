package com.techelevator;

import java.util.Scanner;

class DiscountCalculator {

    /**
     * The main method is the start and end of our program
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Discount Calculator");

        // Prompt the user for a discount amount
        // The answer needs to be saved as a double
        System.out.print("Enter the discount amount (w/out percentage): ");

        String discountAmountFromUser = scanner.nextLine(); //"20"
        double discountAmount = Double.parseDouble(discountAmountFromUser);

        // Prompt the user for a series of prices
        System.out.print("Please provide a series of prices (space separated): ");

        String pricesFromUser= scanner.nextLine(); // "100 200 1000"
        String[] pricesArray = pricesFromUser.split(" ");

        //take prices entered and apply discount and return discounted price
        double[] priceArrayAsDoubles = new double[pricesArray.length];
        //loop over pricesArray
        for(int i = 0; i < pricesArray.length; i++) {
            priceArrayAsDoubles[i] = Double.parseDouble(pricesArray[i]);
        }
        String measurementScale = "F";
        if(measurementScale.equalsIgnoreCase("F")){

        }

            //convert discountAmount from user to decimal value
//            double discountAmountDecimal = discountAmount / 100; //.2
            //multiply decimal amount by price
//            double amountToRemoveFromPrice = priceArrayAsDoubles[i] * discountAmountDecimal; //100 * .2
            //subtract amount from price
//            double discountedPrice = priceArrayAsDoubles[i] - amountToRemoveFromPrice; //100 -20
//            System.out.println(discountedPrice); //80

            //shortened version of above, for(int i = 0; i < pricesArray.length; i++)
                //double amountToRemove = ((discountAmount / 100) * Double.parseDouble(pricesArray[i]))
                //System.out.println(Double.parseDouble(pricesArray[i]) - amountToRemove);

    }

}