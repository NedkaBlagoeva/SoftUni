package ConditionalStatements_Exercise;

import java.util.Scanner;

public class SpeedInfo_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double speed = Double.parseDouble(scan.nextLine());
        if (speed <= 10) {
            System.out.println("slow");
        } else if (speed <= 50) {
            System.out.println("average");
        } else if (speed <= 150) {
            System.out.println("fast");
        } else if (speed <= 1000) {
            System.out.println("ultra fast");
        } else {
            System.out.println("extremely fast");
        }

    }
}
