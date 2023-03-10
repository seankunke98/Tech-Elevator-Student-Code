package com.techelevator.dao;

import com.techelevator.model.City;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcCityDao implements CityDao {

    private final JdbcTemplate jdbcTemplate;

    //In the constructor we accept the datasource which has been set elsewhere in the project (in this case, in the CLI)
    //The datasource defines the connection to the database
    public JdbcCityDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public City getCity(int cityId) {
        City city = new City();
        String sql = "SELECT city_id, city_name, state_abbreviation, population, area FROM city WHERE city_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, cityId);
        if(result.next()){
            city = mapRowToCity(result);
        }
       return city;
    }

    @Override
    public List<City> getCitiesByState(String stateAbbreviation) {
        List<City> cityList = new ArrayList<>();
        String sql = "SELECT city_id, city_name, state_abbreviation, population, area FROM city WHERE state_abbreviation = ?;";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, stateAbbreviation);
        while(result.next()){
            cityList.add(mapRowToCity(result));

        }
        return cityList;
    }


    @Override
    public City createCity(City city) {
        String cityName = city.getCityName();
        String cityState = city.getStateAbbreviation();
        int population = city.getPopulation();
        double area = city.getArea();
        String sql = "INSERT INTO city(city_name, state_abbreviation, population, area)\n" +
                "VALUES (?, ?, ?, ?) Returning city_id;";
        //Integer newId = jdbcTemplate.queryForObject(sql, Integer.class, cityName,cityState,population,area );
        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class, city.getCityName(), city.getStateAbbreviation(), city.getPopulation(), city.getArea());
        city.setCityId(newId);
        return city;
    }

    @Override
    public void updateCity(City city) {
        String sql = "UPDATE city\n" +
                "SET city_name = ?, population = ?, area = ?\n" +
                "WHERE city_id = ?;";

        Integer updatedId = jdbcTemplate.update(sql, city.getCityName(), city.getPopulation(), city.getArea(), city.getCityId());

        if(updatedId == 1){
            System.out.println(updatedId);
        } else {
            System.out.println("Update failed");
        }

    }

    @Override
    public void deleteCity(int cityId) {
        String sql = "DELETE FROM city\n" +
                "WHERE city_id = ?;";
        jdbcTemplate.update(sql, cityId);
    }

    private City mapRowToCity(SqlRowSet result) {
        City city = new City();
        city.setCityId(result.getInt("city_id"));
        city.setCityName(result.getString("city_name"));
        city.setStateAbbreviation(result.getString("state_abbreviation"));
        city.setPopulation(result.getInt("population"));
        city.setArea(result.getDouble("area"));
        return city;
    }

}
