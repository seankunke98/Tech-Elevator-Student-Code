package com.techelevator.farm;

import java.math.BigDecimal;

public class Chicken extends FarmAnimal {

	public Chicken() {
		super("Chicken", "cluck!");
	}

	@Override
	public String eat() {
		return null;
	}

	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}

	@Override
	public BigDecimal getPrice() {
		return null;
	}
}