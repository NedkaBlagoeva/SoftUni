package _03_Arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _10_LadyBugs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int fieldSize = Integer.parseInt(scan.nextLine());
        int[] field = new int[fieldSize];
        int[] indexes = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < indexes.length; i++) {
            int currentIndex = indexes[i];
            field[currentIndex] = 1;
        }
        
        String command = scan.nextLine();
        while (!command.equals("end")) {
            String[] commandArr = command.split(" ");
            switch (commandArr[1]) {
                case "right":
                    break;
                case "left":
                    break;
            }
            command = scan.nextLine();
        }
    }

    private static void moveArrRight(String[] command, int [] field) {
        int startIndex = Integer.parseInt(command [0]);
        int flyLength = Integer.parseInt(command [2]);

        for (int index = startIndex; index < field.length ; index++) {
            field [index] = field[index - 1];
        }


    }
}

