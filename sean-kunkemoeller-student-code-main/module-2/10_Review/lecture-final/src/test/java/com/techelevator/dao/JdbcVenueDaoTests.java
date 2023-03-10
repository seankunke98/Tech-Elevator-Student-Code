package com.techelevator.dao;


import com.techelevator.model.State;
import com.techelevator.model.Venue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class JdbcVenueDaoTests extends BaseDaoTests {

    private static final List<String> VENUE_1_CATEGORIES = List.of("Family Friendly", "Historic");
    private static final List<String> VENUE_2_CATEGORIES = List.of();
    private static final List<String> VENUE_3_CATEGORIES = List.of("Family Friendly", "Outdoors", "Historic");
    private static final Venue VENUE_1 = new Venue(1, "Hidden Owl Eatery", "This venue has plenty of \"property\" to enjoy. Roll the dice and check out all of our spaces.", "Bona", "MI", VENUE_1_CATEGORIES);
    private static final Venue VENUE_2 = new Venue(2, "Painted Squirrel Club", "Lock in your reservation now! This venue has dungeons and an underground theme. Not for the faint of heart!", "Bona", "MI", VENUE_2_CATEGORIES);
    private static final Venue VENUE_3 = new Venue(3, "Rusty Farmer Spot", "This rustic and seasonal spot is fun year-round. Great for equinox celebrations!", "Bona", "MI", VENUE_3_CATEGORIES);

    private VenueDao sut;

    @Before
    public void setup() {
        sut = new JdbcVenueDao(dataSource);
    }

    @Test
    public void list_returns_all_venues() {
        List<Venue> venue = sut.listVenues();
        Assert.assertEquals(3, venue.size());
    }

    @Test
    public void venue_object_populated_in_list() {
        List<Venue> venues = sut.listVenues();
        assertVenuesMatch(VENUE_1, venues.get(2));
        assertVenuesMatch(VENUE_2, venues.get(1));
        assertVenuesMatch(VENUE_3, venues.get(0));
    }

    @Test
    public void get_venue_by_venue_id() {
        Venue returnedVenue = sut.getVenueById(1);
        assertVenuesMatch(VENUE_1, returnedVenue);
    }

    @Test
    public void get_venue_by_id_returns_null_when_not_found() {
        Assert.assertNull(sut.getVenueById(100));
    }

    private void assertVenuesMatch(Venue expected, Venue actual){
        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.getDescription(), actual.getDescription());
        Assert.assertEquals(expected.getCity(), actual.getCity());
        Assert.assertEquals(expected.getState().getAbbreviation(), actual.getState().getAbbreviation());
        Assert.assertEquals(expected.getCategories().size(), actual.getCategories().size());
    }

}
