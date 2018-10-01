package com.kodilla.good.patterns.flights;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static com.kodilla.good.patterns.flights.FlightMap.addFlight;
import static com.kodilla.good.patterns.flights.FlightNetworkService.isFlightAvailable;

public class FlightMapServiceTestSuite {

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
        addFlight(warszawaAir, gdyniaAir);
        addFlight(warszawaAir, gdanskAir);
        addFlight(warszawaAir, wroclawAir);
        addFlight(warszawaAir, quebecAir);
        addFlight(warszawaAir, newYorkAir);
        addFlight(warszawaAir, antwerpkAir);

        //Gdynia connects only to few
        addFlight(gdyniaAir, gdanskAir);
        addFlight(gdyniaAir, warszawaAir);
        addFlight(gdyniaAir, wroclawAir);
        addFlight(gdyniaAir, antwerpkAir);

        addFlight(gdanskAir, antwerpkAir);
        addFlight(gdanskAir, gdyniaAir);

        addFlight(antwerpkAir, warszawaAir);
        addFlight(antwerpkAir, gdanskAir);
    }

    @Test
    public void testFlightMap() {
        Airport warszawaAir = new Airport("Warszawa");
        Airport gdyniaAir = new Airport("Gdynia");
        Airport antwerpkAir = new Airport("Antwerp");
        Airport newYorkAir = new Airport("New York");

        Assert.assertTrue(isFlightAvailable(warszawaAir, gdyniaAir));
        Assert.assertTrue(isFlightAvailable(antwerpkAir, gdyniaAir));
        assertFalse(isFlightAvailable(newYorkAir, warszawaAir));
    }
}
