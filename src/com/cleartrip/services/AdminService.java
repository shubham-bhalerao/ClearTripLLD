package com.cleartrip.services;

import com.cleartrip.models.Airline;
import com.cleartrip.models.City;
import com.cleartrip.models.Flight;
import com.cleartrip.repositories.AirlineRepository;
import com.cleartrip.repositories.FlightRepository;

public class AdminService {
    private AirlineRepository airlineRepository;
    private FlightRepository flightRepository;

    public AdminService(AirlineRepository airlineRepository, FlightRepository flightRepository) {
        this.airlineRepository = airlineRepository;
        this.flightRepository = flightRepository;
    }

    public void registerAirline(String airlineName) {
        Airline airline = new Airline(airlineName);
        airlineRepository.addAirline(airline);
    }

    public void addFlight(String airlineName, String source, String destination, int price, boolean hasMeals) {
        Airline airline = airlineRepository.findByName(airlineName);
        if (airline == null) {
            throw new IllegalArgumentException("Airline not found");
        }
        City sourceCity = new City(source);
        City destinationCity = new City(destination);
        Flight flight = new Flight(airline, sourceCity, destinationCity, price, hasMeals);
        flightRepository.addFlight(flight);
    }
}
