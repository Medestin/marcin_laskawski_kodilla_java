package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class Calculator {

    @Autowired
    private Display display;

    public double add(double value1, double value2){
        double result = value1 + value2;
        display.displayValue(result);
        return result;
    }

    public double sub(double value1, double value2){
        double result = value1 - value2;
        display.displayValue(result);
        return result;
    }

    public double mul(double value1, double value2){
        double result = value1 * value2;
        display.displayValue(result);
        return result;
    }

    public double div(double value1, double value2){
        double result = value1 / value2;
        display.displayValue(result);
        return result;
    }

}
