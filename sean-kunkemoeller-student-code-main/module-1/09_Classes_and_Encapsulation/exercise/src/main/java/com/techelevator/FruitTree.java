package com.techelevator;

public class FruitTree {
    private String typeOfFruit; //these are changeable variables the user cannot see, they are changed based on the input provided
    private int piecesOfFruitLeft;

    //constructor:
    public FruitTree(String typeOfFruit, int startingPiecesOfFruit){
        this.typeOfFruit = typeOfFruit;
        this.piecesOfFruitLeft = startingPiecesOfFruit;
    }

    //method:
    public boolean pickFruit(int numberOfPiecesToRemove) { //method that accepts an int (numberOfPiecesToRemove) and returns a boolean
        //use get method to recall piecesOfFruitVariable from private int
        if(getPiecesOfFruitLeft() - numberOfPiecesToRemove >= 0){ //if it is still possible to pick the fruit then subtract the amount taken from pieces left and return true
            piecesOfFruitLeft -= numberOfPiecesToRemove; //
            return true;
        }
        return false;
    }
    //getters:
    public String getTypeOfFruit() {
        return this.typeOfFruit; //assigns given input to the private variable
    }

    public int getPiecesOfFruitLeft() {
        return this.piecesOfFruitLeft; //assigns given input to the private variable
    }
}
