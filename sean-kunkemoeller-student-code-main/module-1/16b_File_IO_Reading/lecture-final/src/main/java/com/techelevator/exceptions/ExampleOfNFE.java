package com.techelevator.exceptions;

import java.util.Scanner;

public class ExampleOfNFE {

    /*
    This class contains an example of an unhandled NumberFormatException.

    Since an NumberFormatException is a RuntimeException, we as programmers
    have a choice if we want to handle it or not. In this example we are not handling it
    and when we run the program, and the exception occurs, our program will end with a
    stacktrace of what the exception was and where it happened.

    To see this an example of protecting our program from this with a try/catch, refer to the
    ExceptionsLecture class (around lines 46 - 54)
    * */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

            System.out.println("The standard work week is 40 hours.");
            System.out.print("How many hours did you work this week? >>> ");

            //if the user enters anything that is not a number, it will throw a NumberFormatException

            int hoursWorked = Integer.valueOf( scan.nextLine() );
        System.out.println("I want to see this code!!!!");
            int overtimeHours = hoursWorked - 40;
            System.out.println("You worked "+overtimeHours+" hours of overtime.");

    }
}
