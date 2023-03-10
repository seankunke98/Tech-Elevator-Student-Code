package com.techelevator;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LectureTest {

    private Lecture lecture;

    @Before
    public void setup() {
        lecture = new Lecture(100);

    }
    /*
        @After
        We could have a method here to run after each test is run, but since these tests don't require
        any cleanup we can omit it.
     */

    /*
        Asserting results for different data types

        The following tests show how to assert results for different data types that may be returned from
        a method.
     */

    //usually test name are snaking_case (underscores)

    /*
        Asserting true
     */
    @Test
    public void assertingBooleanTrue() {
        //Arrange in @Before
        //Act (declaring boolean variable that evaluates specified test (lecture))
        boolean result = lecture.or35(9);
        //Assert (asserting true or false based on what result you want)
        Assert.assertTrue(result);
    }

    /*
        Asserting false
     */
    @Test
    public void assertingBooleanFalse() {
        boolean result = lecture.or35(2);
        Assert.assertFalse(result);
    }

    /*
        Asserting int
     */
    @Test
    public void assertingInt() {
        int result = lecture.doubleNumber(2);
        Assert.assertEquals(4, result);
    }

    /*
     * Asserting double to 2 decimal places
     */
    @Test
    public void assertDoubleTo2DecimalPlaces() {
        double result = lecture.thirdDouble(10);
        Assert.assertEquals(3.33, result, 0.009);
    }

    /*
     * Asserting double to 4 decimal places
     */
    @Test
    public void assertDoubleTo4DecimalPlaces() {
        double result = lecture.thirdDouble(10);
        Assert.assertEquals(3.3333, result, 0.00009);
    }

    /*
        Asserting double to 1 decimal place
     */
    @Test
    public void assertDoubleTo1DecimalPlaces() {
        double result = lecture.thirdDouble(10);
        Assert.assertEquals(3.3, result, 0.09);
    }

    /*
        Asserting double to a whole number
     */
    @Test
    public void assertDoubleToWholeNumber() {
        double result = lecture.thirdDouble(10);
        Assert.assertEquals(3, result, 0.9);
    }

    /*
        Asserting Strings
     */
    @Test
    public void assertString() {
        String result = lecture.firstTwo("Hello");
        Assert.assertEquals("He", result);
    }

    /*
        Asserting Arrays
     */
    @Test
    public void assertArrayUsingArrayEquals() {
        // Arrange (setup)
        int[] testArray = {2, 4, 6};
        int[] expectedResult = {4, 8, 12};

        //Act
        int[] actualResult = lecture.doubleAllNumbers(testArray);

        // Assert
        Assert.assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void assert_empty_str_is_returned() {
        String result = lecture.firstTwo("");
        Assert.assertEquals("", result);
    }




    /*
        Asserting List
     */
    @Test
    public void assertListUsingEquals() {
        // Arrange (setup)
        String[] testArray = {"Train", "Boat", "Car"};
        List<String> expectedResult = new ArrayList<String>();
        expectedResult.add("Train");
        expectedResult.add("Car");

        // Act (test)
        List<String> actualResult = lecture.no4LetterWords(testArray);

        // Assert
        /*
        This works for built in data types.  For custom data types the
        .equals method must be Overridden in the class the defines it.
         */
        Assert.assertEquals(expectedResult, actualResult);
    }

    // Map
    @Test
    public void assertListUsingMapEquals() {
        // Arrange (Setup)
        Map<String, Integer> testMap = new HashMap<String, Integer>();
        testMap.put("Peter", 2000);
        testMap.put("Paul", 99);

        Map<String, Integer> expectedResult = new HashMap<String, Integer>();
        expectedResult.put("Peter", 1000);
        expectedResult.put("Paul", 1099);

        // Act (test)
        Map<String, Integer> actualResult = lecture.robPeterToPayPaul(testMap);

        // Assert
          /*
        This works for built in data types.  For custom data types the
        .equals() and hashCode() methods must be Overridden in the class the defines it.
         */
        Assert.assertEquals(expectedResult, actualResult);

    }

    //objects
    //to see comparing objects see AnimalTest

    //testing a void method
    @Test
    public void assert_addToBalance_increases_lecture_balance(){
        //Arrange
        //in setup lecture has starting balance of 100
        int amountToAdd = 10;
        //make sure I call getBalance and assign to expected prior to adding money
        int expectedNewBalance = lecture.getBalance() + amountToAdd;
        //Act
        lecture.addToBalance(amountToAdd); //adding to balance in lecture class

        int actualNewBalance = lecture.getBalance();

        Assert.assertEquals(expectedNewBalance, actualNewBalance);
    }
}