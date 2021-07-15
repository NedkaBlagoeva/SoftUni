package _07_MidExam._01_FundamentalsMidExamRetake;

import java.util.Arrays;
import java.util.Scanner;

public class _02_TheLift {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int peopleToWait = Integer.parseInt(scan.nextLine());
        int[] wagons = Arrays
                .stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < wagons.length; i++) {
            if (wagons[i] < 4 && peopleToWait > 0) {
                int diff = 4 - wagons[i];
                if (peopleToWait >= diff) {
                    wagons[i] = 4;
                    peopleToWait -= diff;
                } else {
                    wagons[i] = wagons[i] + peopleToWait;
                    peopleToWait = 0;
                    break;
                }
            }
        }
        boolean isEmpty = false;
        for (int wagon : wagons) {
            if (wagon != 4) {
                isEmpty = true;
                break;
            }
        }
        if (!isEmpty && peopleToWait == 0) {
            for (int wagon : wagons) {
                System.out.print(wagon + " ");
            }
        } else if (peopleToWait == 0) {
            System.out.println("The lift has empty spots!");
        } else if (peopleToWait > 0) {
            System.out.printf("There isn't enough space! %d people in a queue!\n", peopleToWait);
        }
        for (int wagon : wagons) {
            System.out.print(wagon + " ");
        }
    }
}
