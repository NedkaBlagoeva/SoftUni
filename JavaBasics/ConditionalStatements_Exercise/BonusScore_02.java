package ConditionalStatements_Exercise;

import java.util.Scanner;

public class BonusScore_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());

        double bonusPoint = 0.0;
//        •	Ако числото е до 100 включително, бонус точките са 5.
//•	Ако числото е по-голямо от 100, бонус точките са 20% от числото.
//•	Ако числото е по-голямо от 1000, бонус точките са 10% от числото.
        if (num <= 100) {
            bonusPoint += 5;
        } else if (num < 1000) {
            bonusPoint = num * 0.20;

        } else {
            bonusPoint = num * 0.1;
        }
        if (num % 2 == 0) {
            bonusPoint++;

        } else if (num % 10 == 5) {
            bonusPoint += 2;
        }
        System.out.printf("%.1f%n%.1f", bonusPoint, bonusPoint + num);


    }
}
