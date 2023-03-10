package com.techelevator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Module1CodingAssessment {

	public static void main(String[] args) throws IOException {
		List<String> MovieList = new ArrayList<>();
		MovieRental movieRental = new MovieRental("testMovie", "VHS", false);

		Scanner reader = new Scanner("MovieInput.csv");
		String line;
		while (reader.hasNextLine()) {
			String[] index = reader.nextLine().split(",");
			String title = index[0];
			String format = index[1];


		}
		movieRental.isLate(2);
		System.out.println(movieRental.getRentalPrice());


	}
}
