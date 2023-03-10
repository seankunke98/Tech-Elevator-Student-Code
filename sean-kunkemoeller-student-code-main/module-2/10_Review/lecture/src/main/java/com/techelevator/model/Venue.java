package com.techelevator.model;

public class Venue {

    private int venueId;
    private String venueName;
    private String description;
    private String cityName;
    private String stateAbbreviation;
    private String categoryName;

    public Venue() {

    }

    public Venue(int venueId, String venueName, String cityName, String stateAbbreviation, String description, String categoryName) {
        this.venueId = venueId;
        this.venueName = venueName;
        this.description = description;
        this.cityName = cityName;
        this.stateAbbreviation = stateAbbreviation;
        this.categoryName = categoryName;

    }

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateAbbreviation() {
        return stateAbbreviation;
    }

    public void setStateAbbreviation(String stateAbbreviation) {
        this.stateAbbreviation = stateAbbreviation;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String category) {
        this.categoryName = category;
    }

    @Override
    public String toString() {
        return String.format("%s, %s (ID: %d)", getVenueName(), getDescription(), getVenueId());
    }
}
