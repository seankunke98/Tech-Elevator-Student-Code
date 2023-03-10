package com.techelevator.farm;

import java.math.BigDecimal;

public final class Cow extends FarmAnimal implements Sellable {
	private BigDecimal price;

	public Cow() {
		super("Cow", "moo!");
		price = new BigDecimal("1500.00");
	}

	public BigDecimal getPrice() {
		return price;
	}


	public String eat(){
		return "Eating cow food....";
	}
}
