package MoreExercises.ForLoop;

import java.util.Scanner;

public class Grades_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int students = Integer.parseInt(scan.nextLine());
        double count2 = 0;
        double count3 = 0;
        double count4 = 0;
        double count5 = 0;
        double allGrades = 0;


        for (int i = 0; i < students; i++) {
            double grade = Double.parseDouble(scan.nextLine());
            allGrades += grade;
            if (grade <= 2.99) {
                count2++;
            } else if (grade <= 3.99) {
                count3++;
            } else if (grade <= 4.99) {
                count4++;
            } else {
                count5++;
            }
        }
        System.out.printf("Top students: %.2f%%\n", count5 /students*100);
        System.out.printf("Between 4.00 and 4.99: %.2f%%\n", count4 /students*100);
        System.out.printf("Between 3.00 and 3.99: %.2f%%\n", count3 /students*100);
        System.out.printf("Fail: %.2f%%\n", count2 /students*100);
        System.out.printf("Average: %.2f", allGrades /students);
    }
}
