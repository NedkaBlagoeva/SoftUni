package Exam28_29March2020;

import java.util.Scanner;

public class SuitcasesLoad_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double plainVolume = Double.parseDouble(scan.nextLine());
        String input = scan.nextLine();
        int count = 0;
        int count2 = 0;
        boolean noMoreSpace = false;

        while (!"End".equals(input)) {
            double suitcaseV = Double.parseDouble(input);
            count2++;
            if (count2 % 3 == 0) {
                suitcaseV *= 1.1;
            }
            if (plainVolume >= suitcaseV) {
                plainVolume -= suitcaseV;
                count++;
            } else {
                noMoreSpace = true;
                break;
            }

            input = scan.nextLine();
        }
        if (noMoreSpace) {
            System.out.println("No more space!");
        } else {
            System.out.println("Congratulations! All suitcases are loaded!");
        }
        System.out.printf("Statistic: %d suitcases loaded.", count);
    }
}
