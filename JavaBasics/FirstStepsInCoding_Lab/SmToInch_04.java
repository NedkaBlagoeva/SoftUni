package FirstStepsInCoding_Lab;

import java.util.Scanner;

public class SmToInch_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        double inch = Double.parseDouble(scan.nextLine());
        double sm = inch*2.54;
        System.out.print(sm);
    }
}
