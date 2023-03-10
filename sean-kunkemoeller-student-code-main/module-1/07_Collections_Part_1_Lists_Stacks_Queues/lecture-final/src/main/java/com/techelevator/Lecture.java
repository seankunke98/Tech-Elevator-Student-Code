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

		javaPurple.add("Aaron");
		javaPurple.add("Aileen");
		javaPurple.add("Andrew");
		javaPurple.add("Arthur");
		javaPurple.add("Cody");
		javaPurple.add("Dan");
		javaPurple.add("Reno");
		javaPurple.add("Hulya");
		javaPurple.add("James");
		javaPurple.add("Jimmy");
		javaPurple.add("Kat F.");
		javaPurple.add("Kat P.");
		javaPurple.add("Laura");
		javaPurple.add("Mark");
		javaPurple.add("Nate");
		javaPurple.add("Nife");
		javaPurple.add("Sean");
		javaPurple.add("William");

		int sizeOfJavaPurple = javaPurple.size();
		System.out.println("The size of purple is: " + sizeOfJavaPurple);

		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		for(int i = 0; i < javaPurple.size();i++){
			System.out.println(i +") " + javaPurple.get(i));
		}

		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		javaPurple.add(10, "Joe");

		boolean isJoeInJavaPurple = javaPurple.contains("Joe");
		System.out.println("Is Joe in Java Purple: " + isJoeInJavaPurple);

		for(int i = 0; i < javaPurple.size();i++){
			System.out.println(i +") " + javaPurple.get(i));
		}

		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		javaPurple.remove(10);

		for(int i = 0; i < javaPurple.size();i++){
			System.out.println(i +") " + javaPurple.get(i));
		}

		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		isJoeInJavaPurple = javaPurple.contains("Joe");
		System.out.println("Is Joe in Java Purple: " + isJoeInJavaPurple);


		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");

		System.out.println("Nife's index is: " + javaPurple.indexOf("Nife"));
		System.out.println("Joe's index is: " + javaPurple.indexOf("Joe"));

		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		String[] jp = javaPurple.toArray(new String[0]);
		for(int i = 0; i < jp.length; i++){
			System.out.println("This is the array " + jp[i]);
		}

		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		Collections.sort(javaPurple);
		for(int i = 0; i < javaPurple.size();i++){
			System.out.println(i +") " + javaPurple.get(i));
		}

		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

		Collections.reverse(javaPurple);

		for(int i = 0; i < javaPurple.size();i++){
			System.out.println(i +") " + javaPurple.get(i));
		}

		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();

		for(String currentStudentInList : javaPurple){
			String uppercaseStudentName = currentStudentInList.toUpperCase();
			System.out.println(currentStudentInList.substring(1,currentStudentInList.length()-1));
		}
	}
}
