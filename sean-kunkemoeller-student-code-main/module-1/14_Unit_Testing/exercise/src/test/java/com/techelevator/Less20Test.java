package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Less20Test {
    Less20 testLessTwenty = new Less20();

    @Test
    public void test_for_18() {
        Assert.assertEquals(true, testLessTwenty.isLessThanMultipleOf20(18));
    }

    @Test
    public void test_for_19() {
        Assert.assertEquals(true, testLessTwenty.isLessThanMultipleOf20(19));
    }

    @Test
    public void test_for_20() {
        Assert.assertEquals(false, testLessTwenty.isLessThanMultipleOf20(20));
    }

    @Test
    public void test_for_40() {
        Assert.assertEquals(false, testLessTwenty.isLessThanMultipleOf20(30));
    }

    @Test
    public void test_for_38() {
        Assert.assertEquals(true, testLessTwenty.isLessThanMultipleOf20(38));
    }

    @Test
    public void test_for_39() {
        Assert.assertEquals(true, testLessTwenty.isLessThanMultipleOf20(39));
    }
}
