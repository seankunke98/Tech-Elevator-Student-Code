package com.techelevator.dao;

import com.techelevator.model.City;

import java.util.List;

public interface CityDao {
    //C
    City getCity(int cityId);
    //R
    List<City> getCitiesByState(String stateAbbreviation);

    City createCity(City city);
    //U
    void updateCity(City city);
    //D
    void deleteCity(int cityId);
}
