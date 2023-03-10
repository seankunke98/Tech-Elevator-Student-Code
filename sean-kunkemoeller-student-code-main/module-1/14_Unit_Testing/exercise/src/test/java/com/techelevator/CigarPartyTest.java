package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CigarPartyTest {
    CigarParty testCigar = new CigarParty();



    @Test
    public void test_if_30_returns_false(){
        Assert.assertEquals(false, testCigar.haveParty(30, false));
    }

    @Test
    public void test_if_50_returns_false(){
        Assert.assertEquals(true, testCigar.haveParty(50, false));
    }
    @Test
    public void test_if_70_returns_true(){
        Assert.assertEquals(true, testCigar.haveParty(70, true));
    }
    @Test
    public void test_if_70_returns_false(){
        Assert.assertEquals(false, testCigar.haveParty(70, false));
    }
    @Test
    public void test_if_0_returns_false(){
        Assert.assertEquals(false, testCigar.haveParty(0, false));
    }
    @Test
    public void test_if_0_returns_true(){
        Assert.assertEquals(false, testCigar.haveParty(0, true));
    }
}
