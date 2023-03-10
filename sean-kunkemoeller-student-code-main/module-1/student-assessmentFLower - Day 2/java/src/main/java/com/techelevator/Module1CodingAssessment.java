package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Module1CodingAssessment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FlowerShop flowerShop =
				new FlowerShop("Get Well bouquet", 6);

		FlowerShop rachellesOrder =
				new FlowerShop("Happy Day", 12);

		System.out.println("Object #1: ");
		System.out.println("Type: " + flowerShop.getBouquetType() + " Number of Roses: " +
				flowerShop.getNumberOfRoses());
		System.out.println("Subtotal: " + flowerShop.getSubtotal());

		System.out.println("Object #2: ");
		System.out.println("Type: " + rachellesOrder.getBouquetType() + " Number of Roses: " +
				rachellesOrder.getNumberOfRoses());
		System.out.println("Subtotal: " + rachellesOrder.getSubtotal());

		System.out.println(rachellesOrder.toString());
		rachellesOrder.setNumberOfRoses(3);

		System.out.println(rachellesOrder);

		System.out.println("Delivery for the flowershop object");
		System.out.println(flowerShop.deliveryTotal(true, "20501"));

		//File I/O
		File file = new File("FlowerInput.csv");
		List<FlowerShop> flowerShops = new ArrayList<>(); // empty arraylist to hold all fs objects
		try {
			Scanner fileInput = new Scanner(file);
			System.out.println("File open");
			while (fileInput.hasNextLine()){  // while there is more input in the file

				// split the file into an array of strings
				// trim() -- trims off extra spaces
				String[] line = fileInput.nextLine().trim().split(","); // line[0] - bouquet type
				// line[1] - number of roses

				// create a temp object using the data from the line in the file
				FlowerShop temp = new FlowerShop(line[0], Integer.parseInt(line[1]));
				flowerShops.add(temp); // adds each object to our data structure
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// need a variable to hold the total
		BigDecimal total = new BigDecimal("0.00");
		// loop through our list and get the subtotal
		for (FlowerShop order: flowerShops){
			// add subtotal to our total variable
			total = total.add(order.getSubtotal());
			System.out.println(order);

		}

		// at end of loop, print out total
		System.out.println(" *** TOTAL *** " + total);

	}

}
