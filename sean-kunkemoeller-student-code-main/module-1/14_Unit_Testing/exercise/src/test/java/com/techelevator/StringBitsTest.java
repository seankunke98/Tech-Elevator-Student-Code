package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class StringBitsTest {

    StringBits testStringBits = new StringBits();

    @Test
    public void test_for_Hello() {
        String expectedResult = "Hlo";
        String testData = "Hello";
        String actualResult = testStringBits.getBits(testData);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_for_Heeololeo() {
        Assert.assertEquals("Hello", testStringBits.getBits("Heeololeo"));
    }

    @Test
    public void test_for_null() {
        Assert.assertEquals("", testStringBits.getBits(null));
    }

    @Test
    public void test_for_single_char() {
        Assert.assertEquals("a", testStringBits.getBits("a"));
    }
}
