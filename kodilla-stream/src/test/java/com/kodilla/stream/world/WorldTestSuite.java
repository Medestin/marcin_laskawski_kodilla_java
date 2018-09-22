package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite {

    @Test
    public void testGetPeopleQuantity() {

        Continent northAmerica = new Continent();
        Country canada = new Country(new BigDecimal("35295770"));
        Country usa = new Country(new BigDecimal("317706000"));
        northAmerica.addCountry(canada);
        northAmerica.addCountry(usa);

        Continent southAmerica = new Continent();
        Country mexico = new Country(new BigDecimal("119713203"));
        Country brazil = new Country(new BigDecimal("201032714"));
        Country argentina = new Country(new BigDecimal("40913584"));
        southAmerica.addCountry(mexico);
        southAmerica.addCountry(brazil);
        southAmerica.addCountry(argentina);

        Continent europe = new Continent();
        Country germany = new Country(new BigDecimal("80619000"));
        Country poland = new Country(new BigDecimal("38502396"));
        Country hungary = new Country(new BigDecimal("9906000"));
        Country estonia = new Country(new BigDecimal("1311870"));
        europe.addCountry(germany);
        europe.addCountry(poland);
        europe.addCountry(hungary);
        europe.addCountry(estonia);

        World world = new World();
        world.addContinent(northAmerica);
        world.addContinent(southAmerica);
        world.addContinent(europe);

        // Sum of the population by hand is: 845 000 537
        Assert.assertEquals(new BigDecimal("845000537"), world.getWorldPopulation());
    }

}
