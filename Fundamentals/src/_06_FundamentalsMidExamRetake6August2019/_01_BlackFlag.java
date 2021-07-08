package _06_FundamentalsMidExamRetake6August2019;

import java.util.Scanner;

public class _01_BlackFlag {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int days = Integer.parseInt(scan.nextLine());
        int plunderForDay = Integer.parseInt(scan.nextLine());
        double expectedPlunder = Double.parseDouble(scan.nextLine());
        double collectedPlunder = 0;
        for (int i = 1; i <= days; i++) {
            collectedPlunder += plunderForDay;
            if (i % 3 == 0) {
                collectedPlunder += plunderForDay / 2.0;
            } else if (i % 5 == 0) {
                collectedPlunder *= 0.7;
            }
        }
        if (collectedPlunder >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.", collectedPlunder);
        } else {
            System.out.printf("Collected only %.2f%% of the plunder.", collectedPlunder / expectedPlunder * 100);
        }
    }
}
