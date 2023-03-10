package com.techelevator.exercises;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FizzBuzzTest {

    private FizzBuzz fizzBuzz;

    @Before
    public void setup(){
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void fizzBuzz_generates_a_string_1_100(){
        //Arrange
        String testString = "1";
        for(int i = 2; i <= 100; i++){
            testString = testString + " " + String.valueOf(i);
        }

        String result = fizzBuzz.fizzBuzz();
        Assert.assertEquals(testString, result);
    }

    @Test
    public void fizzBuzz_String_changes_multiples_of_3_to_Fizz(){
        //Arrange
        //split returned string into array and spot check that element at index 2,5,8 is "Fizz"
        String fizzBuzzResult = fizzBuzz.fizzBuzz();
        String[] resultArray = fizzBuzzResult.split(" ");
        String fizz = "Fizz";
        for(int i = 2; i <= resultArray.length; i += 3){
            Assert.assertEquals(fizz, resultArray[i]);
        }

    }

    @Test
    public void fizzBuzz_String_changes_numbers_that_contain_a_three_to_Fizz(){
        boolean containThrees = fizzBuzz.fizzBuzz().contains("3");
        //containsThrees will be true if the string returned contains a 3
        //that means our method failed to replace all 3's
        Assert.assertFalse("fizzBuzz returned a string with a 3", containThrees);
    }



}
