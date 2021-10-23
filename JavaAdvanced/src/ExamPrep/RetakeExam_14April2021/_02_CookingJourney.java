package ExamPrep.RetakeExam_14April2021;

import java.util.Scanner;

public class _02_CookingJourney {
    static int sum = 0;
    static int sRow;
    static int sCol;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int shopSize = Integer.parseInt(scan.nextLine());
        char[][] shop = new char[shopSize][shopSize];


        for (int r = 0; r < shopSize; r++) {
            String line = scan.nextLine().replaceAll("\\s+", "");
            shop[r] = line.toCharArray();

            if (line.contains("S")) {
                sRow = r;
                sCol = line.indexOf("s");
            }

            for (char c : shop[r]) {
                if (c == 'P') {

                }
            }
        }

        while (true) {
            String command = scan.nextLine();
            switch (command) {
                case "up"://row - 1
                    sRow -= 1;
                    if (isOutOfBounds(shopSize, sRow, sCol)) {
                        return;
                    }
                    checkClient(shop, sRow, sCol);
                    if (enoughMoney()){
                        return;
                    }


                    break;
                case "down": //row + 1
                    sRow += 1;

                    if (isOutOfBounds(shopSize, sRow, sCol)) {
                        return;
                    }

                    break;
                case "right": //col + 1
                    sCol += 1;
                    if (isOutOfBounds(shopSize, sRow, sCol)) {
                        return;
                    }

                    break;
                case "left": //col - 1
                    sCol -= 1;
                    if (isOutOfBounds(shopSize, sRow, sCol)) {
                        return;
                    }

                    break;
            }
        }
    }

    public void ff(){

    }

    public static boolean isOutOfBounds(int size, int sRow, int sCol) {
        if (sRow >= size || sRow < 0 || sCol >= size || sCol < 0) {
            System.out.println("Bad news! You are out of the pastry shop.");
            return true;
        }
        return false;
    }

    private static void checkClient(char[][] matrix, int sRow, int sCol) {
        char currentPosition = matrix[sRow][sCol];
        if (Character.isDigit(currentPosition)) {
            sum += currentPosition;
            matrix[sRow][sCol] = '-';
        }
    }

    private static boolean enoughMoney() {
        if (sum >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
            return true;
        }
        return false;
    }
}
