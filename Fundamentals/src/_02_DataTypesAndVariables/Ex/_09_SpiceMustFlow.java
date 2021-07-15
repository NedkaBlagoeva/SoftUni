package _02_DataTypesAndVariables.Ex;

import java.util.Scanner;

public class _09_SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int startingYield = Integer.parseInt(scan.nextLine());
        int days = 0;
        int yield = 0;

        while (startingYield >= 100) {
            days++;
            yield += startingYield - 26;
            startingYield -= 10;
        }
        System.out.println(days);
        if (days == 0){
        System.out.println(yield );
        }else {
        System.out.println(yield - 26);
        }
    }
}
