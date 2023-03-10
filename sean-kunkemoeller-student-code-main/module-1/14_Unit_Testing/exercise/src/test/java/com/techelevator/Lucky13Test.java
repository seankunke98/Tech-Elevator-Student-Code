package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Lucky13Test {
    Lucky13 testLuckyThirteen = new Lucky13();

    @Test
    public void test_for_024() {
        int[] testResult = {0, 2, 4};
        Assert.assertTrue(testLuckyThirteen.getLucky(testResult));
    }

    @Test
    public void test_for_123() {
        int[] testResult = {1, 2, 3};
        Assert.assertFalse(testLuckyThirteen.getLucky(testResult));
    }

    @Test
    public void test_for_124() {
        int[] testResult = {1, 2, 4};
        Assert.assertFalse(testLuckyThirteen.getLucky(testResult));
    }

    @Test
    public void test_for_111() {
        int[] testResult = {1, 1, 1};
        Assert.assertFalse(testLuckyThirteen.getLucky(testResult));
    }

    @Test
    public void test_for_222() {
        int[] testResult = {2, 2, 2};
        Assert.assertTrue(testLuckyThirteen.getLucky(testResult));
    }

    @Test
    public void test_for_333() {
        int[] testResult = {3, 3, 3};
        Assert.assertFalse(testLuckyThirteen.getLucky(testResult));
    }

    @Test
    public void test_for_000() {
        int[] testResult = {0, 0, 0};
        Assert.assertTrue(testLuckyThirteen.getLucky(testResult));
    }
}
