package com.techelevator.dao;

import com.techelevator.model.City;

import java.util.List;

public interface CityDao {
    //C
    City createCity(City city);
    //R
    City getCity(int cityId);

    List<City> getCitiesByState(String stateAbbreviation);

    //U
    void updateCity(City city);
    //D
    void deleteCity(int cityId);
}
