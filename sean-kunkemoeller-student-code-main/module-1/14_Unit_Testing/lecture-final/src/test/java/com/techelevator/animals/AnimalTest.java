package com.techelevator.animals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AnimalTest {

    private Cat cat;
    private Dog dog;

    @Before
    public void setup(){
        cat = new Cat("TestCat", "TestBreed", 10);
        dog = new Dog("TestDog", "TestBreed", 10);
    }

    @Test
    public void returnOurDog_returns_our_object(){
        //Arrange
        Dog turkey = new Dog("Turkey", "Yorkie", 1);
        //Act
        Dog doggie = dog.returnOurDog(turkey);

        assertDogs(turkey, doggie);
        Assert.assertEquals(turkey, doggie);
    }

    @Test
    public void returnOurCat_returns_our_object(){
        //Arrange
        Cat kitty = new Cat("Kitty", "Tabby", 2);
        //Act
        Cat otherCat = cat.returnOurCat(kitty);

        Assert.assertEquals(kitty,otherCat);
    }

    private void assertDogs(Dog dog, Dog otherDog){
        Assert.assertEquals(dog.getName(),otherDog.getName());
        Assert.assertEquals(dog.getAge(),otherDog.getAge());
        Assert.assertEquals(dog.getBreed(),otherDog.getBreed());
    }

}
