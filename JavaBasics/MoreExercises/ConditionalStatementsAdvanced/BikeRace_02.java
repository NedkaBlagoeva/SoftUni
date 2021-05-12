package MoreExercises.ConditionalStatementsAdvanced;

import java.util.Scanner;

public class BikeRace_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int juniors = Integer.parseInt(scan.nextLine());
        int seniors = Integer.parseInt(scan.nextLine());
        String trace = scan.nextLine();
        double priceJ = 0.0;
        double priceS = 0.0;
        double finalSum = 0.0;
        //        Група	    trail	cross-country	downhill	road
//        juniors	5.50	8	            12.25	    20
//        seniors	7	    9.50	        13.75	    21.50
        switch (trace) {
            case "trail":
                priceJ = 5.5;
                priceS = 7;
                break;
            case "cross-country":
                priceJ = 8.0;
                priceS = 9.50;
                if (seniors + juniors >= 50) {
                    priceJ *= 0.75;
                    priceS *= 0.75;
                }
                break;
            case "downhill":
                priceJ = 12.25;
                priceS = 13.75;
                break;
            case "road":
                priceJ = 20.0;
                priceS = 21.50;
                break;
        }
        finalSum = priceJ * juniors + priceS * seniors;
        finalSum *= 0.95;
        System.out.printf("%.2f", finalSum);

    }
}
