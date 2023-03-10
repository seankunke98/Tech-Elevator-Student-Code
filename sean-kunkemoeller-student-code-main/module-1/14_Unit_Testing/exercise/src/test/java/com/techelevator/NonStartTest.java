package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class NonStartTest {

    NonStart testNonStart = new NonStart(); // instantiate an object with the methods to test

    @Test
    public void test_for_Hello_There() {
        Assert.assertEquals("ellohere", testNonStart.getPartialString("Hello", "There"));
    }

    @Test
    public void test_for_java_code() {
        Assert.assertEquals("avaode", testNonStart.getPartialString("Java", "Code"));
    }

    @Test
    public void test_for_shoot_shoot() {
        Assert.assertEquals("hoothoot", testNonStart.getPartialString("Shoot", "Shoot"));
    }

    @Test
    public void test_for_blankString() {
        Assert.assertEquals("", testNonStart.getPartialString("", ""));
    }
}
