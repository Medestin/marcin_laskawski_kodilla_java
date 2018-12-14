package com.kodilla.patterns2.aop.calculator;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@EnableAspectJAutoProxy
public class Calculator {

    public double add(double x, double y){
        return x + y;
    }

    public double sub(double x, double y){
        return x - y;
    }

    public double mul(double x, double y){
        return x * y;
    }

    public double div(double x, double y){
        if(y == 0.0){
            throw new ArithmeticException("Cannot divide by 0.0!");
        } else {
            return x / y;
        }
    }

    public BigDecimal factorial(BigDecimal n){
        if(n.compareTo(BigDecimal.ONE) > 0){
            return (factorial(n.subtract(BigDecimal.ONE)).multiply(n));
        } else if(n.compareTo(BigDecimal.ZERO) == 0 || n.compareTo(BigDecimal.ONE) == 0){
            return BigDecimal.ONE;
        } else {
            throw new ArithmeticException("Factorial argument negative!");
        }
    }
}
