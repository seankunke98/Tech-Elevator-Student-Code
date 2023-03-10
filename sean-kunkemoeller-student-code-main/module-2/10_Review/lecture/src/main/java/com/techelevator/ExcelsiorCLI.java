package com.techelevator;

import javax.sql.DataSource;
import com.techelevator.dao.*;
import com.techelevator.model.*;
import com.techelevator.dao.VenueDao;
import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.view.Menu;
import javax.sql.DataSource;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class ExcelsiorCLI {


    private final VenueDao venueDao;
    private Menu menu = new Menu();

    public ExcelsiorCLI(DataSource datasource) {
        venueDao = new JdbcVenueDao(datasource);
        menu = new Menu();

    }

    public void run() {

        while(true) {
            String userChoice = menu.getSelectionFromMainMenu();

            if (userChoice.equals("1")) {
                menu.showListOfVenues(venueDao.getAllVenues());
            } else if (userChoice.equalsIgnoreCase("Q")) {
                break;
            }
        }

    }

    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/excelsior_venues");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        ExcelsiorCLI application = new ExcelsiorCLI(dataSource);
        application.run();
    }
}
