package WhileLoop_Lab;

import java.util.Scanner;

public class Graduation_pt2_08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        int classCount = 0;
        int excluded = 0;
        double allGrade = 0;
        for (int i = 1; i <= 12; i++) {
            double grade = Double.parseDouble(scan.nextLine());

            if (grade >= 4) {
                allGrade += grade;
            } else {
                excluded++;
                if (excluded > 1) {
                    break;
                }
            }
            classCount++;
        }
        if (excluded > 1) {
            System.out.printf("%s has been excluded at %d grade", name, classCount);
        } else {
            System.out.printf("%s graduated. Average grade: %.2f", name, allGrade / 12);
        }
    }
}
