package com.techelevator;

import com.techelevator.dao.*;
import com.techelevator.model.*;
import com.techelevator.view.Menu;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class USCitiesAndParksCLI {



    private final StateDao stateDao;
    private final CityDao cityDao;
    private final ParkDao parkDao;
    private Menu menu;

    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/UnitedStates");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        USCitiesAndParksCLI application = new USCitiesAndParksCLI(dataSource);
        application.run();
    }

    public USCitiesAndParksCLI(DataSource dataSource) {
        stateDao = new JdbcStateDao(dataSource);
        cityDao = new JdbcCityDao(dataSource);
        parkDao = new JdbcParkDao(dataSource);
        menu = new Menu();
    }

    private void run() {
        menu.displayBanner();
        boolean running = true;
        while (running) {
            menu.displayMenu();
            int selection = menu.promptForInt("Please select an option: ");
            if (selection == 1) {
                manageCityInfo();
            } else if (selection == 2) {
                addNewCity();
            }else if (selection == 3) {
                manageParkInfo();
            } else if (selection == 4) {
                addNewPark();
            } else if (selection == 5) {
                running = false;
            } else {
               menu.displayError("Invalid option selected.");
            }
        }
    }

    private void manageParkInfo() {
        Park park = promptForPark();
        System.out.println();
        menu.displayPark(park);
        String response = menu.promptForString("(U)pdate this park, (D)elete this park, or press Enter to continue: ");
        if (response.equalsIgnoreCase("U")) {
            updatePark(park);
        } else if (response.equalsIgnoreCase("D")) {
            deletePark(park);
        }
    }

    private void manageCityInfo() {
        City city = promptForCity();
        menu.displayCity(city);
        String response = menu.promptForString("(U)pdate this city, (D)elete this city, or press Enter to continue: ");
        if (response.equalsIgnoreCase("U")) {
            updateCity(city);
        } else if (response.equalsIgnoreCase("D")) {
            deleteCity(city);
        }
    }

    private void updateCity(City cityToUpdate) {
        String newName = menu.promptForString("New name (enter to leave unchanged): ");
        if (!newName.isBlank()) {
            cityToUpdate.setCityName(newName);
        }
        int newPopulation = menu.promptForInt("New population (enter to leave unchanged): ");
        if (newPopulation >= 0) {
            cityToUpdate.setPopulation(newPopulation);
        }
        double newArea = menu.promptForDouble("New area (enter to leave unchanged): ");
        if (newArea >= 0) {
            cityToUpdate.setArea(newArea);
        }

        cityDao.updateCity(cityToUpdate);
        menu.displayUpdatedCity(cityToUpdate);

    }

    private void updatePark(Park parkToUpdate) {
        String newName = menu.promptForString("New name (enter to leave unchanged): ");
        if (!newName.isBlank()) {
            parkToUpdate.setParkName(newName);
        }
        LocalDate newDateEstablished = menu.promptForDate("New date established (YYYY-MM-DD or enter to leave unchanged): ");
        if (newDateEstablished != null) {
            parkToUpdate.setDateEstablished(newDateEstablished);
        }
        double newArea = menu.promptForDouble("New area (enter to leave unchanged): ");
        if (newArea >= 0) {
            parkToUpdate.setArea(newArea);
        }
        String reply = menu.promptForString("Does the park offer camping (Y/N or enter to leave unchanged)? ");
        if (reply.equalsIgnoreCase("Y")) {
            parkToUpdate.setHasCamping(true);
        } else if (reply.equalsIgnoreCase("N")) {
            parkToUpdate.setHasCamping(false);
        }

        parkDao.updatePark(parkToUpdate);
        System.out.format("\nUpdated %s\n\n", parkToUpdate);
    }

    private void deletePark(Park parkToDelete) {
        parkDao.deletePark(parkToDelete.getParkId());
        System.out.format("\nDeleted %s\n\n", parkToDelete);
    }

    private void addNewPark() {
        Park newPark = menu.promptForNewParkData();

        newPark = parkDao.createPark(newPark);
        menu.displayMessage("\nAdded the following park to the database:");
        menu.displayPark(newPark);

        String stateAbbrs = "";
        while (stateAbbrs.isBlank()) {
            stateAbbrs = menu.promptForString("List of abbreviations for the states this park is located in (separated by commas): ");
        }
        stateAbbrs = stateAbbrs.trim().toUpperCase();
        for (String stateAbbr : stateAbbrs.split(", *")) {
            State state = stateDao.getState(stateAbbr);
            if (state != null) {
                parkDao.addParkToState(newPark.getParkId(), state.getStateAbbreviation());
                menu.printAddedPark(newPark,state);
            }
        }
        System.out.println();
    }


    private void deleteCity(City cityToDelete) {
        State state = stateDao.getStateByCapital(cityToDelete.getCityId());
        if (state != null) {
           menu.displayError("Cannot delete capital of " + state.getStateName());
        } else {
            cityDao.deleteCity(cityToDelete.getCityId());
            menu.displayDeletedCity(cityToDelete);

        }
    }

    private void addNewCity() {
        City newCity = promptForNewCityData();
        newCity = cityDao.createCity(newCity);
        menu.displayMessage("\nAdded the following city to the database:");
        menu.displayCity(newCity);
    }

    private Park promptForPark() {
        List<Park> parks = new ArrayList<>();
        while (parks.size() == 0) {
            menu.displayMessage("What state is the park in?");
            State state = promptForState();
            parks = parkDao.getParksByState(state.getStateAbbreviation());
            if (parks.size() == 0) {
                menu.displayError("No parks in selected state.");
            }
        }
        menu.printParks(parks);

        while (true) {
            try {
                int selection = menu.promptForInt("Please select a park: ");
                return parks.get(selection - 1);
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                menu.displayError("Invalid selection.");
            }
        }
    }

    public City promptForCity() {
        List<City> cities = new ArrayList<>();

        while (cities.size() == 0) {
            menu.displayMessage("What state is the city in?");

            State state = promptForState();
            cities = cityDao.getCitiesByState(state.getStateAbbreviation());
            if (cities.size() == 0) {
                menu.displayError("No cities in selected state.");
            }
        }
        menu.displayCities(cities);

        while (true) {
            try {
                int selection = menu.promptForInt("Please select a city: ");
                return cities.get(selection - 1);
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                menu.displayError("Invalid selection.");
            }
        }
    }

    private City promptForNewCityData() {
        City city = new City();

        String name = "";
        while (name.isBlank()) {
            name = menu.promptForString("City name: ");
        }
        city.setCityName(name);
        int population = -1;
        while (population < 0) {
            population = menu.promptForInt("Population: ");
        }
        city.setPopulation(population);
        double area = -1;
        while (area < 0) {
            area = menu.promptForDouble("Area (in sq. km.): ");
        }
        city.setArea(area);

        System.out.println("What state is this city in?");
        State state = promptForState();
        city.setStateAbbreviation(state.getStateAbbreviation());

        return city;
    }
    private State promptForState() {
        while (true) {
            String response = menu.promptForString("Please enter a state abbreviation (enter ? to list state abbreviations): ");

            if (response.equals("?")) {
                for (State state : stateDao.getStates()) {
                    menu.displayStateFromList(state);
                }
            } else {
                State result = stateDao.getState(response.toUpperCase());
                if (result == null) {
                    menu.displayError("Invalid state abbreviation.");
                } else {
                    return result;
                }
            }
        }
    }


}
