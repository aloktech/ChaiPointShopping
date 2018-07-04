/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author pintu
 */
public abstract class AbstractShop implements IShop {

    protected final Map<String, IProduct> productMap = Collections.synchronizedMap(new HashMap<>());
    protected final Map<IProduct, Integer> productPurchasedMap = Collections.synchronizedMap(new HashMap<>());
    protected final ICalculateService service;

    public AbstractShop(ICalculateService service) {
        this.service = service;
    }

    public void addItemToInventry(String name, double priceAmount, double taxAmount, int baseCount, int discountCount) {
        IProduct product = new BreverageWithDiscountBuySomeGetSome(name, priceAmount, taxAmount, baseCount, discountCount);
        productMap.put(name, product);
    }

    public void addItemToInventry(String name, double priceAmount, double taxAmount, double discountValue) {
        IProduct product = new BreverageWithDiscountOnly(name, priceAmount, taxAmount, discountValue);
        productMap.put(name, product);
    }

    @Override
    public void changeItemFromInventry(String name, double priceAmount, double taxAmount) {
        IProduct product = productMap.get(name);
        if (Objects.nonNull(product)) {
            product = new Breverage(name, priceAmount, taxAmount);
            productMap.put(name, product);
        }
    }

    @Override
    public void deleteItemFromInventry(String name) {
        IProduct product = productMap.get(name);
        if (Objects.nonNull(product)) {
            productMap.remove(name);
        }
    }

    @Override
    public void addItemToInventry(String name, double priceAmount, double taxAmount) {
        IProduct product = new Breverage(name, priceAmount, taxAmount);
        productMap.put(name, product);
    }

    @Override
    public void addItem(String name) {
        addItem(name, 1);
    }

    @Override
    public void addItem(String name, int count) {
        if (Objects.isNull(name) || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (count == 0) {
            throw new IllegalArgumentException();
        }
        IProduct product = productMap.get(name);
        if (Objects.isNull(product)) {
            throw new IllegalArgumentException();
        }
        productPurchasedMap.computeIfPresent(product, (p, c) -> c + count);
        productPurchasedMap.computeIfAbsent(product, p -> count);
    }
}
