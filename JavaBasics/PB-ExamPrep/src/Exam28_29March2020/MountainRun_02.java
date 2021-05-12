package Exam28_29March2020;

import java.util.Scanner;

public class MountainRun_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double record = Double.parseDouble(scan.nextLine());
        double distance = Double.parseDouble(scan.nextLine());
        double timeForM = Double.parseDouble(scan.nextLine());
        double delay = Math.floor(distance / 50) * 30;

        double timeGeorge = distance * timeForM + delay;

        if (timeGeorge >= record ){
            System.out.printf("No! He was %.2f seconds slower.", timeGeorge - record);
        } else {
            System.out.printf("Yes! The new record is %.2f seconds.", timeGeorge);
        }

    }
}
