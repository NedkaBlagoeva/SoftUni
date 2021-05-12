package ConditionalStatementsAdvanced_Exercise;

import java.util.Scanner;

public class HotelRoom_07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String month = scan.nextLine();
        int day = Integer.parseInt(scan.nextLine());
        int nights = day-1;
        double apPrice = 0.0;
        double stPrice = 0.0;

        switch (month) {
            case "May":
            case "October":
                stPrice = 50.0;
                apPrice = 65.0;
                if (nights >= 7 && nights <14) {
                    stPrice *= 0.95;
                } else if (nights >= 14) {
                    stPrice *= 0.70;
                    apPrice *= 0.90;
                }
                break;
            case "June":
            case "September":
                stPrice = 75.2;
                apPrice = 68.7;
                if (nights >= 14) {
                    stPrice *= 0.80;
                    apPrice *= 0.90;
                }
                break;
            case "July":
            case "August":
                stPrice = 76.0;
                apPrice = 77.0;
                if (nights >= 14) {
                    apPrice *= 0.90;
                }
                break;
        }
        System.out.printf("Apartment: %.2f lv.%nStudio: %.2f lv.",apPrice*day, stPrice*day);
    }
}
