package com.techelevator;

import javax.sql.DataSource;

import com.techelevator.dao.JdbcVenueDao;
import com.techelevator.dao.VenueDao;
import com.techelevator.model.Venue;
import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.view.Menu;

import java.util.List;


public class ExcelsiorCLI {


    private Menu menu = new Menu();
    VenueDao venueDao;

    public ExcelsiorCLI(DataSource datasource) {
        venueDao = new JdbcVenueDao(datasource);
    }

    public void run() {

        while(true) {
            String userChoice = menu.getSelectionFromMainMenu();

            if (userChoice.equals("1")) {
                List<Venue> venueList = venueDao.listVenues();
               menu.showListOfVenues(venueList);
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
