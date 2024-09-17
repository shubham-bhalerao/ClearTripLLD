package com.cleartrip.strategies;

import com.cleartrip.models.Flight;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.*;

public class CheapestRouteStrategy implements RouteStrategy {

    @Override
    public String getStrategyName() {
        return "Cheapest Route";
    }


    @Override
    public List<Flight> findRoute(String sourceCity, String destinationCity, List<Flight> flights) {

        System.out.println("Finding Cheapest Flight between " + sourceCity + " destinationCity " + destinationCity);

        for(int i=0;i<flights.size();i++) {
            System.out.println("Flights available " + flights.get(i).toString());
        }

        Map<String, Double> minCost = new HashMap<>();

        Map<String, Flight> previousFlight = new HashMap<>();

        PriorityQueue<FlightNode> pq = new PriorityQueue<>(Comparator.comparingDouble(f -> f.totalCost));

        minCost.put(sourceCity, 0.0);
        pq.add(new FlightNode(sourceCity, 0.0, null));

        while (!pq.isEmpty()) {
            FlightNode currentNode = pq.poll();
            String currentCity = currentNode.city;

            if (currentCity.equals(destinationCity)) {
                return reconstructPath(destinationCity, previousFlight);
            }

            for (Flight flight : flights) {
                if (flight.getSourceCity().equals(currentCity)) {
                    String nextCity = flight.getDestinationCity();
                    double newCost = currentNode.totalCost + flight.getPrice();

                    if (newCost < minCost.getOrDefault(nextCity, Double.MAX_VALUE)) {
                        minCost.put(nextCity, newCost);
                        previousFlight.put(nextCity, flight);
                        pq.add(new FlightNode(nextCity, newCost, flight));
                    }
                }
            }
        }

        return new ArrayList<>();
    }

    private List<Flight> reconstructPath(String destinationCity, Map<String, Flight> previousFlight) {
        List<Flight> path = new ArrayList<>();
        Flight flight = previousFlight.get(destinationCity);

        while (flight != null) {
            path.add(0, flight);
            flight = previousFlight.get(flight.getSourceCity().toString());
        }

        return path;
    }

    private static class FlightNode {
        String city;
        double totalCost;
        Flight flight;

        public FlightNode(String city, double totalCost, Flight flight) {
            this.city = city;
            this.totalCost = totalCost;
            this.flight = flight;
        }
    }
}
