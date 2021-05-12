package ConditionalStatements_Exercise;

import java.util.Scanner;

public class WorldSwimmingRecord_07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double record = Double.parseDouble(scan.nextLine());
        double distance = Double.parseDouble(scan.nextLine());
        double timeFor1m = Double.parseDouble(scan.nextLine());
        double slowing = Math.floor(distance / 15) * 12.5;
        double ivanTime = (distance * timeFor1m) + slowing;
        if (ivanTime < record) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", ivanTime);
        } else {
            System.out.printf("No, he failed! He was %.2f seconds slower.", ivanTime - record);
        }


    }
}
