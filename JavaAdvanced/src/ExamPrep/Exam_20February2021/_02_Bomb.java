package ExamPrep.Exam_20February2021;

import java.util.Scanner;

public class _02_Bomb {
    static int bombs = 0;
    static int sRow;
    static int sCol;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int fieldSize = Integer.parseInt(scan.nextLine());
        String[] commands = scan.nextLine().split(",");
        char[][] field = new char[fieldSize][fieldSize];

        for (int r = 0; r < fieldSize; r++) {
            String line = scan.nextLine().replaceAll("\\s+", "");
            field[r] = line.toCharArray();

            if (line.contains("s")) {
                sRow = r;
                sCol = line.indexOf("s");
            }

            for (char c : field[r]) {
                if (c == 'B') {
                    bombs++;
                }
            }
        }
        for (String command : commands) {
            switch (command) {
                case "up"://row - 1
                    sRow -= 1;
                    if (isOutOfBounds(fieldSize, sRow, sCol)) {
                        sRow += 1;
                    }
                    if (gameEnd(field)) {
                        return;
                    }
                    break;
                case "down": //row + 1
                    sRow += 1;
                    if (isOutOfBounds(fieldSize, sRow, sCol)) {
                        sRow -= 1;
                    }
                    if (gameEnd(field)) {
                        return;
                    }
                    break;
                case "right": //col + 1
                    sCol += 1;
                    if (isOutOfBounds(fieldSize, sRow, sCol)) {
                        sCol -= 1;
                    }
                    if (gameEnd(field)) {
                        return;
                    }
                    break;
                case "left": //col - 1
                    sCol -= 1;
                    if (isOutOfBounds(fieldSize, sRow, sCol)) {
                        sCol += 1;
                    }
                    if (gameEnd(field)) {
                        return;
                    }
                    break;
            }
        }
        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", bombs, sRow, sCol);
    }

    private static boolean gameEnd(char[][] field) {
        bombCheck(field, sRow, sCol);
        if (bombWin()) {
            return true;
        }
        return enemyKill(field, sRow, sCol);
    }

    private static boolean enemyKill(char[][] matrix, int sRow, int sCol) {
        char currentPosition = matrix[sRow][sCol];
        if (currentPosition == 'e') {
            System.out.printf("END! %d bombs left on the field%n", bombs);
            return true;
        }
        return false;
    }

    private static void bombCheck(char[][] matrix, int sRow, int sCol) {
        char currentPosition = matrix[sRow][sCol];
        if (currentPosition == 'B') {
            bombs--;
            matrix[sRow][sCol] = '+';
            System.out.println("You found a bomb!");
        }
    }

    private static boolean bombWin() {
        if (bombs == 0) {
            System.out.println("Congratulations! You found all bombs!");
            return true;
        }
        return false;
    }

    public static boolean isOutOfBounds(int size, int sRow, int sCol) {
        return sRow >= size || sRow < 0 || sCol >= size || sCol < 0;
    }


}