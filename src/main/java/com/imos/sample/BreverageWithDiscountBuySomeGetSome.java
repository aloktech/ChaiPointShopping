/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import com.imos.sample.IProductWithDiscount1BuySomeGetSome;

/**
 *
 * @author pintu
 */
public class BreverageWithDiscountBuySomeGetSome extends Breverage implements IProductWithDiscount1BuySomeGetSome {

    protected final int baseCount;
    protected final int discountCount;

    public BreverageWithDiscountBuySomeGetSome(String name, double price, double taxValue, int baseCount, int discountCount) {
        super(name, price, taxValue);
        this.baseCount = baseCount;
        this.discountCount = discountCount;
    }

    @Override
    public int getBaseCount() {
        return baseCount;
    }

    @Override
    public int getDiscountCount() {
        return discountCount;
    }
}
