package com.cleartrip.controllers;

import com.cleartrip.models.Airline;
import com.cleartrip.services.AdminService;

public class AdminController {

    private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    public void registerAirline(String airline) {
        adminService.registerAirline(airline);
    }

    public void addFlight(String airlineName, String source, String destination, int price, boolean hasMeals) {
        adminService.addFlight(airlineName, source, destination, price, hasMeals);
    }
}
