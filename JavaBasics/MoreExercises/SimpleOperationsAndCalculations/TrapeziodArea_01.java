package MoreExercises.SimpleOperationsAndCalculations;

import java.util.Scanner;

public class TrapeziodArea_01 {

    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	double b1 = Double.parseDouble(scan.nextLine());
	double b2 = Double.parseDouble(scan.nextLine());
	double h1 = Double.parseDouble(scan.nextLine());

	double area = (b1+b2)*h1/2;
        System.out.printf("%.2f", area);


    }
}
