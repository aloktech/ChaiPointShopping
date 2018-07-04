/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.cps.product;

import com.imos.cps.product.IProduct;

/**
 *
 * @author pintu
 */
public class Breverage implements IProduct {

    protected final String name;
    protected final double price;
    protected final double taxValue;

    public Breverage(String name, double price, double taxValue) {
        this.name = name;
        this.taxValue = taxValue;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getTaxValue() {
        return taxValue;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
