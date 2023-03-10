package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AnimalGroupNameTest {
    private AnimalGroupName animalGroupName;

    @Before
    public void setup(){
        animalGroupName = new AnimalGroupName();
    }

    @Test
    public void provide_known_animal_name_expect_herd_name_returned(){
        String herdResult = animalGroupName.getHerd("giraffe");
        Assert.assertEquals("Tower", herdResult);
    }

    @Test
    public void provide_different_case_of_known_animal_name_expect_herd_name_returned(){
        String herdResult = animalGroupName.getHerd("Giraffe");
        Assert.assertEquals("Tower", herdResult);
    }

    @Test
    public void provide_unknown_animal_name_expect_unknown_returned() {
        String herdResult = animalGroupName.getHerd("Sean");
        Assert.assertEquals("unknown", herdResult);
    }
    @Test
    public void provide_null_animal_name_expect_unknown_returned() {
        String herdResult = animalGroupName.getHerd(null);
        Assert.assertEquals("unknown", herdResult);
    }

    @Test
    public void provide_empty_string_for_animal_name_expect_unknown_returned() {
        String herdResult = animalGroupName.getHerd("");
        Assert.assertEquals("unknown", herdResult);
    }




}
