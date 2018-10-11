package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {

    @Test
    public void testBigmacBuilding(){
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun(Bun.NO_SESAME)
                .burgers(0)
                .sauce(Sauce.CLASSIC)
                .ingredients(Ingredients.ONIONS)
                .ingredients(Ingredients.CHEESE)
                .ingredients(Ingredients.BACON)
                .ingredients(Ingredients.LETTUCE)
                .build();

        System.out.println(bigmac);
        Assert.assertEquals(1, bigmac.getBurgers());
        Assert.assertEquals(4, bigmac.getIngredients().size());
    }
}
