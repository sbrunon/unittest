package com.objis.taxcalculator.domain;

import static org.junit.Assert.*;
import org.junit.Test;

public class TaxRateTest {

    private static final double FIRST_TAX_BRACKET_RATE = 0.195;
    private static final double SECOND_TAX_BRACKET_RATE = 0.33;
    private static final double THIRD_TAX_BRACKET_RATE = 0.39;

    @Test
    public void testCalculateTaxBracket1() {
        TaxRate rate = new TaxRate(0, 38000, FIRST_TAX_BRACKET_RATE);
        assertEquals(1.0, rate.calculateTax(0), 1.0);
        assertEquals(10000 * FIRST_TAX_BRACKET_RATE, 
                     rate.calculateTax(10000), 0.0);
        assertEquals(38000 * FIRST_TAX_BRACKET_RATE, 
                     rate.calculateTax(38000), 0.0);
        assertEquals(38000 * FIRST_TAX_BRACKET_RATE, 
                     rate.calculateTax(50000), 0.0);
    }

    @Test
    public void testCalculateTaxBracket2() {
        TaxRate rate = new TaxRate(38000, 60000, SECOND_TAX_BRACKET_RATE);
        assertEquals(0.0, rate.calculateTax(0), 0.0);
        assertEquals(0.0, rate.calculateTax(10000), 0.0);
        assertEquals(0.0, rate.calculateTax(38000), 0);
        assertEquals(2000 * SECOND_TAX_BRACKET_RATE, 
                     rate.calculateTax(40000), 0);
        assertEquals(22000 * SECOND_TAX_BRACKET_RATE,
                     rate.calculateTax(60000), 0.0);
        assertEquals(22000 * SECOND_TAX_BRACKET_RATE,
                     rate.calculateTax(80000), 0.0);
    }    

    
    @Test
    public void testCalculateTaxBracket3() {
        TaxRate rate = new TaxRate(60000, 0, THIRD_TAX_BRACKET_RATE);
        assertEquals(0.0, rate.calculateTax(0), 0.0);
        assertEquals(0.0, rate.calculateTax(10000), 0.0);
        assertEquals(0.0, rate.calculateTax(38000), 0);
        assertEquals(0.0, rate.calculateTax(40000), 0);
        assertEquals(0.0, rate.calculateTax(60000), 0.0);
        assertEquals(20000 * THIRD_TAX_BRACKET_RATE,
                     rate.calculateTax(80000), 0.0);        
        assertEquals(40000 * THIRD_TAX_BRACKET_RATE,
                     rate.calculateTax(100000), 0.0);                
    }
    
    public void testCalculateTax4() {
        TaxRate rate = new TaxRate(60000, 0, THIRD_TAX_BRACKET_RATE);
        assertEquals(0.0, rate.calculateTax(0), 0.0);
        //assertThat(rate,
    }
    
}
