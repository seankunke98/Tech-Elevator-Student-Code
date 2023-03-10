package com.techelevator.trees;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FruitTreeTest {
    private FruitTree fruitTree;

    @Before
    public void setup(){
        fruitTree = new FruitTree("apple", 100);
    }

    @Test
    public void pick_5_pieces_is_successful() {
        boolean result = fruitTree.pickFruit(5);
        Assert.assertTrue(result);
        int actualRemainingFruit = fruitTree.getPiecesOfFruitLeft();
        Assert.assertEquals(95, actualRemainingFruit);
    }

    @Test
    public void pick_all_fruit_is_successful(){
        boolean result = fruitTree.pickFruit(100);
        Assert.assertTrue("Picking fruit was not successful", result);
        int actualRemainingFruit = fruitTree.getPiecesOfFruitLeft();
        Assert.assertEquals(0, actualRemainingFruit);
    }
    @Test
    public void pick_fruit_and_then_pick_more_fruit(){
        boolean secondPickResult = fruitTree.pickFruit(100);
    }
}
