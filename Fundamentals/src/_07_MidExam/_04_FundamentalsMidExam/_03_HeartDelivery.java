package _07_MidExam._04_FundamentalsMidExam;

import java.util.Arrays;
import java.util.Scanner;

public class _03_HeartDelivery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] houses = Arrays.stream(scan.nextLine().split("@"))
                .mapToInt(Integer::parseInt).toArray();
        String input = scan.nextLine();
        int currentIndex = 0;
        while (!"Love!".equals(input)) {
            int jumpLength = Integer.parseInt(input.split("\\s+")[1]);
            currentIndex += jumpLength;
            if (currentIndex >= houses.length) {
                currentIndex = 0;
            }
            if (houses[currentIndex] != 0) {
                houses[currentIndex] -= 2;
                if (houses[currentIndex] == 0) {
                    System.out.printf("Place %d has Valentine's day.%n", currentIndex);
                }
            } else {
                System.out.printf("Place %d already had Valentine's day.%n", currentIndex);
            }
            input = scan.nextLine();
        }
        System.out.printf("Cupid's last position was %d.%n", currentIndex);
        int count = 0;
        for (Integer house : houses) {
            if (house != 0) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.", count);
        }
    }
}
