package com.techelevator.farm;

public class FarmAnimal implements Singable {
	private String name;
	private String sound;

	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
	}

	public String getName() {
		return name;
	}

	public String getSound() {
		return sound;
	}

	@Override
	public String toString(){
		return name + " and I make the sound: " + sound;
	}
}