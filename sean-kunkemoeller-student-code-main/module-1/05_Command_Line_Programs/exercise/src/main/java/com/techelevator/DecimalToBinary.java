package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a series of decimal values (separated by spaces): "); //prompt user can see
		String doubleValuesFromUser = scanner.nextLine(); //input i can see from user


		String[] arrayFromUser = doubleValuesFromUser.split(" ");

		int[] convertedArray = new int[arrayFromUser.length];

		for (int i = 0; i < arrayFromUser.length; i++){
			convertedArray[i] = Integer.parseInt(arrayFromUser[i]);

			System.out.println(arrayFromUser[i] + " in binary is: " + Integer.toBinaryString(convertedArray[i]));
		}


	}

}
