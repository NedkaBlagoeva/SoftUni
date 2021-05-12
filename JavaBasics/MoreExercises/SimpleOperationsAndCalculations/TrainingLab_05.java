package MoreExercises.SimpleOperationsAndCalculations;

import java.util.Scanner;

public class TrainingLab_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double hHall = Double.parseDouble(scan.nextLine()) * 100;
        double wHall = Double.parseDouble(scan.nextLine()) * 100 - 100;

        int rows = (int) (hHall / 120);
        int column = (int) (wHall / 70);
        double places = rows * column - 3;

        System.out.println(places);


    }
}
