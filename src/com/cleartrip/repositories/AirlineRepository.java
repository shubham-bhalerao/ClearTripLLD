package com.cleartrip.repositories;

import com.cleartrip.models.Airline;

import java.util.ArrayList;
import java.util.List;

public class AirlineRepository {

    private List<Airline> airlines = new ArrayList<>();

    public void addAirline(Airline airline) {
        airlines.add(airline);
    }

    public List<Airline> getAirlines() {
        return airlines;
    }

    public Airline findByName(String name) {
        return airlines.stream()
                .filter(airline -> airline.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
