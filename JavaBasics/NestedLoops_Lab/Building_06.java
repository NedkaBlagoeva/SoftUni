package NestedLoops_Lab;

import java.util.Scanner;

public class Building_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int flours = Integer.parseInt(scan.nextLine());
        int rooms = Integer.parseInt(scan.nextLine());

        for (int i = flours; i >= 1; i--) {
            for (int j = 0; j < rooms; j++) {
                if (i == flours){
                    System.out.printf("L%d%d ", i, j);
                }
                if (i % 2 == 0 && i != flours) {
                    System.out.printf("O%d%d ", i, j);
                }else if (i % 2 != 0 && i != flours){
                    System.out.printf("A%d%d ", i, j);
                }
            }
            System.out.println();
        }
    }
}
