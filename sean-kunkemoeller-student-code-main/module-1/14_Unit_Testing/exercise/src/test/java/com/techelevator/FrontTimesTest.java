package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class FrontTimesTest {

    FrontTimes testFrontTimes = new FrontTimes();

    @Test
    public void test_for_computer_2() {
        Assert.assertEquals("ComCom", testFrontTimes.generateString("Computer", 2));
    }

    @Test
    public void test_for_computer_3() {
        Assert.assertEquals("ComComCom", testFrontTimes.generateString("Computer", 3));;
    }

    @Test
    public void test_for_fly_3() {
        Assert.assertEquals("FlyFlyFly", testFrontTimes.generateString("Fly", 3));;
    }

    @Test
    public void test_for_fly_0() {
        Assert.assertEquals("", testFrontTimes.generateString("Fly", 0));
    }

    @Test
    public void test_for_null_1() {
        Assert.assertEquals("", testFrontTimes.generateString("null", 1));;
    }
}
