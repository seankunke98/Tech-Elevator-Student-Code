package com.techelevator;

import java.util.Locale;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes.  This
		 * is not the case for most classes */

		/*Implement the Cake class and then instantiate it.
		(write the source code for the Cake class and then make a
		new object from that class)
		* */

		Cake chocolateCake = new Cake();
		chocolateCake.setIcingColor("teal");
		chocolateCake.setHasSprinkles(true);
		Cake vanillaCake = new Cake();

		/* create an new instance of String using a literal */

		String bootcampName = "Tech Elevator";
		String upperCaseName = bootcampName.toUpperCase();
		System.out.println(bootcampName);
		
		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();


		/* Other commonly used methods:
		 *
		 * endsWith
		 * startsWith
		 * indexOf
		 * lastIndexOf
		 * length
		 * substring
		 * toLowerCase
		 * toUpperCase
		 * trim
		 */

		String name = "Tech Elevator";
		String tor = "tor";
		String substrOfName = name.substring(2, 6).toUpperCase();
		System.out.println(name.substring(5));
		System.out.println(name);
		System.out.println(substrOfName);
		System.out.println(name.contains(tor.toLowerCase()));

		String countDown = String.join("--->","Five", "Four", "Three", "Two", "One");
		System.out.println(countDown);

		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();

        char[] helloArray = new char[] { 'H', 'e', 'l', 'l', 'o' };
        String hello1 = new String(helloArray);
        String hello2 = new String(helloArray);

		for(int i = 0; i < hello1.length(); i++){
			System.out.println(hello1.charAt(i));
		}


		/* Double equals will compare to see if the two variables, hello1 and
		 * hello2 point to the same object in memory. Are they the same object? */
		if (hello1 == hello2) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

		String hello3 = hello1;
		if (hello1 == hello3) {
			System.out.println("hello1 is the same reference as hello3");
		}

		/* So, to compare the values of two objects, we need to use the equals method.
		 * Every object type has an equals method */
		if (hello1.equals(hello2)) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}


	}
}
