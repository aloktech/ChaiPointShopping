/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

/**
 *
 * @author pintu
 */
public interface IShop {

    double calculate();

    void addItemToInventry(String name, double priceAmount, double taxAmount);

    void changeItemFromInventry(String name, double priceAmount, double taxAmount);

    void deleteItemFromInventry(String name);

    void addItem(String name);

    void addItem(String name, int count);
}
