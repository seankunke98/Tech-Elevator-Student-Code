package com.techelevator;

import java.io.File;
import java.util.NoSuchElementException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) throws NoSuchElementException {

		Scanner userInput = new Scanner(System.in);
		System.out.println("Please enter the path to your file: ");
		String filePath = userInput.nextLine();
		File inputFile = new File(filePath);
		if (!inputFile.exists()) {
			System.out.println(filePath + ": Does not exist!");
			System.exit(1);
		} else if (!inputFile.isFile()) {
			System.out.println(filePath + ": is not a file!");
			System.exit(1);
		}
		System.out.println("What word would you like to search? ");
		String wordToSearch = userInput.nextLine();
		System.out.println("Would you like your search to be case sensitive? (Y)es or (N)o: ");
		String yesOrNo = userInput.nextLine().toLowerCase().substring(0, 1);

			try (Scanner input = new Scanner(inputFile)) {
				int lineCount = 0;

				while (input.hasNextLine()) {
					lineCount++;
					if(yesOrNo.equals("n")) {
						String line = input.nextLine();
						if (line.toLowerCase().contains(wordToSearch.toLowerCase())) {
							System.out.println(lineCount + ") " + line);
						}
					} else {
						String line = input.nextLine();
						if (line.contains(wordToSearch)) {
							System.out.println(lineCount + ") " + line);
						}
					}

				}
			} catch (FileNotFoundException e) {
				System.out.println("Your file doesn't exist!");
			}
		}


}
