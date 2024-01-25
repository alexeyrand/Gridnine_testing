package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;

public class FilterFlight {
    public List<Flight> earthFilter(List<Flight> flights) {
        int i = 1;
        for (Flight f : flights) {
            System.out.println("Flight: " + i++);
            for (Segment s : f.getSegments()) {
                System.out.println(s);
                int dateStart = s.getDepartureDate().getHour();
                int dateEnd = s.getArrivalDate().getHour();
                int timeInAir = dateEnd - dateStart;
                if (timeInAir < 0) {
                    timeInAir = 24 + timeInAir;
                }
                System.out.println(timeInAir);

            }
        }
        return null;
    }
}
