package com.objis.taxcalculator.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * A tax calculator
 * 
 * @author wakaleo
 * 
 */
public class TaxCalculator {

    public static final List<TaxRate> TAX_RATES = new ArrayList<TaxRate>();

    static {
        TAX_RATES.add(new TaxRate(0, 38000, 0.195));
        TAX_RATES.add(new TaxRate(38000, 60000, 0.33));
        TAX_RATES.add(new TaxRate(60000, 0, 0.39));
    }

    public TaxCalculator() {
    }

    public double calculateIncomeTax(double totalRevenue) {

        assert totalRevenue >= 0 : "Revenue should not be negative";

        double totalTax = 0.0;
        for (TaxRate rate : TAX_RATES) {
            totalTax += rate.calculateTax(totalRevenue);
        }
        return totalTax;
    }
}
