package com.cleartrip.repositories;

import com.cleartrip.models.City;

import java.util.ArrayList;
import java.util.List;

public class CityRepository {

    private List<City> cities = new ArrayList<>();

    public void addCity(City city) {
        cities.add(city);
    }

    public List<City> getCities() {
        return cities;
    }

    public City getCity(String code) {
        return cities.stream()
                .filter(city -> city.getCode().equals(code))
                .findFirst()
                .orElse(null);
    }

}
