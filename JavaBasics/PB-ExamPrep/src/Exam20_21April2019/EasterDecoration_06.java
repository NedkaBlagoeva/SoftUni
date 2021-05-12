package Exam20_21April2019;

import java.util.Scanner;

public class EasterDecoration_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int costumers = Integer.parseInt(scan.nextLine());
        int basketCount = 0;
        int wreathCount = 0;
        int bunnyCount = 0;
        double billPerCustomer = 0;
        int countAll = 0;
        double spendMoneyByAllCostumers = 0;
        int countProductsPerCustomer = 0;

        for (int i = 1; i <= costumers; i++) {
            String product = scan.nextLine();
            while (!"Finish".equals(product)) {
                countAll++;
                countProductsPerCustomer++;
                switch (product) {
                    case "basket":
                        basketCount++;
                        break;
                    case "wreath":
                        wreathCount++;
                        break;
                    case "chocolate bunny":
                        bunnyCount++;
                        break;
                }
                product = scan.nextLine();
            }

            billPerCustomer = basketCount * 1.50 + wreathCount * 3.80 + bunnyCount * 7.00;
            if (countProductsPerCustomer % 2 == 0) {
                billPerCustomer *= 0.80;
            }
            spendMoneyByAllCostumers += billPerCustomer;
            System.out.printf("You purchased %d items for %.2f leva.\n", countProductsPerCustomer, billPerCustomer);
            billPerCustomer = 0;
            countProductsPerCustomer = 0;
            basketCount = 0;
            wreathCount = 0;
            bunnyCount = 0;
        }
        System.out.printf("Average bill per client is: %.2f leva.", spendMoneyByAllCostumers / costumers);
    }
}
