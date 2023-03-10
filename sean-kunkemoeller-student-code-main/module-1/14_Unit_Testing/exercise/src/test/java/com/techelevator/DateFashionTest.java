package com.techelevator;

import org.junit.Assert;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class DateFashionTest {
    DateFashion testDateFashion = new DateFashion();


    @Test
    public void test_for_5_10() {
        Assert.assertEquals(2, testDateFashion.getATable(5, 10));;
    }

    @Test
    public void test_for_5_2() {
        Assert.assertEquals(0, testDateFashion.getATable(5, 2));;
    }

    @Test
    public void test_for_5_5() {
        Assert.assertEquals(1, testDateFashion.getATable(5, 5));;
    }

    @Test
    public void test_for_0_10() {
        Assert.assertEquals(0, testDateFashion.getATable(0, 10));;
    }

}
