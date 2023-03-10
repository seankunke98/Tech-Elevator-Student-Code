package com.techelevator;

public class Airplane {
    //data members
    private String planeNumber;
    private int totalFirstClassSeats;
    private int bookedFirstClassSeats;
    private int totalCoachSeats;
    private int bookedCoachSeats;

    public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats){
        this.planeNumber = planeNumber;
        this.totalFirstClassSeats = totalFirstClassSeats;
        this.totalCoachSeats = totalCoachSeats;
    }
    public int getAvailableFirstClassSeats(){
        return totalFirstClassSeats - bookedFirstClassSeats;
    }
    public int getAvailableCoachSeats(){
        return totalCoachSeats - bookedCoachSeats;
    }
    //method:
    public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats) {
        if (forFirstClass == true) {
            if (totalFirstClassSeats - bookedFirstClassSeats >= totalNumberOfSeats) {
                bookedFirstClassSeats += totalNumberOfSeats;
                return true;
            } else {
                return false;
            }
        }
        else{
                if (totalCoachSeats - bookedCoachSeats >= totalNumberOfSeats) {
                    bookedCoachSeats += totalNumberOfSeats;
                    return true;
                } else {
                    return false;
                }
            }

    }
    //getters:
    public String getPlaneNumber() {
        return planeNumber;
    }
    public int getBookedFirstClassSeats() {
        return bookedFirstClassSeats;
    }
    public int getTotalFirstClassSeats() {
        return totalFirstClassSeats;
    }
    public int getBookedCoachSeats() {
        return bookedCoachSeats;
    }
    public int getTotalCoachSeats() {
        return totalCoachSeats;
    }


}
