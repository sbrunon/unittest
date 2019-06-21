package com.objis.taxcalculator.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class TaxCalculatorController {

    private static final Logger LOGGER = Logger.getLogger(TaxCalculatorController.class);
    
    public BigDecimal calculateIncomeTax(BigDecimal revenu) {
        LOGGER.debug("calculateIncomeTax");
        List<String> list = new ArrayList<String>();
        for(String value : list) {
            
        }
        return null;
    }
}
