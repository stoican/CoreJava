package taxiproject;

import taxiproject.model.Taxi;
import taxiproject.service.TaxiService;

import java.util.Scanner;

public class TaxiTest {
    public static void main(String[] args) {
        TaxiService taxiService = new TaxiService();
        System.out.println("Creating Taxis: ");
        Taxi taxi1 = taxiService.create();
        Taxi taxi2 = taxiService.create();
        Taxi taxi3 = taxiService.create();
        Taxi taxi4 = taxiService.create();
        System.out.println("DB of Taxis is successfully created!\n");

        Scanner s = new Scanner(System.in);
        boolean isActive = true;
        while (isActive) {
            System.out.println("\n1. Print cost and topSpeed if the taxi is sport otherwise print model and country");
            System.out.println("2. Determine which car is newer out of 2");
            System.out.println("3. Print Taxi With Smallest Seat Count (3 Params)");
            System.out.println("4. Print Non-Sport Taxis");
            System.out.println("5. Print Sport Taxis with > 50000 km mileage");
            System.out.println("6. Print the taxi with minimal weight (last one)");
            System.out.println("7. Print the sport taxi with minimal cost (first one)");
            System.out.println("8. Print Taxis in Ascending Order by Year");
            System.out.println("9. Exit");
            int ch = s.nextInt();

            switch (ch) {
                case 1:
                    taxiService.printTopSpeedAndCost(taxi1);
                    break;
                case 2:
                    Taxi n = taxiService.getNewerTaxi(taxi1, taxi2);
                    n.printTaxi();
                    break;
                case 3:
                    taxiService.printCountryOfTaxiWithSmallestSeatCount(taxi1, taxi2, taxi3);
                    break;
                case 4:
                    taxiService.printNonSportTaxis(new Taxi[]{taxi1, taxi2, taxi3, taxi4});
                    break;
                case 5:
                    taxiService.printSportCarsWithMoreThan50000(new Taxi[]{taxi1, taxi2, taxi3, taxi4});
                    break;
                case 6:
                    Taxi minW = taxiService.getTaxiWithMinWeight(new Taxi[]{taxi1, taxi2, taxi3, taxi4});
                    System.out.println("Min Weight Taxi: ");
                    minW.printTaxi();
                    break;
                case 7:
                    Taxi minC = taxiService.getTaxiWithMinWeight(new Taxi[]{taxi1, taxi2, taxi3, taxi4});
                    System.out.println("Min Cost Taxi: ");
                    minC.printTaxi();
                    break;
                case 8:
                    taxiService.printTaxisInAscendingOrderByYear(new Taxi[]{taxi1, taxi2, taxi3, taxi4});
                    break;
                case 9:
                    isActive = false;
                    System.out.println("FINISH");
                    break;
                default:
                    System.out.println("Please enter valid number");

            }

        }

    }
}
