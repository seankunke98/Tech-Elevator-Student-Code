package com.techelevator.dao;

import com.techelevator.model.Category;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

public class JdbcCategoryDao implements CategoryDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcCategoryDao(DataSource dataSource){ this.jdbcTemplate = new JdbcTemplate(dataSource); }


    @Override
    public Category getCategory(int categoryId) {
        Category category = new Category();
        String sql = "SELECT id, name FROM category WHERE id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, categoryId);
        if(results.next()){
            category = mapRowToCategory(results);
        }
        return category;
    }


    public Category mapRowToCategory(SqlRowSet result){
        Category category = new Category();
        category.setCategoryName(result.getString("name"));
        category.setCategoryId(result.getInt("id"));
        return category;
    }

}
