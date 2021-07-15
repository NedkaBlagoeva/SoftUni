package _07_MidExam._03_FundamentalsMidExamRetake;

import java.util.Arrays;
import java.util.Scanner;

public class _02_ShootForTheWin {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] targets = Arrays.stream(scan.nextLine()
                .split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String input = scan.nextLine();
        int count = 0;
        while (!"End".equals(input)) {
            int index = Integer.parseInt(input);
            if (index >= 0 && index < targets.length) {
                int num = targets[index];
                for (int i = 0; i < targets.length; i++) {
                    if (targets[i] != -1 && i != index){
                        if (targets[i] > num) {
                            targets[i] -= num;
                        } else {
                            targets[i] += num;
                        }
                    }
                }
                targets[index] = -1;
                count++;

            }
            input = scan.nextLine();
        }
        System.out.printf("Shot targets: %d -> ", count);
        for (int target : targets) {
            System.out.print(target + " ");
        }
    }
}
