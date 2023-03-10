package com.techelevator;

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

	}

}
