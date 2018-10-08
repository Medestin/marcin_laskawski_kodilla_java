package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public final class Calculator {
    private final Display display;

    public Calculator(@Qualifier("displayLogger") Display display){
        this.display = display;
    }

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
