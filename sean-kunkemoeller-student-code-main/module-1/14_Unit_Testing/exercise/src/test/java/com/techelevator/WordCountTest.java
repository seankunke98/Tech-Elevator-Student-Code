package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class WordCountTest {
    WordCount testWordCount = new WordCount();

    @Test
    public void test_for_baba_blacksheep() {
        Map<String, Integer> expected = new HashMap<String, Integer>();
        expected.put("ba", 2);
        expected.put("black", 1);
        expected.put("sheep", 1);
        String[] testArray = {"ba", "ba", "black", "sheep"};
        Assert.assertEquals(expected, testWordCount.getCount(testArray));
    }

    @Test
    public void test_for_abacb() {
        Map<String, Integer> expected = new HashMap<String, Integer>();
        expected.put("a", 2);
        expected.put("b", 2);
        expected.put("c", 1);
        String[] testArray = {"a", "b", "a", "c", "b"};
        Assert.assertEquals(expected, testWordCount.getCount(testArray));
    }

    @Test
    public void test_for_blank() {
        Map<String, Integer> expected = new HashMap<String, Integer>();
        String[] testArray = {};
        Assert.assertEquals(expected, testWordCount.getCount(testArray));
    }

    @Test
    public void test_for_cba() {
        Map<String, Integer> expected = new HashMap<String, Integer>();
        expected.put("c", 1);
        expected.put("b", 1);
        expected.put("a", 1);
        String[] testArray = {"c", "b", "a"};
        Assert.assertEquals(expected, testWordCount.getCount(testArray));
    }
}
