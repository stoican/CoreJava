package taxiproject.service;

import taxiproject.model.Taxi;

import java.sql.SQLOutput;
import java.util.Scanner;

public class TaxiService {
    public Taxi create() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter taxi model: ");
        String model = s.next();
        System.out.println("Enter country the car belongs to: ");
        String country = s.next();
        System.out.println("Enter manufacturing year: ");
        int year = s.nextInt();
        System.out.println("Enter millage: ");
        int millage = s.nextInt();
        System.out.println("Enter weight: ");
        int weight = s.nextInt();
        System.out.println("Enter max speed: ");
        int maxSpeed = s.nextInt();
        System.out.println("Is a sport car? y/n");
        boolean isSport = s.next().charAt(0) == 'y';
        System.out.println("Enter number of seats: ");
        int seats = s.nextInt();
        System.out.println("Enter cost of the car: ");
        double cost = s.nextDouble();
        Taxi t = new Taxi(model, country, year);
        t.setMileage(millage);
        t.setWeight(weight);
        t.setTopSpeed(maxSpeed);
        t.setSport(isSport);
        t.setSeats(seats);
        t.setCost(cost);

        return t;
    }

    public void printTopSpeedAndCost(Taxi taxi) {
        System.out.println(taxi.isSport() ?
                "Cost: " + taxi.getCost() + ", MaxSpeed: " + taxi.getTopSpeed() :
                "Model: "+ taxi.getModel() + ", Country: " + taxi.getCountry());
    }

    public Taxi getNewerTaxi(Taxi t1, Taxi t2) {
        return t1.getYear() >= t2.getYear() ? t1 : t2;
    }

    public void printCountryOfTaxiWithSmallestSeatCount(Taxi t1, Taxi t2, Taxi t3) {
        Taxi smaller = t1.getSeats() <= t2.getSeats() ? t1 : t2;
        System.out.println(t3.getSeats() < smaller.getSeats() ? t3.getCountry() : smaller.getCountry());
    }

    public void printNonSportTaxis(Taxi[] taxis) {
        for (Taxi taxi : taxis) {
            if (!taxi.isSport()) {
                taxi.printTaxi();
            }
        }
    }

    public void printSportCarsWithMoreThan50000 (Taxi[] taxis) {
        for (Taxi taxi : taxis) {
            if (taxi.isSport() && taxi.getMileage() > 50000)
                taxi.printTaxi();
        }
    }

    public Taxi getTaxiWithMinWeight(Taxi[] taxis) {
        Taxi minWeight = taxis[0];
        for (int i = 1; i < taxis.length; i++) {
            if (taxis[i].getWeight() <= minWeight.getWeight()) {
                minWeight = taxis[i];
            }
        }

        return minWeight;
    }

    public Taxi getSportTaxiWithMinimalCost(Taxi[] taxis) {
        Taxi minCost = null;
        int i = 0;
        for (; i < taxis.length; i++) {
            if (taxis[i].isSport()) {
                minCost = taxis[i];
                break;
            }
        }

        for (; i < taxis.length; i++) {
            if (taxis[i].isSport() && taxis[i].getCost() < minCost.getCost()) {
                minCost = taxis[i];
            }
        }

        return minCost;
    }

    public void printTaxisInAscendingOrderByYear(Taxi[] taxis) {
        for (int stage = 0; stage < taxis.length - 2; stage++) {
            boolean swapped = false;
            for (int i = 0; i < taxis.length - stage - 1; i++) {
                if (taxis[i].getYear() > taxis[i + 1].getYear()) {
                    Taxi tmp = taxis[i + 1];
                    taxis[i + 1] = taxis[i];
                    taxis[i] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        // print
        for (Taxi taxi : taxis) {
            taxi.printTaxi();
        }
    }
}
