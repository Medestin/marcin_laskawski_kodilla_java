package com.kodilla.good.patterns.flights;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FlightMap {
    private static final Set<Connection> connections = new HashSet<>();

    public static void addFlight(Airport departure, Airport arrival) {
        connections.add(new Connection(departure, arrival));
    }

    public static Set<Connection> getConnections() {
        return new HashSet<>(connections);
    }

    public static List<Airport> getDestinations(Airport airport) {
        List<Airport> destinations = new ArrayList<>();
        connections.stream()
                .filter(n -> n.getDeparture().equals(airport))
                .forEach(n -> destinations.add(n.getArrival()));

        return destinations;
    }

    public static List<Airport> getArrivals(Airport airport) {
        List<Airport> arrivals = new ArrayList<>();
        connections.stream()
                .filter(n -> n.getArrival().equals(airport))
                .forEach(n -> arrivals.add(n.getDeparture()));

        return arrivals;
    }

    public static boolean findFlight(Airport departure, Airport arrival) {
        if (connections.contains(new Connection(departure, arrival))) {
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
