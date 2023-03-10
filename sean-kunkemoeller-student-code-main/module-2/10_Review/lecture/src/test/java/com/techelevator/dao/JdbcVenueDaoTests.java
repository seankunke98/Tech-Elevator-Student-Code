package com.techelevator.dao;

import com.techelevator.model.Venue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class JdbcVenueDaoTests extends BaseDaoTests {



    Venue testVenue;
    private JdbcVenueDao sut;

    @Before
    public void setup() {
        sut = new JdbcVenueDao(dataSource);
    }

    @Test
    public void getVenue_returns_correct_venue_for_id() {
        Venue venue = sut.getVenue(1);

    }

    @Test
    public void getVenue_returns_null_when_id_not_found(){
        Venue venue = sut.getVenue(18);
        Assert.assertNull(venue);

    }

    @Test
    public void getAllVenues_correctly_returns_all_venues(){
        List<Venue> venueList = sut.getAllVenues();
        Assert.assertEquals(3, venueList.size());

    }

    private void assertVenuesMatch(Venue expected, Venue actual){
        Assert.assertEquals(expected.getVenueId(), actual.getVenueId());
        Assert.assertEquals(expected.getVenueName(), actual.getVenueName());
        Assert.assertEquals(expected.getCityId(), actual.getCityId());
        Assert.assertEquals(expected.getDescription(), actual.getDescription());
    }

}
