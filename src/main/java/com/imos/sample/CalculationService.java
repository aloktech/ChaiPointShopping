/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import java.math.BigDecimal;

/**
 *
 * @author pintu
 */
public class CalculationService {

    private static final BigDecimal HUNDRED_PERCENTAGE = BigDecimal.valueOf(100);

    public static ICalculateService calculateTotal() {
        return (IProduct product, int count) -> BigDecimal.valueOf(product.getPrice())
                .multiply(BigDecimal.valueOf(count))
                .doubleValue();
    }

    public static ICalculateService calculateTotalWithTax() {
        return (IProduct product, int count) -> {
            double total = calculateTotal().calculate(product, count);
            return BigDecimal.valueOf(total).add(percentageCalculation(total, product.getTaxValue()))
                    .doubleValue();
        };
    }

    public static ICalculateService calculateTotalWithDiscountAndTax() {
        return (IProduct product, int count) -> {
            IProductWithDiscountOnly productDisc = (IProductWithDiscountOnly) product;
            double total = calculateTotal().calculate(product, count);
            BigDecimal discountValue = percentageCalculation(total, productDisc.getDiscountValue());
            double temp = BigDecimal.valueOf(total).subtract(discountValue).doubleValue();
            return BigDecimal.valueOf(temp).add(percentageCalculation(temp, product.getTaxValue()))
                    .doubleValue();
        };
    }

    public static ICalculateService calculateTotalOnDiscountOnBuySomeGetSomeWithTax() {
        return (IProduct product, int count) -> {
            IProductWithDiscount1BuySomeGetSome productDisc = (IProductWithDiscount1BuySomeGetSome) product;
            count = calculateDiscountCount(count, productDisc.getBaseCount(), productDisc.getDiscountCount());
            double total = calculateTotal().calculate(product, count);
            return BigDecimal.valueOf(total).add(percentageCalculation(total, productDisc.getTaxValue()))
                    .doubleValue();
        };
    }

    private static BigDecimal percentageCalculation(double baseValue, double percentageValue) {
        return BigDecimal.valueOf(baseValue)
                .multiply(BigDecimal.valueOf(percentageValue))
                .divide(HUNDRED_PERCENTAGE)
                .setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }

    private static int calculateDiscountCount(int count, int baseCount, int discountCount) {
        int index = 0;
        int threashold = baseCount + discountCount;
        int goodies = 0;
        while (count > 0) {
            count--;
            index++;
            goodies++;
            if (index == threashold) {
                goodies -= discountCount;
                index = 0;
            }
        }
        return goodies;
    }
}
