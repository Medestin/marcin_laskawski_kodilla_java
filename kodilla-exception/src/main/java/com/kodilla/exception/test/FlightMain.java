package com.kodilla.exception.test;

public class FlightMain {
    public static void main(String[] args){

        FlightFinder flightFinder = new FlightFinder();

        Flight trueFlight = new Flight("depAir1", "KochanowskiAirport");
        Flight falseFlight = new Flight("depAir1", "ChopinAirport");
        Flight noSuchFlight = new Flight("depAir1", "depAir1");

        try{
           boolean isFlightAvailable = flightFinder.findFlight(trueFlight);
            System.out.println("Is " + trueFlight + " available? " + isFlightAvailable);
        } catch (RouteNotFoundException e){
            System.out.println("OOPS, route not found!");
        }

        try{
            boolean isFlightAvailable = flightFinder.findFlight(falseFlight);
            System.out.println("Is " + falseFlight + " available? " + isFlightAvailable);
        } catch (RouteNotFoundException e){
            System.out.println("OOPS, route not found!");
        }

        try{
            boolean isFlightAvailable = flightFinder.findFlight(noSuchFlight);
            System.out.println("Is " + noSuchFlight + " available? " + isFlightAvailable);
        } catch (RouteNotFoundException e){
            System.out.println("OOPS, route not found for " + noSuchFlight + "!");
        }
    }
}
