package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
// ask user for number
		//store number
		//print all fibonacci numbers leading up to number
		//create an array as big as number user enters
		//define array[0] and array[1]
		//loop through
		System.out.println("Please Enter Number: ");
		String numberFromUser = scanner.nextLine();

		int convertedNumberFromUser = Integer.parseInt(numberFromUser);

		if(convertedNumberFromUser == 0){
			System.out.println("0, 1");
		}
		else {
			System.out.println("0, 1, ");
			int[] numberArray = new int[convertedNumberFromUser * 10];
			numberArray[0] = 0;
			numberArray[1] = 1;

			for(int i = 0; i <= convertedNumberFromUser; i++){
				numberArray[i + 2] = numberArray[i] + numberArray[i + 1];

				if(numberArray[i + 2] > convertedNumberFromUser){
					break;
				}
			}

		}

	}

}
