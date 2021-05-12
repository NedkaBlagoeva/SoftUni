package MoreExercises.ConditionalStatements;

import java.util.Scanner;

public class SleepyTomCat_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int restDays = Integer.parseInt(scan.nextLine());
        double restDaysPlay = restDays * 127;
        double workDays = 365 - restDays;
        double workDayPlay = workDays * 63;
        double allPlayMinutes = workDayPlay + restDaysPlay;
        double diff = Math.abs(allPlayMinutes - 30000);
        double hours = Math.floor(diff / 60);
        double minutes = Math.floor(diff % 60);

        if (allPlayMinutes < 30000) {
            System.out.println("Tom sleeps well");
            System.out.printf("%.0f hours and %.0f minutes less for play", hours, minutes);

        } else {
            System.out.println("Tom will run away");
            System.out.printf("%.0f hours and %.0f minutes more for play", hours, minutes);
        }


    }
}
