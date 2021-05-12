package ConditionalStatementsAdvanced_Lab;

import java.util.Scanner;

public class TradeCommissions_12 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String city = scan.nextLine();
        double sales = Double.parseDouble(scan.nextLine());
        double commissionPercent = 0.0;
        double commission = 0.0;
//                Град	0 ≤ s ≤ 500	500 < s ≤ 1 000	1 000 < s ≤ 10 000	s > 10 000
//                Sofia	    5%	          7%	            8%	        12%
//                Varna	    4.5%	      7.5%	            10%	        13%
//                Plovdiv	5.5%	      8%	            12%	        14.5%

        switch (city) {
            case "Sofia":
                if (sales < 0) {
                    System.out.println("error");
                } else if (sales >= 0 && sales <= 500) {
                    commissionPercent = 0.05;
                } else if (sales <= 1000) {
                    commissionPercent = 0.07;
                } else if (sales <= 10000) {
                    commissionPercent = 0.08;
                } else {
                    commissionPercent = 0.12;
                }
                break;
            case "Varna":
                if (sales < 0) {
                    System.out.println("error");
                } else if (sales >= 0 && sales <= 500) {
                    commissionPercent = 0.045;
                } else if (sales <= 1000) {
                    commissionPercent = 0.075;
                } else if (sales <= 10000) {
                    commissionPercent = 0.10;
                } else {
                    commissionPercent = 0.13;

                }
                break;
            case "Plovdiv":
                if (sales < 0) {
                    System.out.println("error");
                } else if (sales >= 0 && sales <= 500) {
                    commissionPercent = 0.055;
                } else if (sales <= 1000) {
                    commissionPercent = 0.08;
                } else if (sales <= 10000) {
                    commissionPercent = 0.12;
                } else {
                    commissionPercent = 0.145;
                }
                break;
            default:
                System.out.println("error");
        }
        commission = commissionPercent * sales;
        if (commissionPercent != 0) {

            System.out.printf("%.2f", commission);
        }
    }
}
