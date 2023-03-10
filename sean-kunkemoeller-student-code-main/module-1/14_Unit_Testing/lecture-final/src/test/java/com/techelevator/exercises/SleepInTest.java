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

    /*
    Because we don't want to duplicate code, drop instantiation of SleepIn object in setup()
    * */
    @Before
    public void setup(){
        sleepIn = new SleepIn();
    }
    /**
     * Don't have to have @after - but put here for example.
     * Only include if you need to cleanup after a test
     * */
    @After
    public void cleanup(){
        System.out.println("Running after test...");
    }

    @Test
    public void do_not_sleep_in_when_weekday_and_not_on_vacation(){
        //Arrange
        //Act
        boolean actualResult = sleepIn.sleepIn(true, false);
        //Assert
        Assert.assertFalse("Do not sleep in on weekdays when not on vacation", actualResult);
    }

    @Test
    public void do_sleep_in_while_on_vacation(){
        //Arrange
        //Act
        boolean actualResult = sleepIn.sleepIn(true, true);
        //Assert
        Assert.assertTrue("Sleep away you're on vacation", actualResult);
        actualResult = sleepIn.sleepIn(false, true);
        Assert.assertTrue("Sleep away you're on vacation", actualResult);
    }

    @Test
    public void do_sleep_in_if_weekend(){
        //Arrange
        //Act
        boolean actualResult = sleepIn.sleepIn(false, false);
        //Assert
        Assert.assertTrue("Sleep in on weekends", actualResult);
    }
    @Test
    public void do_sleep_in_if_on_vacation_and_weekend(){
        //Arrange
        //Act
        boolean actualResult = sleepIn.sleepIn(false, true);
        //Assert
        Assert.assertTrue("Sleep away while on vacation", actualResult);
    }
}
