package Exam20_21February2021;

import java.util.Scanner;

public class GoldMine_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int locations = Integer.parseInt(scan.nextLine());
        double averageGoldPerLocation = 0.0;

        for (int i = 1; i <= locations ; i++) {
            double expectedProduce = Double.parseDouble(scan.nextLine());
            int days = Integer.parseInt(scan.nextLine());
            for (int j = 1; j <= days ; j++) {
                double goldPerDay = Double.parseDouble(scan.nextLine());
                averageGoldPerLocation += goldPerDay;
            }
            averageGoldPerLocation /= days;
            if (averageGoldPerLocation >= expectedProduce){
                System.out.printf("Good job! Average gold per day: %.2f.\n", averageGoldPerLocation);
            }else{
                System.out.printf("You need %.2f gold.\n", expectedProduce - averageGoldPerLocation);
            }
            averageGoldPerLocation = 0.0;
        }
    }
}
