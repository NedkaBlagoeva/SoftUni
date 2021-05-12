package NestedLoops_Lab;

import java.util.Scanner;

public class SumOfTwoNumbers_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n1 = Integer.parseInt(scan.nextLine());
        int n2 = Integer.parseInt(scan.nextLine());
        int magicNum = Integer.parseInt(scan.nextLine());
        int count = 0;
        boolean combinationIsFound = false;

        for (int i = n1; i <= n2; i++) {
            for (int j = n1; j <= n2; j++) {
                count++;
                if (i + j == magicNum){
                    System.out.printf("Combination N:%d (%d + %d = %d)", count, i, j, i + j);
                    combinationIsFound = true;
                    break;
                }
            }
            if (combinationIsFound){
                break;
            }
        } if (!combinationIsFound){
            System.out.printf("%d combinations - neither equals %d", count, magicNum);
        }

    }
}
