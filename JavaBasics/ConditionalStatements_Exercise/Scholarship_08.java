package ConditionalStatements_Exercise;

import java.util.Scanner;

public class Scholarship_08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double earnings = Double.parseDouble(scan.nextLine());
        double averageScore = Double.parseDouble(scan.nextLine());
        double minSalary = Double.parseDouble(scan.nextLine());

        double socialScholarship = 0.0;
        double excellentScholarship = 0.0;

        if (earnings < minSalary && averageScore > 4.5) {
            socialScholarship = 0.35 * minSalary;
        }
        if (averageScore >= 5.5) {
            excellentScholarship = averageScore * 25;
        }
        if (socialScholarship == 0 && excellentScholarship == 0) {
            System.out.println("You cannot get a scholarship!");
        }

        if (socialScholarship > excellentScholarship) {
            System.out.printf("You get a Social scholarship %.0f BGN", Math.floor(socialScholarship));
        } else if (socialScholarship < excellentScholarship) {
            System.out.printf("You get a scholarship for excellent results %.0f BGN", Math.floor(excellentScholarship));
        }

    }
}
