package _02_FundamentalsMidExam;

import java.util.Scanner;

public class _01_SoftUniReception {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int efficiency1 = Integer.parseInt(scan.nextLine());
        int efficiency2 = Integer.parseInt(scan.nextLine());
        int efficiency3 = Integer.parseInt(scan.nextLine());
        int studentsCount = Integer.parseInt(scan.nextLine());
        int time = 0;
        int allEfficiency = efficiency1 + efficiency2 + efficiency3;
        if (studentsCount % allEfficiency == 0) {
            time = studentsCount / allEfficiency;
        } else {
            time = studentsCount / allEfficiency + 1;
        }
        int employeeBreak = 0;
        if (time > 3) {
            if (time % 3 == 0) {
                employeeBreak = time / 3 - 1;
            } else {
                employeeBreak = time / 3;
            }
            time += employeeBreak;
        }
        System.out.printf("Time needed: %dh.", time);
    }
}
