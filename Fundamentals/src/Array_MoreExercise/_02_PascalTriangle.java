package Array_MoreExercise;

import java.util.Scanner;

public class _02_PascalTriangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[] startArray = new int[n];
        startArray[0] = 1;
        System.out.println(startArray[0]);
        int[] modifiedArray = new int[n];
        for (int row = 2; row <= n; row++) {
            for (int element = 1; element < n-1; element++) {
                modifiedArray[0] = startArray[0];
                modifiedArray[element] = startArray[element] + startArray[element-1];
            }
            startArray = modifiedArray;
            for (int i : modifiedArray) {
                System.out.print(i + " ");
            }
            System.out.println();

        }

    }
}
