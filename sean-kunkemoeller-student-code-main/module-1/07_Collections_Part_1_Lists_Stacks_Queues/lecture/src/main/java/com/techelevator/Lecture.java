package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		List<String> javaPurple = new ArrayList<>();

		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		for(int i = 0; i < javaPurple.size(); i++){
			System.out.println(i + ") " + javaPurple.get(i)); //indexes list and shows them in order with #) Name
		}

		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");

		javaPurple.add(10, "Joe"); //adds jow into list at index 10 (spot 11)

		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		javaPurple.remove(10); //removes entry in list at index 10

		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		boolean isJoeInList = javaPurple.contains("Joe");



		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		String[] jp = javaPurple.toArray(new String[0]);
		for(int i = 0; i < jp.length; i++){
			System.out.println("This is the array " + jp[i]); //remakes javaPurple list into an array with each entry
		}


		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		Collections.sort(javaPurple); //sorts list A-Z

		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

		Collections.reverse(javaPurple); //sorts list Z-A

		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();

		for(String currentStudentInList : javaPurple){
			System.out.println(currentStudentInList); //will spit out current student on the list and loop through all
		}

	}
}
