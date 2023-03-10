package com.techelevator.model;

import java.util.List;
import java.util.Objects;

public class Venue {

    private int id;
    private String name;
    private String description;
    private String city;
    private State state = new State();;
    private List<String> categories;

    public Venue(int id, String name, String description, String city, String stateAbbreviation, List<String> venue1Categories) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.city = city;
        this.state.setAbbreviation(stateAbbreviation);
        categories = venue1Categories;
    }

    public Venue(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venue venue = (Venue) o;
        return id == venue.id && Objects.equals(name, venue.name) && Objects.equals(description, venue.description) && Objects.equals(city, venue.city) && Objects.equals(state, venue.state) && Objects.equals(categories, venue.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, city, state, categories);
    }
}
