package com.techelevator.dao;

import com.techelevator.model.City;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

public class JdbcCityDao implements CityDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcCityDao(DataSource dataSource){ this.jdbcTemplate = new JdbcTemplate(dataSource); }

    @Override
    public City getCity(int cityId) {
        City city = new City();
        String sql = "SELECT city_id, name FROM city WHERE id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, cityId);
        if(results.next()){
            city = mapRowToCity(results);
        }
        return city;
    }

    public City mapRowToCity(SqlRowSet result){
        City city = new City();
        if(result.next()){
            city.setCityName(result.getString("name"));
            city.setCityId(result.getInt("city_id"));
        }
        return city;
    }
}
