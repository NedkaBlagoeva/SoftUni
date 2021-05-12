package MoreExercises.SimpleOperationsAndCalculations;

import java.util.Scanner;

public class VegetableMarket_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double vegetablesPrice = Double.parseDouble(scan.nextLine());
        double fruitsPrice = Double.parseDouble(scan.nextLine());
        int kgVegetables = Integer.parseInt(scan.nextLine());
        int kgFruits = Integer.parseInt(scan.nextLine());

        double totalSumInEU = (vegetablesPrice*kgVegetables + fruitsPrice*kgFruits)/1.94;
        System.out.printf("%.2f", totalSumInEU);

    }
}
