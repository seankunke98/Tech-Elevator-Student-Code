package com.techelevator;

public class Lecture {

	public static void main(String[] args) {
		
		/*
		1. Create a variable to hold an int and call it numberOfExercises.
			Then set it to 26.
		*/
		int numberOfExercises = 26;
		System.out.println(numberOfExercises);

		/*
		2. Create a variable to hold a double and call it half.
			Set it to 0.5.
		*/
		double half;
		half = 0.5;
		System.out.println(half);

		/*
		3. Create a variable to hold a String and call it name.
			Set it to "TechElevator".
		*/
		String name = "TechElevator";
		System.out.println(name);

		/*
		4. Create a variable called seasonsOfFirefly and set it to 1.
		*/
		int seasonsOfFirefly = 1;
		System.out.println(seasonsOfFirefly);

		/*
		5. Create a variable called myFavoriteLanguage and set it to "Java".
		*/
		String myFavoriteLanguage = "Java";
		System.out.println(myFavoriteLanguage);

		/*
		6. Create a variable called pi and set it to 3.1416.
		*/
		double pi = 3.1416;
		System.out.println(pi);

		/*
		7. Create and set a variable that holds your name.
		*/
		String myName = "Rachelle";
		System.out.println(myName + " no more rabbit trails!");

		/*
		8. Create and set a variable that holds the number of buttons on your mouse.
		*/
		short buttonOnMouse = 4;
		System.out.println(buttonOnMouse);
		/*
		9. Create and set a variable that holds the percentage of battery left on
		your phone.
		*/
		System.out.println("We are here:");
		double percentOfBatteryLeft = (5d/100);
		System.out.println(percentOfBatteryLeft);
		int percentageFromBatteryLeft = 88;
		System.out.println(percentageFromBatteryLeft + "%");
		System.out.println(percentageFromBatteryLeft);
		/*
		10. Create an int variable that holds the difference between 121 and 27.
		*/
		int difference = 121 - 27;
		System.out.println(difference);
		/*
		11. Create a double that holds the addition of 12.3 and 32.1. //44.4
		*/
		double sum = 12.3 + 32.1;
		System.out.println(sum);
		/*
		12. Create a String that holds your full name.
		*/
		String fullName = "Rachelle Rauh";
		/*
		13. Create a String that holds the word "Hello, " concatenated onto your
		name from above.
		*/
		String greeting = "Hello, " + fullName;
		System.out.println(greeting);
		System.out.println(fullName);
		/*
		14. Add a " Esquire" onto the end of your full name and save it back to
		the same variable.
		*/
//		fullName = fullName + " Esquire";
//		System.out.println(fullName);
		/*
		15. Now do the same as exercise 14, but use the += operator.
		*/
		fullName += " Esquire";
		System.out.println(fullName);

		int hundred = 100;
		int fifty = 50;
		int diff = hundred;

		System.out.println(diff);

		diff -= fifty;

		System.out.println(diff);

		/*
		16. Create a variable to hold "Saw" and add a 2 onto the end of it.
		*/
		String sawString = "Saw" + 2;
		System.out.println(sawString);
		/*
		17. Add a 0 onto the end of the variable from exercise 16.
		*/
		sawString += 0;
		System.out.println(sawString);
		sawString += " the return";
		System.out.println(sawString);

		long x = 10;
		int y = (int)x;

		int xProb = (int)((5 / 2d) * 4);
		System.out.println(xProb);
		/*
		18. What is 4.4 divided by 2.2?
		*/

		/*
		19. What is 5.4 divided by 2?
		*/

		/*
		20. What is 5 divided by 2?
		*/

		/*
		21. What is 5.0 divided by 2?
		*/

		/*
		22. What is 66.6 divided by 100? Is the answer you get right or wrong?
		*/

		/*
		23. If I divide 5 by 2, what's my remainder?
		*/

		/*
		24. What is 1,000,000,000 * 3?
		*/
		long billions = (long)1000000000 * 3;
		System.out.println(billions);
		/*
		25. Create a variable that holds a boolean called isDoneWithExercises and
		set it to false.
		*/
		boolean isDoneWithExercises = false;
		/*
		26. Now set isDoneWithExercise to true.
		*/
		isDoneWithExercises = true;
	}

}

