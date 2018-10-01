package com.kodilla.good.patterns.flights;

import java.util.ArrayList;
import java.util.List;
import static com.kodilla.good.patterns.flights.FlightMap.getConnections;
import static com.kodilla.good.patterns.flights.FlightMap.getDestinations;
import static com.kodilla.good.patterns.flights.FlightMap.getArrivals;

public class FlightNetworkService {
    public static boolean isFlightAvailable(Airport departure, Airport arrival) {
        if (getConnections().contains(new Connection(departure, arrival))) {
            return true;
        } else {
            List<Airport> connectingPoints = findDeepConnection(departure, arrival);
            if (!connectingPoints.isEmpty()) {
                System.out.println("Flight possible with connecting point(s): ");
                System.out.println(connectingPoints);
                return true;
            } else {
                return false;
            }
        }
    }

    private static List<Airport> findDeepConnection(Airport departure, Airport arrival) {
        List<Airport> possibleDepartures = new ArrayList<>(getDestinations(departure));
        List<Airport> possibleArrivals = new ArrayList<>(getArrivals(arrival));

        possibleDepartures.retainAll(possibleArrivals);
        return possibleDepartures;
    }
}
