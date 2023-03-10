package com.techelevator.demo;

import java.time.LocalDate;

public class DemoApp {

    public static void main(String[] args) {


        //instantiating an event
        LocalDate date = LocalDate.of(2022, 07, 22);
        Event awesomeEvent = new Event(date, "JavaPurple");


        //adds to number of attendees by calling invite method
        awesomeEvent.inviteToEvent();
        awesomeEvent.inviteToEvent();
        awesomeEvent.inviteToEvent();
        awesomeEvent.inviteToEvent();

        System.out.println(awesomeEvent.getGroupHosting() + "'s AwesomeEvent has: " + awesomeEvent.getNumberOfAttendees() + " attendees!");

        System.out.println();

        Person p1 = new Person("a", 11);

        System.out.println("Print p1, see how it internally calls toString():");

        System.out.println(p1); //println internally calls toString() of the object
        System.out.println();

        System.out.println("Print p1, see how it prints the same due to both calling the toString():");

        System.out.println(p1.toString()); //prints the same as above because of the above internal call.
        System.out.println();
        /*When we run it we see an out we see the package followed by the class name
        followed by the hashcode in hexadecimal.
        Hashcode is a unique number given by Java. It does not represent the address of the object.
        for more info checkout https://www.javacodegeeks.com/2012/03/tostring-hexadecimal-representation-of.html
        * */


       // to see the hashcode run:
        System.out.println("Hash code of p1:");
        System.out.println(p1.hashCode());

        /*
        Can write our own hashCode() in the Person class to see the hexadecimal rep of hashcode
        * */


       doSomething();
      //  System.out.println(p2.hashCode());
        System.out.println();
        System.out.println("Is p1 equal to p2?");
        System.out.println();
        //can call Object's equals() method that was inherited to Person
        //by default, it will say they are not equal. We will need to override the
        //.equals() in the Person class to define what it means for a Person to equal another Person.
     //   System.out.println(p1.equals(p2));
        System.out.println(p1);
      //  p2.setAge(40);
        System.out.println(p1);
    }

    public static void doSomething(){
        Person p2 = new Person("a", 14);
        System.out.println("Hash code of p2:");
    }
}
