/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import com.imos.sample.IProductWithDiscountOnly;

/**
 *
 * @author pintu
 */
public class BreverageWithDiscountOnly extends Breverage implements IProductWithDiscountOnly {

    protected final double discountValue;

    public BreverageWithDiscountOnly(String name, double price, double taxValue, double discountValue) {
        super(name, price, taxValue);
        this.discountValue = discountValue;
    }

    @Override
    public double getDiscountValue() {
        return discountValue;
    }
}
