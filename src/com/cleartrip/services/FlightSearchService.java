package com.cleartrip.services;

import com.cleartrip.models.Flight;
import com.cleartrip.repositories.FlightRepository;
import com.cleartrip.strategies.RouteStrategy;

import java.util.List;

public class FlightSearchService {

    private FlightRepository flightRepository;
    private List<RouteStrategy> strategies;
    private FilterService filterService;

    public FlightSearchService(FlightRepository flightRepository, List<RouteStrategy> strategies, FilterService filterService) {
        this.flightRepository = flightRepository;
        this.strategies = strategies;
        this.filterService = filterService;
    }

    public List<Flight> searchFlights(String sourceCity, String destinationCity, RouteStrategy strategy) {
        List<Flight> filteredFlights = filterService.applyFilters(flightRepository.getFlights());
        return strategy.findRoute(sourceCity, destinationCity,filteredFlights);
    }

    public List<RouteStrategy> getRouteStrategies() {
        return strategies;
    }

    private void printFlights(List<Flight> flights) {
        for (Flight flight : flights) {
            System.out.println(flight.getSourceCity() + " to " +
                    flight.getDestinationCity() + " via " +
                    flight.getAirline().getName() + " for " +
                    flight.getPrice());
        }
    }
}
