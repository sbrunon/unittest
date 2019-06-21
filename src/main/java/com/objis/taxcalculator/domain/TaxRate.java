package com.objis.taxcalculator.domain;

public class TaxRate {

    private double minimumRevenue;
    private double maxiumuRevenue;
    private double rate;

    public TaxRate(double minimumRevenue, double maxiumuRevenue, double rate) {
        super();
        this.minimumRevenue = minimumRevenue;
        this.maxiumuRevenue = maxiumuRevenue;
        this.rate = rate;
    }
    
    public double getMinimumRevenue() {
        return minimumRevenue;
    }

    public double getMaxiumuRevenue() {
        return maxiumuRevenue;
    }

    public double getRate() {
        return rate;
    }

    private double getApplicableAmount(double totalRevenue) {
        double applicableAmount = 0.0;
        if (totalRevenue >= minimumRevenue) {
            applicableAmount = totalRevenue - minimumRevenue;
            if (maxiumuRevenue > 0) {
                if (totalRevenue > maxiumuRevenue) {
                    applicableAmount = maxiumuRevenue - minimumRevenue;
                }
            }
        }
        return applicableAmount;
    }
    
    public double calculateTax(double totalRevenue) {
        return getApplicableAmount(totalRevenue) * rate;
    }        
}
