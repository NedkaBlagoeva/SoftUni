package MoreExercises.ConditionalStatementsAdvanced;

import java.util.Scanner;

public class MultiplyBy2_10_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double num =Double.parseDouble(scan.nextLine());;
        while (num>=0){
            System.out.printf("%.2f%n",2*num);
            num = Double.parseDouble(scan.nextLine());
        }
        System.out.println("Negative number!");
    }
}
