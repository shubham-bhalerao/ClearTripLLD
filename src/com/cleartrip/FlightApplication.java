package com.cleartrip;

import com.cleartrip.controllers.AdminController;
import com.cleartrip.controllers.FlightSearchController;
import com.cleartrip.repositories.AirlineRepository;
import com.cleartrip.repositories.FlightRepository;
import com.cleartrip.services.AdminService;
import com.cleartrip.services.FilterService;
import com.cleartrip.services.FlightSearchService;
import com.cleartrip.strategies.*;

import java.util.ArrayList;
import java.util.List;

public class FlightApplication {
    public static void main(String[] args) {

        AirlineRepository airlineRepository = new AirlineRepository();
        FlightRepository flightRepository = new FlightRepository();

        AdminService adminService = new AdminService(airlineRepository, flightRepository);
        List<RouteStrategy> strategies = new ArrayList<>();
        strategies.add(new CheapestRouteStrategy());
        strategies.add(new MinimumHopsStrategy());


        FilterService filterService = new FilterService();
        filterService.addFilter(new MealsFilter(true));

        FlightSearchService flightSearchService = new FlightSearchService(flightRepository, strategies, filterService);

        AdminController adminController = new AdminController(adminService);
        FlightSearchController flightSearchController = new FlightSearchController(flightSearchService);

        adminController.registerAirline("IndiGo");
        adminController.registerAirline("Air India");
        adminController.registerAirline("JetAir");
        adminController.registerAirline("Delta");


//        adminController.addFlight("IndiGo", "DEL", "MUM", 5000, true);
//        adminController.addFlight("IndiGo", "DEL", "BLR", 6000, false);
//        adminController.addFlight("Air India", "DEL", "BLR", 7000, true);
//        adminController.addFlight("Air India", "DEL", "MUM", 5500, true);
//        adminController.addFlight("JetAir", "DEL", "LON", 8000, true);
//        adminController.addFlight("JetAir", "BLR", "LON", 4000, false);
//        adminController.addFlight("JetAir", "LON", "NYC", 10000, true);

        adminController.addFlight("JetAir", "DEL", "BLR", 500, true);
        adminController.addFlight("JetAir", "BLR", "LON", 1000, true);
        adminController.addFlight("Delta", "DEL", "LON", 2000, true);
        adminController.addFlight("Delta", "LON", "NYC", 2000, true);
        adminController.addFlight("IndiGo", "LON", "NYC", 2500, true);
        adminController.addFlight("IndiGo", "DEL", "BLR", 600, true);
        adminController.addFlight("IndiGo", "BLR", "PAR", 800, true);
        adminController.addFlight("IndiGo", "PAR", "LDN", 2500, true);











        System.out.println("Search for flights from DEL to NYC:");
        flightSearchController.searchFlights("DEL", "NYC");

        System.out.println("Search for flights from DEL to NYC:");

        flightSearchController.searchFlights("DEL", "NYC");

        System.out.println("Search for flights from BLR to LON:");
        flightSearchController.searchFlights("BLR", "LON");
    }
}
