package Methods_Lab;

import java.util.Scanner;

public class _02_Grades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double grade = Double.parseDouble(scan.nextLine());
        gradeInWords(grade);
    }

    private static void gradeInWords(double grade) {
        if (grade >= 2 && grade <= 2.99) {
            System.out.println("Fail");
        } else if (grade >= 3 && grade <= 3.49) {
            System.out.println("Poor");
        } else if (grade >= 3.50 && grade <= 4.49) {
            System.out.println("Good");
        } else if (grade >= 4.5 && grade <= 5.49) {
            System.out.println("Very good");
        } else if (grade >= 5.5 && grade <= 6) {
            System.out.println("Excellent");
        }
    }
}
