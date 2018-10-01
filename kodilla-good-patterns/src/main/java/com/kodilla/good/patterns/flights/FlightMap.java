package com.kodilla.good.patterns.flights;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class FlightMap {
    private static final Set<Connection> connections = new HashSet<>();

    public static void addFlight(Airport departure, Airport arrival) {
        connections.add(new Connection(departure, arrival));
    }

    public static Set<Connection> getConnections() {
        return new HashSet<>(connections);
    }

    public static List<Airport> getDestinations(Airport airport) {
        return getConnections().stream()
                .filter(n -> n.getDeparture().equals(airport))
                .map(Connection::getArrival)
                .collect(Collectors.toList());
    }

    public static List<Airport> getArrivals(Airport airport) {
        return getConnections().stream()
                .filter(n -> n.getArrival().equals(airport))
                .map(Connection::getDeparture)
                .collect(Collectors.toList());
    }


}
