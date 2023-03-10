package com.techelevator.farm;

public class Chicken extends FarmAnimal implements Sellable {

	public Chicken() {
		super("Chicken", "cluck!");
	}

	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}

	@Override
	public String getSound(){
		return "cluck!";
	}

	@Override
	public double getPrice() {
		return 100.00;
	}
}