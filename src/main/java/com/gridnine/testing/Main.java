package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FilterFlight filter = new FilterFlight();
        List<Flight> list = FlightBuilder.createFlights();
        //System.out.println(list);
        filter.earthFilter(list);



    }
}