package NestedLoops_Lab;

import java.util.Scanner;

public class Travelling_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String destination = scan.nextLine();

        while (!destination.equals("End")){
            double budget = Double.parseDouble(scan.nextLine());
            double sum = 0.0;
            while (true){
                double amount = Double.parseDouble(scan.nextLine());
                sum += amount;
                if (sum >= budget){
                    System.out.printf("Going to %s!\n", destination);
                    break;
                }
            }
            destination = scan.nextLine();
        }
    }
}
