package WhileLoop_Exercise;

import java.util.Scanner;

public class Vacation_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double tripMoney = Double.parseDouble(scan.nextLine());
        double currentMoney = Double.parseDouble(scan.nextLine());
        boolean isFailed = false;
        int spendDays = 0;
        int daysCount = 0;
        double sumMoney = currentMoney;
        while (tripMoney > sumMoney) {
            String action = scan.nextLine();
            double amount = Double.parseDouble(scan.nextLine());
            daysCount++;
            switch (action) {
                case "save":
                    sumMoney += amount;
                    spendDays = 0;
                    break;
                case "spend":
                    sumMoney -= amount;

                    if (sumMoney < 0) {
                        sumMoney = 0;
                    }
                    spendDays++;
                    break;
            }
            if (spendDays >= 5) {
                isFailed = true;
                break;
            }

        }
        if (isFailed) {
            System.out.printf("You can't save the money.\n" +
                    "%d", daysCount);
        }else {
            System.out.printf("You saved the money for %d days.", daysCount);
        }
    }
}
