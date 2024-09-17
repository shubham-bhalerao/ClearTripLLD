package com.cleartrip.strategies;

import com.cleartrip.models.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class MealsFilter implements Filter {
    private boolean requireMeals;

    public MealsFilter(boolean requireMeals) {
        this.requireMeals = requireMeals;
    }

    @Override
    public String getStrategyName() {
        return "Meals Filter Strategy";
    }

    @Override
    public List<Flight> apply(List<Flight> flights) {
        if (!requireMeals) return flights;
        return flights.stream()
                .filter(Flight::hasMeals)
                .collect(Collectors.toList());
    }
}
