/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.test;

import com.imos.sample.CalculationService;
import com.imos.sample.ChaiPointShop;
import com.imos.sample.IShop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author pintu
 */
public class ChaiPointShopInLambdaTesting {

    @Test
    public void testOne() {
        IShop shopping = new ChaiPointShop(CalculationService.calculateTotal());
        shopping.addItemToInventry("Latte", 3.5, 13.5);
        shopping.addItem("Latte");
        Assertions.assertEquals(3.5, shopping.calculate());
    }

    @Test
    public void testTwo() {
        IShop shopping = new ChaiPointShop(CalculationService.calculateTotal());
        shopping.addItemToInventry("Latte", 3.5, 13.5);
        shopping.addItem("Latte", 5);
        Assertions.assertEquals(17.5, shopping.calculate());
    }

    @Test
    public void testThree() {
        IShop shopping = new ChaiPointShop(CalculationService.calculateTotalWithTax());
        shopping.addItemToInventry("Latte", 3.5, 13.5);
        shopping.addItem("Latte", 5);
        Assertions.assertEquals(19.86, shopping.calculate());
    }

    @Test
    public void testFour() {
        ChaiPointShop shopping = new ChaiPointShop(CalculationService.calculateTotalWithDiscountAndTax());
        shopping.addItemToInventry("Latte", 3.5, 13.5, 20);
        shopping.addItem("Latte", 5);
        Assertions.assertEquals(15.89, shopping.calculate());
    }

    @Test
    public void testFive() {
        ChaiPointShop shopping = new ChaiPointShop(CalculationService.calculateTotalOnDiscountOnBuySomeGetSomeWithTax());
        shopping.addItemToInventry("Latte", 3.5, 13.5, 3, 2);
        shopping.addItem("Latte", 6);
        Assertions.assertEquals(15.89, shopping.calculate());
    }
}
