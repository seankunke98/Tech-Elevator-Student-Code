package com.techelevator.farm;

public class Cow extends FarmAnimal {

	public Cow() {
		super("Cow", "moo!");
	} //supers the FarmAnimal method to the cow class and names it

	@Override
	public String getSound(){
		return "moo!";
	}
}