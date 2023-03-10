package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class MaxEnd3Test {
    MaxEnd3 testMaxEndThree = new MaxEnd3();


    @Test
    public void test_for_123() {
        int[] expectedArray = {3, 3, 3};
        int[] resultArray = {1, 2, 3};
        Assert.assertEquals(expectedArray, testMaxEndThree.makeArray(resultArray));
    }

    @Test
    public void test_for_1159() {
        int[] expectedArray = {11, 11, 11};
        int[] resultArray = {11, 5, 9};
        Assert.assertEquals(expectedArray, testMaxEndThree.makeArray(resultArray));
    }



    @Test
    public void test_for_2113() {
        int[] expectedArray = {11, 11, 11};
        int[] resultArray = {2, 11, 3};
        Assert.assertEquals(expectedArray, testMaxEndThree.makeArray(resultArray));
    }

    @Test
    public void test_for_000() {
        int[] expectedArray = {0, 0, 0};
        int[] resultArray = {0, 0, 0};
        Assert.assertEquals(expectedArray, testMaxEndThree.makeArray(resultArray));
    }
}
