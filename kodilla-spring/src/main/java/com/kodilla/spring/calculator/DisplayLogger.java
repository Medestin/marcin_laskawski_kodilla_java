package com.kodilla.spring.calculator;

import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public final class DisplayLogger implements Display {
    private static final Logger logger = Logger.getLogger(Logger.class.getName());

    public void displayValue(double value){
        logger.log(Level.INFO, "The result is " + value + ".");
    }
}
