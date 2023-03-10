package com.techelevator;

import java.util.*;

public class Lecture {

	public static void main(String[] args) {


		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		//build javaPurpleList
		List<String> javaPurpleList = new ArrayList<>();
		javaPurpleList.add("1Hulya");
		javaPurpleList.add("James");
		javaPurpleList.add("Jimmy");
		javaPurpleList.add("2Kat F.");
		javaPurpleList.add("Kat P.");
		javaPurpleList.add("Laura");
		javaPurpleList.add("Mark");
		javaPurpleList.add("13Nate");
		javaPurpleList.add("Nife");
		javaPurpleList.add("Sean");
		javaPurpleList.add("William");
		javaPurpleList.add("Aaron");
		javaPurpleList.add("Aileen");
		javaPurpleList.add("Andrew");
		javaPurpleList.add("Arthur");
		javaPurpleList.add("Cody");
		javaPurpleList.add("Dan");
		javaPurpleList.add("Reno");



		Set<String> students = new TreeSet<>();

		//foreach loop to build set from list:
		for(String currentStudent : javaPurpleList){
			students.add(currentStudent);
		}
		//foreach loop to print out set values
		int count = 1;
		for(String currentStudentInSet : students){
			System.out.println(count + ") " + currentStudentInSet);
			count++;
		}


		Map<String, String> javaPurpleMap = buildJavaPurpleMap(javaPurpleList);

		System.out.println(javaPurpleMap.get("Kat P."));

		boolean isArthurInMap = javaPurpleMap.containsKey("Arthur");
		System.out.println(isArthurInMap);

		String removeArthur = javaPurpleMap.remove("Arthur");
		System.out.println(removeArthur);

		isArthurInMap = javaPurpleMap.containsKey("Arthur");
		System.out.println(isArthurInMap);

		boolean isSodaInMap = javaPurpleMap.containsValue("soda");
		System.out.println("Is soda in map , " + isSodaInMap);

		boolean isTeaInMap = javaPurpleMap.containsValue("tea");
		System.out.println("Is tea in map , " + isTeaInMap);

		Set<String> javaPurpleKeySet = javaPurpleMap.keySet();

		System.out.println();
		System.out.println("**********************************************");
		System.out.println();

		for(Map.Entry<String, String> currentEntrySet : javaPurpleMap.entrySet()){
			System.out.println(currentEntrySet.getKey() + " drinks " + currentEntrySet.getValue());
		}


	}
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
