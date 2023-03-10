package com.techelevator.farm;

public class OldMacdonald {
	public static void main(String[] args) {

		Singable[] singables = new Singable[] { new Cow(), new Chicken(), new Pig(), new Tractor() };

		for (Singable animal : singables) {
			String name = animal.getName();
			String sound = animal.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();
		}

		Sellable[] itemsForSale = new Sellable[]{new Chicken(), new Tractor()};
		for(Sellable item : itemsForSale){
			System.out.println(item.getName() + " $" + item.getPrice());
		}

		FarmAnimal[] farmAnimals = new FarmAnimal[] { new Cow(), new Chicken(), new Pig()};

		for(FarmAnimal animal : farmAnimals){
			System.out.println(animal);
		}

	}
}