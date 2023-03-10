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
            } else if(selection == 3){
                running = false;
            } else {
               menu.displayError("Invalid option selected.");
            }
        }
    }

    private void manageCityInfo() {
        City city = menu.promptForCity(cityDao, stateDao);
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
        City newCity = menu.promptForNewCityData(stateDao);
        newCity = cityDao.createCity(newCity);
        menu.displayMessage("\nAdded the following city to the database:");
        menu.displayCity(newCity);
    }


}
