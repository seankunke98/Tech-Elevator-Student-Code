package com.techelevator.farm;

public class OldMacdonald {
	public static void main(String[] args) {

		Cow sleepyCow = new Cow();
		sleepyCow.sleep(true);

		Pig sleepyPig = new Pig();
		sleepyPig.sleep(true);

		TabbyCat cat = new TabbyCat("Cat", "meow");

		//cat.sleep(true);

		Singable[] singables =
				new Singable[] {sleepyCow, new Chicken(), sleepyPig, new Tractor("Tractor"), cat};



		for (Singable singable : singables) {

			String name = singable.getName();
			String sound = singable.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name
					+ ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound
					+ " everywhere a " + sound + " " + sound);
			System.out.println();
		}

		Sellable[] sellables = new Sellable[] {new Cow(), new Pig(), new Egg()};

		for (Sellable sellable : sellables) {
			System.out.println("Step right up and get your " + sellable.getName());
			System.out.println("Only $" + sellable.getPrice());
		}

		FarmAnimal[] farmAnimals = new FarmAnimal[]{new Chicken(), new Cow(), new Pig(), cat};
		for(FarmAnimal currentFarmAnimal : farmAnimals){
			System.out.println(currentFarmAnimal.eat());
		}
	}
}