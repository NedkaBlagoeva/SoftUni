package _07_MidExam._05_FundamentalsMidExam;

import java.util.Scanner;

public class _01_BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int studentCount = Integer.parseInt(scan.nextLine());
        int lecturesCount = Integer.parseInt(scan.nextLine());
        int bonus = Integer.parseInt(scan.nextLine());
        double maxBonus = 0;
        int maxLectures = 0;

        for (int i = 0; i < studentCount; i++) {
            int attendances = Integer.parseInt(scan.nextLine());
            double totalBonus = attendances * 1.0 / lecturesCount * (5 + bonus);
            if (totalBonus > maxBonus) {
                maxBonus = totalBonus;
                maxLectures = attendances;
            }
        }
        System.out.printf("Max Bonus: %.0f.%n", Math.ceil(maxBonus));
        System.out.printf("The student has attended %d lectures.", maxLectures);
    }
}
