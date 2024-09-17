package com.cleartrip.strategies;

import com.cleartrip.models.Flight;

import java.util.List;

public interface Filter {

    String getStrategyName();

    List<Flight> apply(List<Flight> flights);
}
