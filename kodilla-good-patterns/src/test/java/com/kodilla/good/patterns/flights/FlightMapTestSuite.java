package com.kodilla.good.patterns.flights;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FlightMapTestSuite {
    @BeforeClass
    public static void generateFlightMap() {
        Airport warszawaAir = new Airport("Warszawa");
        Airport gdyniaAir = new Airport("Gdynia");
        Airport gdanskAir = new Airport("Gdansk");
        Airport wroclawAir = new Airport("Wroclaw");
        Airport quebecAir = new Airport("Quebec");
        Airport newYorkAir = new Airport("New York");
        Airport antwerpkAir = new Airport("Antwerp");

        //Warszawa connects to every airport
        FlightMap.addFlight(warszawaAir, gdyniaAir);
        FlightMap.addFlight(warszawaAir, gdanskAir);
        FlightMap.addFlight(warszawaAir, wroclawAir);
        FlightMap.addFlight(warszawaAir, quebecAir);
        FlightMap.addFlight(warszawaAir, newYorkAir);
        FlightMap.addFlight(warszawaAir, antwerpkAir);

        //Gdynia connects only to few
        FlightMap.addFlight(gdyniaAir, gdanskAir);
        FlightMap.addFlight(gdyniaAir, warszawaAir);
        FlightMap.addFlight(gdyniaAir, wroclawAir);
        FlightMap.addFlight(gdyniaAir, antwerpkAir);

        FlightMap.addFlight(gdanskAir, antwerpkAir);
        FlightMap.addFlight(gdanskAir, gdyniaAir);

        FlightMap.addFlight(antwerpkAir, warszawaAir);
        FlightMap.addFlight(antwerpkAir, gdanskAir);
    }

    @Test
    public void testFlightMap() {
        Airport warszawaAir = new Airport("Warszawa");
        Airport gdyniaAir = new Airport("Gdynia");
        Airport antwerpkAir = new Airport("Antwerp");
        Airport newYorkAir = new Airport("New York");

        Assert.assertTrue(FlightMap.findFlight(warszawaAir, gdyniaAir));
        Assert.assertTrue(FlightMap.findFlight(antwerpkAir, gdyniaAir));
        Assert.assertFalse(FlightMap.findFlight(newYorkAir, warszawaAir));
    }
}
