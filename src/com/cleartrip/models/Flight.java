package com.cleartrip.models;

public class Flight {
    private Airline airline;
    private City sourceCity;
    private City destinationCity;
    private int price;
    private boolean hasMeals;

    public Flight(Airline airline, City sourceCity, City destinationCity, int price, boolean hasMeals) {
        this.airline = airline;
        this.sourceCity = sourceCity;
        this.destinationCity = destinationCity;
        this.price = price;
        this.hasMeals = hasMeals;
    }

    public Airline getAirline() {
        return airline;
    }

    public String getSourceCity() {
        return sourceCity.getCode();
    }

    public String getDestinationCity() {
        return destinationCity.getCode();
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "airline=" + airline.getName() +
                ", sourceCity=" + sourceCity +
                ", destinationCity=" + destinationCity +
                ", price=" + price +
                ", hasMeals=" + hasMeals +
                '}';
    }

    public boolean hasMeals() {
        return hasMeals;
    }
}