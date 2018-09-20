package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {

    private final Map<String, Boolean> flightMap = new HashMap<>();

        public FlightFinder() {
            flightMap.put("MozartAirport", true);
            flightMap.put("KochanowskiAirport", true);
            flightMap.put("ChopinAirport", false);
            flightMap.put("DostojewskiAirport", false);
            flightMap.put("MayAirport", true);
        }

    public boolean findFlight(Flight flight) throws RouteNotFoundException {

        if (flightMap.containsKey(flight.getArrivalAirport())){
            return flightMap.get(flight.getArrivalAirport());
        } else {
            throw new RouteNotFoundException();
        }

    }

}
