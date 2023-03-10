package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class FlowerShopTest {

    @Test
    public void deliveryTotal_sameDay_false_and_zipCode_20000_returns3_99() {
        //Arrange
        FlowerShop flowerShop = new FlowerShop("string", 1);
        BigDecimal expected = new BigDecimal("3.99");
        // Act
        BigDecimal actual = flowerShop.deliveryTotal(false, "20000");

        // Assert
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void deliveryTotal_sameDay_true_and_zipCode_20000_returns9_98() {
        FlowerShop flowerShop = new FlowerShop("String", 12);
        BigDecimal expected = new BigDecimal("9.98");

        BigDecimal actual = flowerShop.deliveryTotal(true, "20000");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void deliveryTotal_sameDay_false_and_zipCode_30000_returns6_99() {
        FlowerShop flowerShop = new FlowerShop("String", 12);
        BigDecimal expected = new BigDecimal("6.99");

        BigDecimal actual = flowerShop.deliveryTotal(false, "30000");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void deliveryTotal_sameDay_true_and_zipCode_39999_returns12_98() {
        FlowerShop flowerShop = new FlowerShop("String", 12);
        BigDecimal expected = new BigDecimal("12.98");

        BigDecimal actual = flowerShop.deliveryTotal(true, "39999");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void deliveryTotal_sameDay_false_and_zipCode_10000_returns0() {
        FlowerShop flowerShop = new FlowerShop("String", 12);
        BigDecimal expected = new BigDecimal("0.00");

        BigDecimal actual = flowerShop.deliveryTotal(false, "10000");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void deliveryTotal_sameDay_true_and_zipCode_10000_returns0() {
        FlowerShop flowerShop = new FlowerShop("String", 12);
        BigDecimal expected = new BigDecimal("0.00");

        BigDecimal actual = flowerShop.deliveryTotal(true, "10000");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void deliveryTotal_sameDay_false_and_zipCode_50000_returns19_99() {
        FlowerShop flowerShop = new FlowerShop("String", 12);
        BigDecimal expected = new BigDecimal("19.99");

        BigDecimal actual = flowerShop.deliveryTotal(false, "50000");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void deliveryTotal_sameDay_true_and_zipCode_70000_returns19_99() {
        FlowerShop flowerShop = new FlowerShop("String", 12);
        BigDecimal expected = new BigDecimal("19.99");

        BigDecimal actual = flowerShop.deliveryTotal(true, "70000");

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void getSubtotal_number_of_roses_5_returns_34_94() {
        // Arrange
        FlowerShop flowerShop = new FlowerShop("Pav's bouquet", 0);
        BigDecimal expected = new BigDecimal("19.99");

        // Act
        BigDecimal actual = flowerShop.getSubtotal();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getSubtotal_number_of_roses_0_returns_19_99() {
        // Arrange
        FlowerShop flowerShop = new FlowerShop("Ken's bouquet", 5);
        BigDecimal expected = new BigDecimal("34.94");

        // Act
        BigDecimal actual = flowerShop.getSubtotal();

        // Assert
        Assert.assertEquals(expected, actual);
    }


}