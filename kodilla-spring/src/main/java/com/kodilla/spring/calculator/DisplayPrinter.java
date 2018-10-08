package com.kodilla.spring.calculator;

import org.springframework.stereotype.Component;

@Component
public final class DisplayPrinter implements Display{

    public void displayValue(double value){
        System.out.println("The result is " + value + ".");
    }
}
