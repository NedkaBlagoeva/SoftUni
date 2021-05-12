package MoreExercises.ForLoop;

import java.util.Scanner;

public class Logistics_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int cargoCount = Integer.parseInt(scan.nextLine());
        int all = 0;
        int withBus = 0;
        int withTruck = 0;
        int withTrain = 0;
        int price = 0;

        for (int i = 1; i <= cargoCount; i++) {
            int cargoWeigh = Integer.parseInt(scan.nextLine());
            // all += cargoWeigh;
            if (cargoWeigh <= 3) {
                withBus += cargoWeigh;
            } else if (cargoWeigh <= 11) {
                withTruck += cargoWeigh;
            } else {
                withTrain += cargoWeigh;
            }
        }
        price = withBus * 200 + withTruck * 175 + withTrain * 120;
        all = withBus + withTruck + withTrain;
        System.out.printf("%.2f\n", price * 1.0 / all);
        System.out.printf("%.2f%%\n", withBus * 1.0 / all * 100);
        System.out.printf("%.2f%%\n", withTruck * 1.0 / all * 100);
        System.out.printf("%.2f%%", withTrain * 1.0 / all * 100);
    }
}
