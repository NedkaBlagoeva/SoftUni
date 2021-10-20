package ExamPrep.RetakeExam18August2021;

import java.util.Scanner;

public class _02_FormulaOne {
    static int pRow = 0;
    static int pCol = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());
        int commandsCount = Integer.parseInt(scan.nextLine());

        char[][] matrix = new char[size][size];
        for (int r = 0; r < size; r++) {
            String line = scan.nextLine().replaceAll("\\s+", "");
            matrix[r] = line.toCharArray();

            if (line.contains("P")) {
                pRow = r;
                pCol = line.indexOf("P");
            }

        }
        for (int i = 0; i < commandsCount; i++) {
            String command = scan.nextLine();
            switch (command){
                case "left":
                    break;
                case "right":
                    break;
                case "up":
                    break;
                case "down":
                    break;
                default:
                    break;
            }
        }
    }
}
