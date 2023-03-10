package com.techelevator.dao;

import com.techelevator.model.Category;
import com.techelevator.model.City;
import com.techelevator.model.Venue;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcVenueDao implements VenueDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcVenueDao(DataSource dataSource){ this.jdbcTemplate = new JdbcTemplate(dataSource); }

    @Override
    public Venue getVenue(int venueId) {
        Venue venue = null;
        String sql = "SELECT id, name, city_id, description FROM venue WHERE id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, venueId);
        if(results.next()){
            venue = mapRowToVenue(results);
        }
        return venue;
    }

    @Override
    public List<Venue> getAllVenues() {
        List<Venue> venueList = new ArrayList<>();
        String sql = "SELECT venue.id, venue.name, description, city.name, city.state_abbreviation, category.name \n" +
                "FROM venue JOIN city ON venue.city_id = city.id\n" +
                "\tJOIN category_venue ON venue.id = category_venue.venue_id\n" +
                "\t\tJOIN category ON category_venue.category_id = category.id\n" +
                "ORDER BY venue.name";
        SqlRowSet results  = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            venueList.add(mapRowToVenue(results));
        }
        return venueList;
    }

    private Venue mapRowToVenue(SqlRowSet rowSet){
        Venue venue = new Venue();
        venue.setVenueId(rowSet.getInt("id"));
        venue.setVenueName(rowSet.getString("venue.name"));
        venue.setCityId(rowSet.getInt("city_id"));
        venue.setDescription(rowSet.getString("description"));


        return venue;
    }
}
