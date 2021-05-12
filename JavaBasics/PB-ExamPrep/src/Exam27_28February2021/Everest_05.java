package Exam27_28February2021;

import java.util.Scanner;

public class Everest_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String rest = scan.nextLine();
        int high = 5364;
        boolean goalIsReached = false;
        int days = 1;

        while (!rest.equals("END")) {
            // days++;
            int meters = Integer.parseInt(scan.nextLine());

            if (rest.equals("Yes")) {
                days++;
            }
            if (days > 5) {
                break;
            }
            high += meters;
            if (high >= 8848) {
                goalIsReached = true;
                break;
            }
            rest = scan.nextLine();
        }
        if (goalIsReached) {
            System.out.printf("Goal reached for %d days!", days);
        } else {
            System.out.printf("Failed!\n" +
                    "%d", high);
        }
    }
}
