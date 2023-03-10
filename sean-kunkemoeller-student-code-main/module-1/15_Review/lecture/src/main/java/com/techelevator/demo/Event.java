package com.techelevator.demo;

import java.time.LocalDate;

public class Event {

    private LocalDate dateOfEvent;
    private String location;
    private String groupHosting;
    private int numberOfAttendees;

    public Event(LocalDate dateOfEvent, String groupHosting){
        this.dateOfEvent = dateOfEvent;
        this.groupHosting = groupHosting;
    }

    public void inviteToEvent(){
            numberOfAttendees++;
    }

    public int getNumberOfAttendees() {
        return numberOfAttendees;
    }

    public LocalDate getDateOfEvent() {
        return dateOfEvent;
    }

    public void setDateOfEvent(LocalDate dateOfEvent) {
        this.dateOfEvent = dateOfEvent;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGroupHosting() {
        return groupHosting;
    }

    public void setGroupHosting(String groupHosting) {
        this.groupHosting = groupHosting;
    }
}
