package Exam28_29March2020;

import java.util.Scanner;

public class ChangeBureau_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int bitcoins = Integer.parseInt(scan.nextLine());
        double yuan = Double.parseDouble(scan.nextLine());
        double commission = Double.parseDouble(scan.nextLine())/100;
        double bgn = 0.0;
        double euro = 0.0;
        double endSum = 0.0;
//•1 биткойн = 1168 лева.
//•1 китайски юан = 0.15 долара.
//•1 долар = 1.76 лева.
//•1 евро = 1.95 лева.

            bgn = bitcoins*1168 + (yuan*0.15)*1.76;
            euro = (bgn/1.95);
            endSum = euro - euro*commission;
        System.out.printf("%.2f",endSum);

    }
}
