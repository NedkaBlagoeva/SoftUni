package _02_DataTypesAndVariables.Ex;

import java.util.Scanner;

public class _08_BeerKegs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        double maxVolume = Double.MIN_VALUE;
        double volume = 0;
        String biggestKegModel = "";

        for (int i = 1; i <= n; i++) {
            String model = scan.nextLine();
            float radius = Float.parseFloat(scan.nextLine());
            int height = Integer.parseInt(scan.nextLine());

            volume = Math.PI * radius * radius * height;
            if (volume >= maxVolume) {
                maxVolume = volume;
                biggestKegModel = model;
            }
        }
        System.out.printf("%s", biggestKegModel);
    }
}
