package ConditionalStatements_Exercise;

import java.util.Scanner;

public class MetricConverter_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double num = Double.parseDouble(scan.nextLine());
        String input = scan.nextLine();
        String output = scan.nextLine();
        double inMeters = 0;

        switch (input) {
            case "cm":
                num /= 100;
                break;
            case "mm":
                num /=1000;
                break;
        }switch (output){
            case "cm":
                num *=100;
                break;
            case "mm":
                num*=1000;
                break;

        }System.out.printf("%.3f",num);


    }
}
