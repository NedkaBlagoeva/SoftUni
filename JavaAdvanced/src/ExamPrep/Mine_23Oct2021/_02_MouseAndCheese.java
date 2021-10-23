package ExamPrep.Mine_23Oct2021;

import java.util.Scanner;

public class _02_MouseAndCheese {
    static int mRow;
    static int mCol;
    static int cheese;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        char[][] field = new char[size][size];

        for (int r = 0; r < size; r++) {
            String line = scan.nextLine();
            field[r] = line.toCharArray();

            if (line.contains("M")) {
                mRow = r;
                mCol = line.indexOf("M");
                field[mRow][mCol] = '-';
            }
        }

        String command = scan.nextLine();
        boolean isOut = false;
        label:
        while (!command.equals("end")) {
            switch (command) {
                case "up":
                    mRow -= 1;
                    if (isOutOfBounds(size, mRow, mCol)) {
                        System.out.println("Where is the mouse?");
                        isOut = true;
                        break label;
                    }
                    checkFood(field);
                    if (bonus(field)) {
                        field[mRow][mCol] = '-';
                        command = "up";
                        continue;
                    }
                    break;
                case "down":
                    mRow += 1;
                    if (isOutOfBounds(size, mRow, mCol)) {
                        System.out.println("Where is the mouse?");
                        isOut = true;
                        break label;
                    }
                    checkFood(field);
                    if (bonus(field)) {
                        field[mRow][mCol] = '-';
                        command = "down";
                        continue;
                    }
                    break;
                case "right":
                    mCol += 1;
                    if (isOutOfBounds(size, mRow, mCol)) {
                        System.out.println("Where is the mouse?");
                        isOut = true;
                        break label;
                    }
                    checkFood(field);
                    if (bonus(field)) {
                        field[mRow][mCol] = '-';
                        command = "right";
                        continue;
                    }
                    break;
                case "left":
                    mCol -= 1;
                    if (isOutOfBounds(size, mRow, mCol)) {
                        System.out.println("Where is the mouse?");
                        isOut = true;
                        break label;
                    }
                    checkFood(field);
                    if (bonus(field)) {
                        field[mRow][mCol] = '-';
                        command = "left";
                        continue;
                    }
                    break;
            }

            command = scan.nextLine();
        }
        if (cheese >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheese);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheese);
        }
        if (!isOut) {
            field[mRow][mCol] = 'M';
        }
        print(field);
    }

    private static void print(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    public static boolean isOutOfBounds(int size, int mRow, int mCol) {
        return mRow >= size || mRow < 0 || mCol >= size || mCol < 0;
    }

    public static boolean bonus(char[][] matrix) {
        char currentPosition = matrix[mRow][mCol];
        return currentPosition == 'B';
    }

    private static void checkFood(char[][] matrix) {
        char currentPosition = matrix[mRow][mCol];
        if (currentPosition == 'c') {
            cheese++;
            matrix[mRow][mCol] = '-';
        }
    }


}
