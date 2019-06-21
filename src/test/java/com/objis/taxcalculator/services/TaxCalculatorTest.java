package com.objis.taxcalculator.services;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.objis.taxcalculator.domain.TaxCalculator;

@RunWith(Parameterized.class)
public class TaxCalculatorTest {

    @Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                /* Income      Tax  */
                {     0.00,     0.00},
                { 10000.00,  1950.00},
                { 20000.00,  3900.00},
                { 38000.00,  7410.00},
                { 38001.00,  7410.33},
                { 40000.00,  8070.00},
                { 60000.00, 14670.00},
                {100000.00, 30270.00},
                {160000.00, 53670.00},
                {200000.00, 69270.00},
        });
    }

    private double revenue;
    private double expectedTax;
    private TaxCalculator calculator = new TaxCalculator();

    public TaxCalculatorTest(double input, double expectedTax) {
        this.revenue = input;
        this.expectedTax = expectedTax;
    }
    
    @Test public void calculateTax() {
        assertEquals(expectedTax, calculator.calculateIncomeTax(revenue), 0.0);
    }
}
