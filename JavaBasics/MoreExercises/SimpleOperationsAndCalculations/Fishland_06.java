package MoreExercises.SimpleOperationsAndCalculations;

import java.util.Scanner;

public class Fishland_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double priceScumria = Double.parseDouble(scan.nextLine());
        double priceCaca = Double.parseDouble(scan.nextLine());
        double palamudKg = Double.parseDouble(scan.nextLine());
        double safridKg = Double.parseDouble(scan.nextLine());
        int midiKg = Integer.parseInt(scan.nextLine());

        double pricePalamud = priceScumria + priceScumria * 0.6;
        double priceSafrid = priceCaca + priceCaca * 0.8;
        double priceMidi = 7.50;

        // паламуд, сафрид и миди

        double totalBill = pricePalamud * palamudKg + priceSafrid * safridKg + priceMidi * midiKg;
        System.out.printf("%.2f", totalBill);


    }
}
