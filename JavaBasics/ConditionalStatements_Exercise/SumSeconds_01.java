package ConditionalStatements_Exercise;

import java.util.Scanner;

public class SumSeconds_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstTime = Integer.parseInt(scan.nextLine());
        int secondTime = Integer.parseInt(scan.nextLine());
        int thirdTime = Integer.parseInt(scan.nextLine());

        int totalTime = firstTime + secondTime + thirdTime;
        int minutes = totalTime / 60;
        int seconds = totalTime % 60;

        System.out.printf("%d:%02d",minutes,seconds);


    }

}
