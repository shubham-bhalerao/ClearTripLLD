package com.cleartrip.controllers;

import com.cleartrip.models.City;
import com.cleartrip.models.Flight;
import com.cleartrip.services.FlightSearchService;
import com.cleartrip.strategies.RouteStrategy;

import java.util.List;

public class FlightSearchController {

    private FlightSearchService flightSearchService;

    public FlightSearchController(FlightSearchService flightSearchService) {
        this.flightSearchService = flightSearchService;
    }

    public void searchFlights(String sourceCity, String destinationCity) {
        for (RouteStrategy strategy : flightSearchService.getRouteStrategies()) {
            System.out.println("Searching with strategy: " + strategy.getClass().getSimpleName());
            List<Flight> flights = flightSearchService.searchFlights(sourceCity, destinationCity, strategy);

            if (flights.isEmpty()) {
                System.out.println("No flights found with strategy: " + strategy.getClass().getSimpleName());
            } else {
                for (Flight flight : flights) {
                    System.out.println(flight);
                }
            }
            System.out.println();
        }
    }
}
