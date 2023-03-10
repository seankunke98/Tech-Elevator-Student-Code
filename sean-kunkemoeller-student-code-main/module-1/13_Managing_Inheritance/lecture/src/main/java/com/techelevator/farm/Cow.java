package com.techelevator.farm;

import java.math.BigDecimal;

public class Cow extends FarmAnimal implements Sellable {
	private BigDecimal price;

	public Cow() {
		super("Cow", "moo!");
		price = new BigDecimal("1500.00");
	}

	@Override
	public String eat() {
		return null;
	}

	public BigDecimal getPrice() {
		return price;
	}
}
