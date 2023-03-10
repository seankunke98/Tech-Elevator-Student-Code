package com.techelevator.exercises;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SleepInTest {

    private SleepIn sleepIn;
     /*
    1. The parameter weekday is true if it is a weekday, and the parameter vacation is true if we are on
    vacation. We sleep in if it is not a weekday or we're on vacation. Return true if we sleep in.
    sleepIn(false, false) → true
    sleepIn(true, false) → false
    sleepIn(false, true) → true
    */

    //because we dont want to duplicate code, drop instantiation of SleepIn object in setup()
    @Before
    public void setup(){
        sleepIn = new SleepIn();
    }


    //dont have to have @after but put here for example
    @After
    public void cleanup(){
        System.out.println("Running after test...");
    }

    @Test
    public void do_not_sleep_in_weekday_and_not_on_vacation(){
        //Arrange
        //Act
        boolean actualResult = sleepIn.sleepIn(true, false);
        //Assert- what you expect to happen when you run test
        Assert.assertFalse("Do not sleep in on weekdays when not on vacation", actualResult);

    }

    @Test
    public void do_sleep_in_while_on_vacation_and_weekday(){
        //Arrange
        //Act
        boolean actualResult = sleepIn.sleepIn(true, true);
        //Assert
        Assert.assertTrue("Sleep away you're on vacation", actualResult);
    }

    @Test
    public void do_sleep_in_if_weekend(){
        //Arrange
        //Actual
        boolean actualResult = sleepIn.sleepIn(false, false);
        //Assert
        Assert.assertTrue("Sleep in it is the weekend", actualResult);
    }
    @Test
    public void do_sleep_in_if_on_vacation_and_weekend(){
        //Arrange
        //Act
        boolean actualResult = sleepIn.sleepIn(false, true);
        //Assert
        Assert.assertTrue("Sleep in it is vacation", actualResult);
    }


}
