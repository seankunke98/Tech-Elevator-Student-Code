package com.techelevator.view;

import com.techelevator.dao.CityDao;
import com.techelevator.dao.ParkDao;
import com.techelevator.dao.StateDao;
import com.techelevator.model.City;
import com.techelevator.model.Park;
import com.techelevator.model.State;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private final Scanner userInput = new Scanner(System.in);

    public void displayBanner() {
        System.out.println("-----------------------------------------");
        System.out.println("|  US Cities and Parks Data Management  |");
        System.out.println("-----------------------------------------");
    }

    public void displayMenu() {
        System.out.println("1. View or modify city information");
        System.out.println("2. Add new city");
        System.out.println("3. View or modify park information");
        System.out.println("4. Add new park");
        System.out.println("5. Exit");
    }

    public void displayMessage(String message){
        System.out.println(message);
    }

    public void displayError(String message) {
        System.out.println();
        System.out.println("***" + message + "***");
        System.out.println();
    }

    public void displayUpdatedCity(City cityToUpdate){
        System.out.format("\nUpdated %s\n\n", cityToUpdate);
    }

    public void displayDeletedCity(City cityToDelete){
        System.out.format("\nDeleted %s\n\n", cityToDelete);
    }
    public void displayCity(City city) {
        System.out.println(city);
        System.out.format("Population: %d Area: %.1f sq. km\n\n", city.getPopulation(), city.getArea());
    }

    public String promptForString(String prompt) {
        System.out.print(prompt);
        return userInput.nextLine();
    }

    public int promptForInt(String prompt) {
        return (int) promptForDouble(prompt);
    }

    public double promptForDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String response = userInput.nextLine();
            try {
                return Double.parseDouble(response);
            }  catch (NumberFormatException e) {
                if (response.isBlank()) {
                    return -1; //Assumes negative numbers are never valid entries.
                } else {
                    displayError("Numbers only, please.");
                }
            }
        }
    }


    public LocalDate promptForDate(String prompt) {
        while (true) {
            System.out.print(prompt);
            String response = userInput.nextLine();
            try {
                return LocalDate.parse(response);
            }  catch (DateTimeParseException e) {
                if (response.isBlank()) {
                    return null;
                } else {
                    displayError("Please format as YYYY-MM-DD.");
                }
            }
        }
    }



    public void displayPark(Park park) {
        System.out.println(park);
        System.out.format("Established: %s Area: %.1f sq. km\n", park.getDateEstablished(), park.getArea());
        System.out.format("This park %s camping.\n\n", park.getHasCamping()? "offers" : "does not offer");
    }







    public Park promptForNewParkData() {
        Park park = new Park();

        String name = "";
        while (name.isBlank()) {
            name = promptForString("Park name: ");
        }
        park.setParkName(name);
        LocalDate dateEstablished = null;
        while (dateEstablished == null) {
            dateEstablished = promptForDate("Date established (YYYY-MM-DD): ");
        }
        park.setDateEstablished(dateEstablished);
        double area = -1;
        while (area < 0) {
            area = promptForDouble("Area (in sq. km.): ");
        }
        park.setArea(area);
        String reply = promptForString("Does this park offer camping (Y/N)? ");
        park.setHasCamping(reply.equalsIgnoreCase("Y"));

        return park;
    }

    public void displayStateFromList(State state) {
        System.out.println(state.getStateAbbreviation() + "   " + state.getStateName());
    }

    public void printParks(List<Park> parks) {
        for (int i = 0; i < parks.size(); i++) {

            System.out.format("%3d. %s\n", i + 1, parks.get(i).getParkName());
        }
    }

    public void printAddedPark(Park newPark, State state) {
        System.out.format("Added %s to %s.\n", newPark.getParkName(), state.getStateName());
    }

    public void displayCities(List<City> cities) {
        for (int i = 0; i < cities.size(); i++) {
            System.out.format("%3d. %s\n", i + 1, cities.get(i).getCityName());
        }
    }
}
