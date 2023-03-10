package com.techelevator.trees;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FruitTreeTest {

    private FruitTree fruitTree;

    @Before
    public void setup(){
        fruitTree = new FruitTree("Apple", 100);
    }

    @Test
    public void pick_5_pieces_is_successful(){
        boolean result = fruitTree.pickFruit(5);
        Assert.assertTrue("Picking fruit was not successful", result);
        int actualRemainingFruit = fruitTree.getPiecesOfFruitLeft();
        Assert.assertEquals(95, actualRemainingFruit);
    }

    @Test
    public void pick_all_fruit_is_successful(){
        boolean result = fruitTree.pickFruit(100);
        Assert.assertTrue("Picking fruit was not successful", result);
        int actualRemainFruit = fruitTree.getPiecesOfFruitLeft();
        Assert.assertEquals(0, actualRemainFruit);
    }

    @Test
    public void pick_more_than_starting_fruit_is_not_successful(){
        boolean result = fruitTree.pickFruit(101);
        Assert.assertFalse("Picking fruit was successful? Check your logic.", result);
        int actualRemainFruit = fruitTree.getPiecesOfFruitLeft();
        Assert.assertEquals(100, actualRemainFruit);
    }

    @Test
    public void pick_fruit_and_then_pick_more_fruit(){
        //Arrange
        fruitTree.pickFruit(10);
//        int actualRemainFruitAfterFirstPick = fruitTree.getPiecesOfFruitLeft();
        //Act
        boolean secondPickResult = fruitTree.pickFruit(10);
        int actualRemainFruitAfterSecondPick = fruitTree.getPiecesOfFruitLeft();
       //Assert
        Assert.assertTrue("Not able to pick a second time", secondPickResult);
        Assert.assertEquals(80, actualRemainFruitAfterSecondPick);
    }

    @Test
    public void pick_fruit_and_then_pick_more_fruit_not_successful(){
        //Arrange
        fruitTree.pickFruit(90);
//        int actualRemainFruitAfterFirstPick = fruitTree.getPiecesOfFruitLeft();
        //Act
        boolean secondPickResult = fruitTree.pickFruit(11);
        int actualRemainFruitAfterSecondPick = fruitTree.getPiecesOfFruitLeft();
        //Assert
        Assert.assertFalse("Should not able to pick a second time", secondPickResult);
        Assert.assertEquals(10, actualRemainFruitAfterSecondPick);
    }

}
