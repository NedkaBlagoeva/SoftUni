package _02_MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class _03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[n][n];
        fillMatrix(scan, matrix);
        int firstDiagonal = firstDiagonal(matrix);
        int secondDiagonal = secondDiagonal(matrix);
        System.out.println(Math.abs(firstDiagonal - secondDiagonal));
    }

    private static int secondDiagonal(int[][] matrix) {
        int secondDiagonal = 0;
        int col = matrix.length - 1;
        for (int row = 0; row < matrix.length; row++) {
            secondDiagonal += matrix[row][col];
            col--;
        }
        return secondDiagonal;
    }

    private static int firstDiagonal(int[][] matrix) {
        int firstDiagonal = 0;
        for (int i = 0; i < matrix.length; i++) {
            firstDiagonal += matrix[i][i];
        }
        return firstDiagonal;
    }

    private static void fillMatrix(Scanner scan, int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                matrix[row][col] = scan.nextInt();
            }
        }
    }
}
