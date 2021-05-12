package MoreExercises.ConditionalStatementsAdvanced;

import java.util.Scanner;

public class PointOnRectangleBorder_08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double x1 = Double.parseDouble(scan.nextLine());
        double y1 = Double.parseDouble(scan.nextLine());
        double x2 = Double.parseDouble(scan.nextLine());
        double y2 = Double.parseDouble(scan.nextLine());
        double x = Double.parseDouble(scan.nextLine());
        double y = Double.parseDouble(scan.nextLine());
        boolean one = (y == y1 || y == y2) && (x >= x1 && x <= x2);
        boolean two = (x == x1 || x == x2) && (y >= y1 && y <= y2);

        if (one || two) {
            System.out.println("Border");
        } else  {
            System.out.println("Inside / Outside");

        }
    }
}