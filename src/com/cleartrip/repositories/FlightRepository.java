package com.cleartrip.repositories;

import com.cleartrip.models.City;
import com.cleartrip.models.Flight;

import java.util.ArrayList;
import java.util.List;

public class FlightRepository {
    private List<Flight> flights = new ArrayList<>();

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public List<Flight> findBySourceAndDestination(City source, City destination) {
        List<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getSourceCity().equals(source) && flight.getDestinationCity().equals(destination)) {
                result.add(flight);
            }
        }
        return result;
    }
}
