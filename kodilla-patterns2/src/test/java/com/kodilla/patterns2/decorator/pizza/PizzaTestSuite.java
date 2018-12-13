package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PizzaTestSuite {

    @Test
    public void testBasicPizza(){
        Pizza pizza = new BasicPizza();

        BigDecimal cost = pizza.getCost();
        String description = pizza.getDescription();

        assertEquals(new BigDecimal(15), cost);
        assertEquals("Dough, tomato sauce", description);
    }

    @Test
    public void testExtraCheese(){
        Pizza pizza = new BasicPizza();
        pizza = new ExtraCheeseDecorator(pizza);

        BigDecimal cost = pizza.getCost();
        String description = pizza.getDescription();

        assertEquals(new BigDecimal(19), cost);
        assertEquals("Dough, tomato sauce, extra cheese", description);
    }

    @Test
    public void testPizzaWithHamPepperoniShroomsExtraCheese(){
        Pizza pizza = new BasicPizza();
        pizza = new HamDecorator(pizza);
        pizza = new PepperoniDecorator(pizza);
        pizza = new ShroomsDecorator(pizza);
        pizza = new ExtraCheeseDecorator(pizza);

        BigDecimal cost = pizza.getCost();
        String description = pizza.getDescription();

        assertEquals(new BigDecimal(26), cost);
        assertEquals("Dough, tomato sauce, ham, pepperoni, shrooms, extra cheese", description);
    }

}