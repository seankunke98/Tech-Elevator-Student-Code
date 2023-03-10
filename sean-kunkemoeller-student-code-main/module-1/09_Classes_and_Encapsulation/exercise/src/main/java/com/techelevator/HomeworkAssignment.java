package com.techelevator;

public class HomeworkAssignment {
    private int earnedMarks;
    private int possibleMarks;
    private String submitterName;
    String A;
    String B;
    String C;
    String D;
    String F;

    //constructor:
    public HomeworkAssignment(int possibleMarks, String submitterName) {
        //still need to assign arguments to member variables
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;
    }

    //method:
    public String getLetterGrade() {
        //letterGrade = earnedMarks / possibleMarks;
        if (((1.0 * earnedMarks / possibleMarks) * 100) >= 90) {
            return "A";
        } else if ((((double) earnedMarks / possibleMarks) * 100) >= 80) {
            return "B";
        } else if (((1.0 * earnedMarks / possibleMarks) * 100) >= 70) {
            return "C";
        } else if (((1.0 * earnedMarks / possibleMarks) * 100) >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    //getters:
    public HomeworkAssignment(int possibleMarks) {
        this.possibleMarks = possibleMarks;
    }
    public int getPossibleMarks(){
        return possibleMarks;
    }

    public int getEarnedMarks() {
        return earnedMarks;
    }
    public void setEarnedMarks(int earnedMarks){
        this.earnedMarks = earnedMarks;
    }

    public String getSubmitterName() {
        return submitterName;
    }

    public int setPossibleMarks() {
        return possibleMarks;
    }

}