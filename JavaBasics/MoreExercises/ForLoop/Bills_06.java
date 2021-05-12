package MoreExercises.ForLoop;

import java.util.Scanner;

public class Bills_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
       int months = Integer.parseInt(scan.nextLine());
       double water = 20;
       double internet = 15;
       double billsPerMonth = 0;
       double monthWater = months * water;
       double monthInternet = months * internet;
       double monthElectricity = 0;
       double monthOthers = 0;
       double allBills = 0;

        for (int i = 1; i <= months; i++) {
            double electricity = Double.parseDouble(scan.nextLine());
            double others = (electricity + water + internet) * 1.20;
            billsPerMonth = electricity + water + internet + others;
            monthElectricity +=electricity;
            monthOthers += others;
            allBills += billsPerMonth;
        }
        System.out.printf("Electricity: %.2f lv\n", monthElectricity);
        System.out.printf("Water: %.2f lv\n", monthWater);
        System.out.printf("Internet: %.2f lv\n", monthInternet);
        System.out.printf("Other: %.2f lv\n", monthOthers);
        System.out.printf("Average: %.2f lv", allBills/months);
    }
}
//        •	1ви ред: "Electricity: {ток за всички месеци} lv"
//        •	2ри ред: "Water: {вода за всички месеци} lv"
//        •	3ти ред: "Internet: {интернет за всички месеци} lv"
//        •	4ти ред: "Other: {други за всички месеци} lv"
//        •	5ти ред: "Average: {средно всички разходи за месец} lv
