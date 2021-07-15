package _03_Arrays.MoreExercise;

import java.util.Scanner;

public class _02_PascalTriangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        printPascal(n);
    }

    public static void printPascal(int n) {
        // An auxiliary array to store generated pascal triangle values
        int[][] arr = new int[n][n];

        // Iterate through every line and print integer(s) in it
        for (int line = 0; line < n; line++) {
            // Every line has number of integers equal to line number
            for (int i = 0; i <= line; i++) {
                // First and last values in every row are 1
                if (line == i || i == 0) {
                    arr[line][i] = 1;
                } else {
                    // Other values are sum of values just above and left of above
                    arr[line][i] = arr[line - 1][i - 1] + arr[line - 1][i];
                }
                System.out.print(arr[line][i] + " ");
            }
            System.out.println("");
        }
    }
}

