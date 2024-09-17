package com.cleartrip.services;

import com.cleartrip.models.Flight;
import com.cleartrip.strategies.Filter;

import java.util.ArrayList;
import java.util.List;

public class FilterService {

    private List<Filter> filters;

    public FilterService() {
        this.filters = new ArrayList<>();
    }

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    public List<Flight> applyFilters(List<Flight> flights) {
        for (Filter filter : filters) {
            flights = filter.apply(flights);
        }
        return flights;
    }
}
