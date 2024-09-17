package com.cleartrip.strategies;

import com.cleartrip.models.Flight;

import java.util.List;

public interface RouteStrategy {
    String getStrategyName();
    List<Flight> findRoute(String source, String destination, List<Flight> allFlights);
}
