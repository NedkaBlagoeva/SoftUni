package _02_MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class _05_MatrixShuffling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] inputData = scan.nextLine().split("\\s+");
        int rows = Integer.parseInt(inputData[0]);
        int cols = Integer.parseInt(inputData[1]);
        String[][] matrix = new String[rows][cols];
        fillMatrix(scan, rows, matrix);
        String commandline = scan.nextLine();
        while (!commandline.equals("END")) {
            String[] commandParameters = commandline.split("\\s+");
            if (!commandParameters[0].equals("swap") || commandParameters.length != 5) {
                System.out.println("Invalid input!");
                commandline = scan.nextLine();
                continue;
            }
            try {
                //row1 col1 row2c col2
                int row1 = Integer.parseInt(commandParameters[1]);
                int col1 = Integer.parseInt(commandParameters[2]);
                int row2 = Integer.parseInt(commandParameters[3]);
                int col2 = Integer.parseInt(commandParameters[4]);
                if (isValid(row1, rows, cols) && isValid(col1, rows, cols)
                        && isValid(row2, rows, cols) && isValid(col2, rows, cols)) {
                    swap(row1, col1, row2, col2, matrix);
                    printMatrix(matrix, rows, cols);
                } else {
                    System.out.println("Invalid input!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
            commandline = scan.nextLine();
        }
    }

    private static void swap(int row1, int col1, int row2, int col2, String[][] matrix) {
        String temp = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = temp;
    }

    private static boolean isValid(int index, int rows, int cols) {
        return index >= 0 && index <= rows && index <= cols;
    }

    private static void printMatrix(String[][] matrix, int r, int c) {
        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(Scanner scan, int rows, String[][] matrix) {
        for (int row = 0; row < rows; row++) {
            matrix[row] = scan.nextLine().split("\\s+");
        }
    }
}
