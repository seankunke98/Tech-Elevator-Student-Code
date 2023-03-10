package com.techelevator.farm;

public abstract class FarmAnimal implements Singable, Sellable {
	private int price;
	private String name;
	private String sound;
	private boolean isAsleep;

	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
	}
	public FarmAnimal(String name, String sound, int price){
		this.name = name;
		this.sound = sound;
		this.price = price;
	}

	public FarmAnimal() {

	}

	public String getName( ) {
		return name;
	}
	public String getSound() {
		if(isAsleep){
			return "Zzzzzz.....";
		}
		return sound;
	}

	public abstract String eat(); //just define your abstract class
	//error because abstract method is not in abstract class

	public void sleep(boolean isAsleep){
		this.isAsleep = isAsleep;
	}
}