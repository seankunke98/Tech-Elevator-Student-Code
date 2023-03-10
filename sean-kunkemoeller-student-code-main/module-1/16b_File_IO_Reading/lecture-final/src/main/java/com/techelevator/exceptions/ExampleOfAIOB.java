package com.techelevator.exceptions;

public class ExampleOfAIOB {

    /*
    This class contains an example of an unhandled ArrayIndexOutOfBoundsException.
    Since an ArrayIndexOutOfBoundsException is a RuntimeException, we as programmers
    have a choice if we want to handle it or not. In this example we are not handling it
    and when we run the program, and the exception occurs, our program will end with a
    stacktrace of what the exception was and where it happened.

    Refer to the ExceptionsLecture class (around lines 18 - 27) to see an example of protecting our code with
    a try/catch.
    * */



    public static void main(String[] args) {

        System.out.println("The following cities: ");
        String[] cities = new String[] { "Cleveland", "Columbus", "Cincinatti" };

            System.out.println(cities[0]);
            System.out.println(cities[1]);
            System.out.println(cities[2]);
            System.out.println(cities[3]);  // This statement will throw an ArrayIndexOutOfBoundsException
            System.out.println("are all in Ohio."); // This line won't execute because the previous statement throws an Exception

        System.out.println();
        System.out.println("-------------------------------------------------------");
        System.out.println();
    }

}
