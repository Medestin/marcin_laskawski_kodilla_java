package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {
    private static Calculator calculator;

    @BeforeClass
    public static void initializeCalculator() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        calculator = context.getBean(Calculator.class);
    }

    @Test
    public void testCalculations() {
        double value1 = 6.0;
        double value2 = 3.0;

        double addResult = calculator.add(value1, value2);
        double subResult = calculator.sub(value1, value2);
        double mulResult = calculator.mul(value1, value2);
        double divResult = calculator.div(value1, value2);

        Assert.assertEquals(9.0, addResult, 0.001);
        Assert.assertEquals(3.0, subResult, 0.001);
        Assert.assertEquals(18.0, mulResult, 0.001);
        Assert.assertEquals(2.0, divResult, 0.001);
    }
}
