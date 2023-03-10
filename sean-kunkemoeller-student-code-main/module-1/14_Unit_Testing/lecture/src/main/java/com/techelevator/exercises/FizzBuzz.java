package com.techelevator.exercises;

public class FizzBuzz {

    /*
    generate a string of numbers 1 - 100 where:

    If the number is divisible by 3 or contains a 3, print Fizz.
    If the number is divisible by 5 or contains a 5, print Buzz.
    If the number is divisible by 3 and 5 or contains a 3 and 5, print FizzBuzz.
     */

    public String fizzBuzz(){
        String fizzBuzzString = "1";
        for(int i = 2; i <= 100; i++) {
            if (i % 3 == 0 || String.valueOf(i).contains("3")) {
                fizzBuzzString = fizzBuzzString + " " + "Fizz";
            } else {
                fizzBuzzString = fizzBuzzString + " " + String.valueOf(i);
            }
        }

        return fizzBuzzString;
    }


}
