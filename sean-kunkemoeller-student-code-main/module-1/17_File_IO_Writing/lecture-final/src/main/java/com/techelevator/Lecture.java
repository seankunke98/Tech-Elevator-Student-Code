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

		System.out.println("Please enter the path of the file or directory:");
		String path = userInput.nextLine();

		//create an instance of a file object from given path
		File file = new File(path);

		if(file.exists()){ //will return true if file is in the file system
			System.out.println("name: " + file.getName());
			System.out.println("This file's absolute path is: " + file.getAbsolutePath());
		} else {
			System.out.println(file.getAbsolutePath() + " does not exist.");
		}

		/*
		Note that the file didn't exist! We need to create it! use the .createNewFile()
		* */

		System.out.println();
		System.out.println("**************************");
		System.out.println("Now calling createNewFile() method: ");

		boolean fileCreated = file.createNewFile();

		if(file.exists()){ //will return true if file is in the file system
			System.out.println("name: " + file.getName());
			System.out.println("This file's absolute path is: " + file.getAbsolutePath());
		} else {
			System.out.println(file.getAbsolutePath() + " does not exist.");
		}

		System.out.println();
		System.out.println("****************************");
		System.out.println("Lets make a folder!!");
		System.out.println();

		System.out.println("Please enter the name of the new folder you would like to make:");
		path = userInput.nextLine();

		File newFolder = new File(path);

		if(newFolder.exists()){
			System.out.println("Sorry, " + newFolder.getAbsolutePath() + " already exists. :( ");
		} else {
			newFolder.mkdir();
			File newFile = new File(newFolder.getAbsolutePath() + "/testFileInFolder.txt");
			newFile.createNewFile();
			//now that we have a file, lets write to it!
			try(PrintWriter writer = new PrintWriter(newFile)){
				writer.println("We writing this from our program!! Next level!!");
			}
		}

		newFolder.listFiles();

		System.out.println(newFolder.getName());
	}

}
