package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please Enter Temperature: "); //prompt user can see
		String tempFromUser = scanner.nextLine(); //input i can see from user
		double userTemperature = Integer.parseInt(tempFromUser); //input from user converted to usable value(converted from string to int)

		System.out.println("Is Your Temperature (C)elsius or (F)ahrenheit?");
		String isTempCelsiusOrFahrenheit = scanner.nextLine();

		double temperatureCelsius = (userTemperature - 32) / 1.8;

		if(isTempCelsiusOrFahrenheit.equals("F")){
			System.out.println((int)temperatureCelsius);
		}

	}

}
