package ExamPrep.Exam_26June2021;

import java.util.Scanner;

public class _02_Python {
    static int length = 1;
    static int food = 0;
    static int sRow;
    static int sCol;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int screenSize = Integer.parseInt(scan.nextLine());
        String[] commands = scan.nextLine().split(", ");
        char[][] field = new char[screenSize][screenSize];

        for (int r = 0; r < screenSize; r++) {
            String line = scan.nextLine().replaceAll("\\s+", "");
            field[r] = line.toCharArray();

            if (line.contains("s")) {
                sRow = r;
                sCol = line.indexOf("s");
            }

            for (char c : field[r]) {
                if (c == 'f') {
                    food++;
                }
            }
        }
        for (String command : commands) {
            if ("up".equals(command)) { //row - 1
                sRow -= 1;
                if (isOutOfBounds(screenSize, sRow, sCol)) {
                    sRow = screenSize - 1;
                }
                if (gameEnd(field)) {
                    return;
                }
            } else if ("down".equals(command)) { //row + 1
                sRow += 1;
                if (isOutOfBounds(screenSize, sRow, sCol)) {
                    sRow = 0;
                }
                if (gameEnd(field)) {
                    return;
                }
            } else if ("right".equals(command)) { //col + 1
                sCol += 1;
                if (isOutOfBounds(screenSize, sRow, sCol)) {
                    sCol = 0;
                }
                if (gameEnd(field)) {
                    return;
                }
            } else if ("left".equals(command)) { //col - 1
                sCol -= 1;
                if (isOutOfBounds(screenSize, sRow, sCol)) {
                    sCol = screenSize - 1;
                }
                if (gameEnd(field)) {
                    return;
                }
            }
        }
        System.out.printf("You lose! There is still %d food to be eaten.", food);
    }

    private static boolean gameEnd(char [][] field){
        checkFood(field, sRow, sCol);
        if (foodWin()) {
            return true;
        }
        return enemyKill(field, sRow, sCol);
    }

    private static boolean enemyKill(char[][] matrix, int sRow, int sCol) {
        char currentPosition = matrix[sRow][sCol];
        if (currentPosition == 'e') {
            System.out.println("You lose! Killed by an enemy!");
            return true;
        }
        return false;
    }

    private static void checkFood(char[][] matrix, int sRow, int sCol) {
        char currentPosition = matrix[sRow][sCol];
        if (currentPosition == 'f') {
            food--;
            length++;
        }
    }

    private static boolean foodWin() {
        if (food == 0) {
            System.out.println("You win! Final python length is " + length);
            return true;
        }
        return false;
    }

    public static boolean isOutOfBounds(int size, int sRow, int sCol) {
        return sRow >= size || sRow < 0 || sCol >= size || sCol < 0;
    }


}
