package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class SameFirstLastTest {

    SameFirstLast testSameFirstLast = new SameFirstLast(); // instantiate an object with the methods to test

    @Test
    public void test_for_123() {
        int[] result = {1, 2, 3};
        Assert.assertEquals(false, testSameFirstLast.isItTheSame(result));
    }

    @Test
    public void test_for_1231() {
        int[] result = {1, 2, 3, 1};
        Assert.assertEquals(true, testSameFirstLast.isItTheSame(result));
    }

    @Test
    public void test_for_121() {
        int[] result = {1, 2, 1};
        Assert.assertEquals(true, testSameFirstLast.isItTheSame(result));
    }

    @Test
    public void test_for_100001() {
        int[] result = {1, 0, 0, 0, 0, 1};
        Assert.assertEquals(true, testSameFirstLast.isItTheSame(result));
    }

    @Test
    public void test_for_10000() {
        int[] result = {1, 0, 0, 0, 0};
        Assert.assertEquals(false, testSameFirstLast.isItTheSame(result));
    }
}
