package com.techelevator.dao;

import com.techelevator.model.State;
import com.techelevator.model.Venue;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcVenueDao implements VenueDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcVenueDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Venue> listVenues() {
        List<Venue> venues = new ArrayList<Venue>();

        String sql = "SELECT venue.id, venue.name, venue.description, city.name AS city_name, " +
                "state.abbreviation, state.name AS state_name " +
                "FROM venue " +
                "JOIN city ON venue.city_id = city.id " +
                "JOIN state ON city.state_abbreviation = state.abbreviation";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while( results.next() ) {
            venues.add(mapRowToVenue(results));
        }

        return venues;
    }

    public Venue getVenueById(int id) {

        Venue venue = null;
        String sql = "SELECT venue.id, venue.name, venue.description, city.name AS city_name, " +
                "state.abbreviation, state.name AS state_name " +
                "FROM venue " +
                "JOIN city ON venue.city_id = city.id " +
                "JOIN state ON city.state_abbreviation = state.abbreviation " +
                "WHERE venue.id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        if (results.next()) {
            venue = mapRowToVenue(results);
        }

        return venue;

    }

    private List<String> getCategoriesForVenue(int venueId) {
        List<String> categories = new ArrayList<String>();

        String sql = "SELECT name " +
                "FROM category_venue " +
                "JOIN category ON category_venue.category_id = category.id " +
                "WHERE category_venue.venue_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, venueId);

        while( results.next() ) {
            categories.add( results.getString("name") );
        }

        return categories;
    }

    private Venue mapRowToVenue(SqlRowSet row) {
        Venue venue = new Venue();
        venue.setId( row.getInt("id") );
        venue.setName( row.getString("name") );
        venue.setDescription( row.getString("description") );
        venue.setCity( row.getString("city_name") );

        State state = new State();
        state.setAbbreviation( row.getString("abbreviation") );
        state.setName( row.getString("state_name") );
        venue.setState( state );

        venue.setCategories( getCategoriesForVenue( venue.getId() ) );
        return venue;
    }

}
