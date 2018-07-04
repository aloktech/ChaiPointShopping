/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.cps.service;

import com.imos.cps.product.IProduct;

/**
 *
 * @author pintu
 */
@FunctionalInterface
public interface ICalculateService {

    double calculate(IProduct product, int count);
}
