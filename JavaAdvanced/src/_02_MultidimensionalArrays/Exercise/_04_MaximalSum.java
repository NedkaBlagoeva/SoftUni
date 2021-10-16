package _02_MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class _04_MaximalSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] inputData = scan.nextLine().split("\\s+");
        int rows = Integer.parseInt(inputData[0]);
        int cols = Integer.parseInt(inputData[1]);
        int[][] matrix = new int[rows][cols];
        fillMatrix(scan, rows, cols, matrix);
        printMaxMatrix(rows, cols, matrix);
    }

    private static void printMaxMatrix(int rows, int cols, int[][] matrix) {
        int maxSum = 0;
        int maxRow = 0;
        int maxCol = 0;
        //find
        for (int row = 0; row <= rows - 3; row++) {
            for (int col = 0; col <= cols - 3; col++) {
                int sum = sumMatrix(matrix, row, col);
                if (sum > maxSum) {
                    maxSum = sum;
                    maxRow = row;
                    maxCol = col;
                }
            }
        }
        //print
        System.out.println("Sum = " + maxSum);
        for (int row = maxRow; row < maxRow + 3; row++) {
            for (int col = maxCol; col < maxCol + 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int sumMatrix(int[][] matrix, int startRow, int startCol) {
        int sum = 0;
        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startCol; col < startCol + 3; col++) {
                sum += matrix[row][col];
            }
        }
        return sum;
    }

    private static void fillMatrix(Scanner scan, int rows, int cols, int[][] matrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = scan.nextInt();
            }
        }
    }
}
