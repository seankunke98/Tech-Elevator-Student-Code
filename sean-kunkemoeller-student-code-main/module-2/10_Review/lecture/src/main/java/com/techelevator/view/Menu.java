package com.techelevator.view;



import com.techelevator.model.Venue;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private static final Scanner userInput = new Scanner(System.in);

    public String getSelectionFromMainMenu() {
        System.out.println("What would you like to do?");
        System.out.println("1) List Venues");
        System.out.println("Q) Quit");

        String userSelection = "";
        while(true) {
            userSelection = userInput.nextLine();
            if ( userSelection.equalsIgnoreCase("1") ||
                    userSelection.equalsIgnoreCase("Q") ) {
                break;
            }
            System.out.println("Incorrect input, try again!");
        }

        return userSelection;

    }

    public void showListOfVenues(List<Venue> venueList) {
        System.out.println("Printing venues:");
        for (int i = 0; i < venueList.size(); i++) {
            System.out.println( (i + 1) + ") " + venueList.get(i));
        }

    }

    public int getSelectedVenueFromUser() {
        int venueIndex = 0;
        while (true) {
            System.out.println();
            System.out.print("Selected Venue >>>");
            String index = userInput.nextLine();
            try {
                venueIndex = Integer.parseInt(index);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Venue not found, please try again.");
            }
        }
        return venueIndex;
    }

//    public void showVenue(Venue returnedVenue) {
//        System.out.println(returnedVenue.getName());
//        System.out.println("Location: " + returnedVenue.getState().getName());
//        System.out.println("Categories: " + String.join(",", returnedVenue.getCategories()));
//        System.out.println();
//        System.out.println(returnedVenue.getDescription());
//    }


}
