package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) throws IOException {

		Scanner userInput = new Scanner(System.in);


		/*
		 * The java.io.File class is a representation of file and directory path names.  It provides methods to inspect and
		 * modify file system objects.
		 *
		 * One benefit is that it compensates for differences in Windows and Unix use of '/' and '\' as directory delimiters.
		 *
		 * A new instance of File can be created from a String that contains a file system path
		 */

		System.out.println("Please enter the path of the file or directory >>>");
		String path = userInput.nextLine();

		//create an instance of a file object

		File file = new File(path);
		boolean fileCreated = file.createNewFile();
		System.out.println();
		if(file.exists()){
			System.out.println("name: " + file.getName());
			System.out.println("This file's absolute path is: " + file.getAbsolutePath());
		} else {
			System.out.println(file.getAbsolutePath() + " does not exist.");
		}

		System.out.println();
		System.out.println("*************************");
		System.out.println("Let's make a folder!!");
		System.out.println();

		System.out.println("Please enter the name of the new folder you would like to make: ");
		path = userInput.nextLine();

		File newFolder = new File(path);

		if(newFolder.exists()){
			System.out.println("Sorry, " + newFolder.getAbsolutePath() + " already exists. :( ");
		} else {
			newFolder.mkdir();
			File newFile = new File(newFolder.getAbsolutePath() + "/testFileInFolder.txt");
			newFile.createNewFile();
			//now that we have a file let's write to it
			try(PrintWriter writer = new PrintWriter(newFile)){
				writer.println("");
			}
		}

		newFolder.listFiles();

		System.out.println(newFolder.getName());


	}

}
