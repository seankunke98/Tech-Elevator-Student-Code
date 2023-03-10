package com.techelevator.animals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AnimalsTests {
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
        Assert.assertEquals(turkey.getName(), doggie.getName()); //asserting turkey should = doggie
        Assert.assertEquals(turkey.getAge(), doggie.getAge());
        Assert.assertEquals(turkey.getBreed(), doggie.getBreed());
        assertDogs(turkey, doggie);
    }
    @Test
    public void returnOurCat_returns_our_object(){
        Cat kitty = new Cat("kitty", "tabby", 1);
        Cat otherCat = cat.returnOurCat(kitty);
        Assert.assertEquals(kitty, otherCat);
    }


    private void assertDogs(Dog dog, Dog otherDog){
        Assert.assertEquals(dog.getName(), otherDog.getName()); //asserting turkey should = doggie
        Assert.assertEquals(dog.getAge(), otherDog.getAge());
        Assert.assertEquals(dog.getBreed(), otherDog.getBreed());
    }

}
