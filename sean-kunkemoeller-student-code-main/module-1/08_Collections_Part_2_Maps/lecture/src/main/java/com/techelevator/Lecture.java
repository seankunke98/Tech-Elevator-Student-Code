package com.techelevator;

import java.util.*;

public class Lecture {

	public static void main(String[] args) {
		Set<String> students = new TreeSet<>(); //LinkedHashSet maintains order while HashSet does not, TreeSet prints in alphabetical order
		students.add("Aaron");
		students.add("Aileen");
		students.add("Andrew");
		students.add("Arthur");
		students.add("Cody");
		students.add("Dan");
		students.add("Reno");
		students.add("Hulya");
		students.add("James");
		students.add("Jimmy");
		students.add("Kat F.");
		students.add("Kat P.");
		students.add("Laura");
		students.add("Mark");
		students.add("Nate");
		students.add("Nife");
		students.add("Sean");
		students.add("William");

		int count = 1;
		for(String currentStudent : students){ //for each loop that goes through list of students
			System.out.println(count + ") " + currentStudent); //add count and ) to current student name and prints them out
			count++; //increments count by 1
		}

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		//build javaPurpleList
		List<String> javaPurpleList = new ArrayList<>();
		javaPurpleList.add("Aaron");
		javaPurpleList.add("Aileen");
		javaPurpleList.add("Andrew");
		javaPurpleList.add("Arthur");
		javaPurpleList.add("Cody");
		javaPurpleList.add("Dan");
		javaPurpleList.add("Reno");
		javaPurpleList.add("Hulya");
		javaPurpleList.add("James");
		javaPurpleList.add("Jimmy");
		javaPurpleList.add("Kat F.");
		javaPurpleList.add("Kat P.");
		javaPurpleList.add("Laura");
		javaPurpleList.add("Mark");
		javaPurpleList.add("Nate");
		javaPurpleList.add("Nife");
		javaPurpleList.add("Sean");
		javaPurpleList.add("William");

		Map<String, String> javaPurpleMap = buildJavaPurpleMap(javaPurpleList);

		for(Map.Entry<String, String> currentEntrySet : javaPurpleMap.entrySet()){
			System.out.println(currentEntrySet.getKey() + " drinks " + currentEntrySet.getValue());
		}



		String removeArthur = javaPurpleMap.remove("Arthur");
		System.out.println(removeArthur);
		boolean isArthurInMap = javaPurpleMap.containsKey("Arthur");
		System.out.println(isArthurInMap);
		boolean isSodaInMap = javaPurpleMap.containsValue("soda");
		System.out.println("Is soda in map: " + isSodaInMap);
		boolean isTeaInMap = javaPurpleMap.containsValue("tea");
		System.out.println("Is soda in map: " + isTeaInMap);

		Set<String> javaPurpleKeySet = javaPurpleMap.keySet();

	}				//first value is key, second is value
	private static Map<String,String> buildJavaPurpleMap(List<String> javaPurpleList){
		Map<String, String> javaPurple = new HashMap<>();
		for(String currentStudent : javaPurpleList){
			if(currentStudent.contains("a")){
				javaPurple.put(currentStudent, "coffee");
			} else {
				javaPurple.put(currentStudent, "tea");
			}

		}
		return javaPurple;
	}

}
