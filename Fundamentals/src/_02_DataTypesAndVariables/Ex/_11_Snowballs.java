package _02_DataTypesAndVariables.Ex;

import java.util.Scanner;

public class _11_Snowballs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        double maxValue = Double.MIN_VALUE;
        double snowballValue = 0;
        int bestSnowballSnow = 0;
        int bestSnowballTime = 0;
        int bastSnowballQuality = 0;

        for (int i = 1; i <= n; i++) {
            int snowballSnow = Integer.parseInt(scan.nextLine());
            int snowballTime = Integer.parseInt(scan.nextLine());
            int snowballQuality = Integer.parseInt(scan.nextLine());

            snowballValue = Math.pow(snowballSnow * 1.0 / snowballTime, snowballQuality);
            if (snowballValue > maxValue) {
                maxValue = snowballValue;
                bestSnowballSnow = snowballSnow;
                bestSnowballTime = snowballTime;
                bastSnowballQuality = snowballQuality;
            }
        }
        System.out.printf("%d : %d = %.0f (%d)",
                bestSnowballSnow, bestSnowballTime, maxValue, bastSnowballQuality);
    }
}
