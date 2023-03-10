package com.techelevator.dao;

import com.techelevator.model.Venue;

import java.util.List;

public interface VenueDao {

    List<Venue> listVenues();
    Venue getVenueById(int id);
}
