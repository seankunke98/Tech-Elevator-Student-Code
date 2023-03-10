package com.techelevator.view;

import com.techelevator.dao.CityDao;
import com.techelevator.dao.StateDao;
import com.techelevator.model.City;
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
        System.out.println("3. Exit");
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

    public State promptForState(StateDao stateDao) {
        while (true) {
            System.out.print("Please enter a state abbreviation (enter ? to list state abbreviations): ");
            String response = userInput.nextLine();
            if (response.equals("?")) {
                for (State state : stateDao.getStates()) {
                    System.out.println(state.getStateAbbreviation() + "   " + state.getStateName());
                }
            } else {
                State result = stateDao.getState(response.toUpperCase());
                if (result == null) {
                    displayError("Invalid state abbreviation.");
                } else {
                    return result;
                }
            }
        }
    }

    public City promptForCity(CityDao cityDao, StateDao stateDao) {
        List<City> cities = new ArrayList<>();
        System.out.println();
        while (cities.size() == 0) {
            System.out.println("What state is the city in?");
            State state = promptForState(stateDao);
            cities = cityDao.getCitiesByState(state.getStateAbbreviation());
            if (cities.size() == 0) {
                displayError("No cities in selected state.");
            }
        }
        for (int i = 0; i < cities.size(); i++) {
            System.out.format("%3d. %s\n", i + 1, cities.get(i).getCityName());
        }
        while (true) {
            try {
                int selection = promptForInt("Please select a city: ");
                return cities.get(selection - 1);
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                displayError("Invalid selection.");
            }
        }
    }
    public City promptForNewCityData(StateDao stateDao) {
        City city = new City();

        String name = "";
        while (name.isBlank()) {
            name = promptForString("City name: ");
        }
        city.setCityName(name);
        int population = -1;
        while (population < 0) {
            population = promptForInt("Population: ");
        }
        city.setPopulation(population);
        double area = -1;
        while (area < 0) {
            area = promptForDouble("Area (in sq. km.): ");
        }
        city.setArea(area);

        System.out.println("What state is this city in?");
        State state = promptForState(stateDao);
        city.setStateAbbreviation(state.getStateAbbreviation());

        return city;
    }
}
