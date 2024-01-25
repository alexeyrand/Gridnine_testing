package com.gridnine.testing;

import javax.swing.plaf.metal.MetalTabbedPaneUI;
import java.time.LocalDateTime;
import java.util.List;

public class FilterFlight {

    public void filterOnGround(List<Flight> flights) {
        int k = 1;
        for (Flight f : flights) {
            if (f.getSegments().size() > 1) {

                int allTimeOnGround = 0;
                for (int i = 0; i < f.getSegments().size() - 1; i++) {
                    Segment sCurrent = f.getSegments().get(i);
                    Segment sNext = f.getSegments().get(i + 1);

                    LocalDateTime dateStartWait = sCurrent.getArrivalDate();
                    LocalDateTime dateEndWait = sNext.getDepartureDate();

                    String timeOnGround = dateEndWait.minusHours(dateStartWait.getHour()).toString()
                            .split("T")[1].substring(0, 2);
                    allTimeOnGround += Integer.parseInt(timeOnGround);
                }
                if (allTimeOnGround >= 2) {
                    System.out.println("------------------------ Flight " + k + " ---------------------------");
                    System.out.println("Время на земле между перелетами: " + allTimeOnGround + " Часа");
                    System.out.println("Перечень сегментов: " + f);
                    System.out.println("-----------------------------------------------------------");
                    System.out.println();

                }
            }
            k++;
        }

    }


    public void filterArrivalBeforeDeparture(List<Flight> flights) {
        int k = 1;
        for (Flight f : flights) {
            for (int i = 0; i < f.getSegments().size(); i++) {
                Segment s = f.getSegments().get(i);
                LocalDateTime dateDeparture = s.getDepartureDate();
                LocalDateTime dateArrival = s.getArrivalDate();
                if (dateArrival.isBefore(dateDeparture)) {
                    System.out.println("------------------------ Flight " + k + " ---------------------------");
                    System.out.println("Перечень сегментов: " + f);
                    System.out.println("-----------------------------------------------------------");
                }
            }
            k++;
        }
    }


    public void filterDepartureBefore(List<Flight> flights) {
        int k = 1;
        for (Flight f : flights) {

            Segment s = f.getSegments().get(0);
            if (s.getDepartureDate().isBefore(LocalDateTime.now())) {
                System.out.println("------------------------ Flight " + k + " ---------------------------");
                System.out.println("Перечень сегментов: " + f);
                System.out.println("-----------------------------------------------------------");
                System.out.println();
            }
            k++;
        }
    }
}

