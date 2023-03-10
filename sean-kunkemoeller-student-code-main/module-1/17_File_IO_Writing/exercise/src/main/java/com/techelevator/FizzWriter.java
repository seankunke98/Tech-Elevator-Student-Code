package com.techelevator;

import java.io.*;

public class FizzWriter {

	public static void main(String[] args) {
		File fizzFile = new File("src/test/resources/fizzbuzz.txt");
		File input = new File("src/test/resources/input.txt");
		String output;

		try (PrintWriter writer = new PrintWriter(fizzFile); FileWriter fileWriter = new FileWriter(input)) {
			for (int i = 1; i < 301; i++) {
				if (i % 15 == 0) {
					output = "FizzBuzz";
				} else if (i % 5 == 0) {
					output = "Buzz";
				} else if (i % 3 == 0) {
					output = "Fizz";
				} else if ((Integer.toString(i).contains("3") && Integer.toString(i).contains("5"))) {
					output = "FizzBuzz";
				} else if (Integer.toString(i).contains("3")) {
					output = "Buzz";
				} else if (Integer.toString(i).contains("5")) {
					output = "Fizz";
				} else {
					output = Integer.toString(i);
				}
				writer.println(output);


			}


		} catch (FileNotFoundException e) {
			System.out.println("");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try (FileWriter fileWriter = new FileWriter(input)) {
			for (int i = 1; i < 301; i++) {
				if (i % 15 == 0) {
					output = "FizzBuzz" + System.lineSeparator();
				} else if (i % 5 == 0) {
					output = "Buzz" + System.lineSeparator();
				} else if (i % 3 == 0) {
					output = "Fizz" + System.lineSeparator();
				} else if ((Integer.toString(i).contains("3") && Integer.toString(i).contains("5"))) {
					output = "FizzBuzz" + System.lineSeparator();
				} else if (Integer.toString(i).contains("3")) {
					output = "Buzz" + System.lineSeparator();
				} else if (Integer.toString(i).contains("5")) {
					output = "Fizz" + System.lineSeparator();
				} else {
					output = Integer.toString(i) + System.lineSeparator();
				}


				fileWriter.write(output);

				}
			} catch (IOException ex) {
			ex.printStackTrace();
		}

	}
}