package DataTypesAndVariables_MoreExercise;

import java.util.Scanner;

public class _03_FloatingEquality {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double num1 = Double.parseDouble(scan.nextLine());
        double num2 = Double.parseDouble(scan.nextLine());

        double diff = Math.abs(num1-num2);
        if (diff > 0.000001){
            System.out.println("False");
        } else {
            System.out.println("True");
        }
    }
}
