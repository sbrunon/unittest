package com.objis.taxcalculator;

public class Main {

    public static void main(String[] args) {
        String jvm = System.getProperty("java.version");
        String osName = System.getProperty("os.name"); 
        String osVersion = System.getProperty("os.version"); 
        
        System.out.println("Running Java " + jvm 
                           + " on " + osName
                           + " (version " + osVersion + ")");
    }
}
