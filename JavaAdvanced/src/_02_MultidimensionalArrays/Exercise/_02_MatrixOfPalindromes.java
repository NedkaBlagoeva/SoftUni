package _02_MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class _02_MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);

        String[][] matrix = new String[r][c];
        fillMatrix(r, c, matrix);
        printMatrix(matrix, r, c);
    }

    private static void printMatrix(String[][] matrix, int r, int c) {
        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(int r, int c, String[][] matrix) {
        char firstLetter = 'a';
        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                matrix[row][col] = String.valueOf(firstLetter) + (char) (firstLetter + col) + firstLetter;
            }
            firstLetter++;
        }
    }
}
