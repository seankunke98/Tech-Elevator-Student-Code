package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please Enter The Measurement: "); //prompt user can see
		String measurementFromUser = scanner.nextLine(); //input i can see from user
		double userMeasurement = Integer.parseInt(measurementFromUser); //input from user converted to usable value(converted from string to int)

		System.out.println("Is Your Measurement (m)eters or (f)eet?");
		String isLengthMetersOrFeet = scanner.nextLine();

		double lengthMeters = (userMeasurement * 0.3048);

		if(isLengthMetersOrFeet.equals("f")){
			System.out.println((int)lengthMeters);
		}

	}

}
