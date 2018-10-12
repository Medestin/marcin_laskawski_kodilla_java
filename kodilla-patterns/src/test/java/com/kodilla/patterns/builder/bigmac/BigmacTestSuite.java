package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BigmacTestSuite {

    @Test
    public void testBigmacBuilding() {
        List<Ingredients> ingredients = new ArrayList<>();
        ingredients.add(Ingredients.CHEESE);
        ingredients.add(Ingredients.BACON);
        ingredients.add(Ingredients.LETTUCE);

        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun(Bun.NO_SESAME)
                .burgers(2)
                .sauce(Sauce.CLASSIC)
                .ingredient(Ingredients.ONIONS)
                .ingredients(ingredients)
                .build();

        System.out.println(bigmac);
        Assert.assertEquals(2, bigmac.getBurgers());
        Assert.assertEquals(4, bigmac.getIngredients().size());
    }

    @Test
    public void testInvalidNumberOfBurgers() {
        List<Ingredients> ingredients = new ArrayList<>();
        ingredients.add(Ingredients.CHEESE);
        ingredients.add(Ingredients.BACON);
        ingredients.add(Ingredients.LETTUCE);

        try {
            Bigmac bigmac = new Bigmac.BigmacBuilder()
                    .bun(Bun.NO_SESAME)
                    .burgers(0)
                    .sauce(Sauce.CLASSIC)
                    .ingredient(Ingredients.ONIONS)
                    .ingredients(ingredients)
                    .build();
            Assert.fail("Expecting exception to be thrown.");
        } catch (IllegalArgumentException e){
            Assert.assertTrue(e.getMessage().contains("Invalid number of burgers"));
        }

        try {
            Bigmac bigmac = new Bigmac.BigmacBuilder()
                    .bun(Bun.NO_SESAME)
                    .burgers(5)
                    .sauce(Sauce.CLASSIC)
                    .ingredient(Ingredients.ONIONS)
                    .ingredients(ingredients)
                    .build();
            Assert.fail("Expecting exception to be thrown.");
        } catch (IllegalArgumentException e){
            Assert.assertTrue(e.getMessage().contains("Invalid number of burgers"));
        }
    }

}
