package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FilterFlight filter = new FilterFlight();
        List<Flight> list = FlightBuilder.createFlights();
        System.out.println();

        System.out.println("Перелеты, в которых общее время, проведенное на земле, превышает 2 часа:");
        filter.filterOnGround(list);
        System.out.println();

        System.out.println("Перелеты, в которых вылет до текущего момента времени");
        filter.filterDepartureBefore(list);
        System.out.println();

        System.out.println("Перелеты, в которых имеются сегменты с датой прилета раньше даты вылета");
        filter.filterArrivalBeforeDeparture(list);



    }
}