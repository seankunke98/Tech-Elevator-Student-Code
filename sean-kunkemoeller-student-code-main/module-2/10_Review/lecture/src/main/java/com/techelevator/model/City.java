package com.techelevator.model;

public class City {
    private int cityId;
    private String cityName;
    private String stateAbbreviation;

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
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

    @Override
    public String toString() {
        return String.format("%s, %s (ID: %d)", getCityName(), getStateAbbreviation(), getCityId());
    }
}
