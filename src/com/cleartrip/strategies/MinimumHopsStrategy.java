package com.cleartrip.strategies;

import com.cleartrip.models.City;
import com.cleartrip.models.Flight;

import java.util.ArrayList;
import java.util.List;

public class MinimumHopsStrategy implements RouteStrategy {

    @Override
    public String getStrategyName() {
        return "Minimum Hops Route";
    }

    @Override
    public List<Flight> findRoute(String sourceCity, String destinationCity, List<Flight> flights) {
        List<Flight> minimumHopsRoute = new ArrayList<>();
        int minHops = Integer.MAX_VALUE;

        System.out.println("Finding Minimum hops Flight between " + sourceCity + " destinationCity " + destinationCity);

        for(int i=0;i<flights.size();i++) {
            System.out.println("Flights available " + flights.get(i).toString());
        }


        findMinimumHopsRoute(sourceCity, destinationCity, flights, new ArrayList<>(), 0, minHops, minimumHopsRoute);
        return minimumHopsRoute;
    }

    private void findMinimumHopsRoute(String currentCity, String destinationCity, List<Flight> flights,
                                      List<Flight> currentRoute, int currentHops, int minHops, List<Flight> minimumHopsRoute) {
        if (currentCity.equals(destinationCity)) {
            if (currentHops < minHops) {
                minHops = currentHops;
                minimumHopsRoute.clear();
                minimumHopsRoute.addAll(currentRoute);
            }
            return;
        }

        for (Flight flight : flights) {
            if (flight.getSourceCity().equals(currentCity) && !currentRoute.contains(flight)) {
                currentRoute.add(flight);
                findMinimumHopsRoute(flight.getDestinationCity().toString(), destinationCity, flights, currentRoute, currentHops + 1, minHops, minimumHopsRoute);
                currentRoute.remove(flight);
            }
        }
    }
}
