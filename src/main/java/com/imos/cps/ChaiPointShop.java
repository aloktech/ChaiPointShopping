/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.cps;

import com.imos.cps.service.ICalculateService;

/**
 *
 * @author pintu
 */
public class ChaiPointShop extends AbstractShop {

    public ChaiPointShop(ICalculateService service) {
        super(service);
    }

    @Override
    public double calculate() {
        return productPurchasedMap.keySet()
                .stream()
                .map(p -> service.calculate(p, productPurchasedMap.get(p)))
                .reduce(0.0, (a, b) -> {
                    return a + b;
                });
    }
}
