package Exam9_10March2019;

import java.util.Scanner;

public class HighJump_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int goal = Integer.parseInt(scan.nextLine());
        int stickHigh = goal - 30;
        int jumpTihomir = Integer.parseInt(scan.nextLine());
        boolean isSucceed = false;
        int countFail = 0;
        int countAll = 0;

        while (stickHigh < goal) {
            // ако скокът е успешен повдигаме летвата
            countAll++;
            if (jumpTihomir > stickHigh) {
                isSucceed = true;
                stickHigh += 5;
                countFail = 0;
            } else {
                countFail++;
                isSucceed = false;

            }
            if (countFail >= 3) {
                System.out.printf("Tihomir failed at %dcm after %d jumps.", stickHigh, countAll);
                break;
            }
            if (stickHigh >= goal && isSucceed) {
                System.out.printf("Tihomir succeeded, he jumped over " +
                        "%dcm after %d jumps.", goal, countAll + 1);
            }
            isSucceed = false;
            jumpTihomir = Integer.parseInt(scan.nextLine());
        }
    }
}
