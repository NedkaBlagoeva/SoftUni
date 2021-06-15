package Methods_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _11_ArrayManipulator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] inputArr = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String command = scan.nextLine();
        while (!command.equals("end")) {
            String[] commandArr = command.split(" ");
            switch (commandArr[0]) {
                case "exchange":
                    inputArr = exchange(inputArr, commandArr[1]);
                    break;
                case "max":
                    if (commandArr[1].equals("odd")) {
                        maxOdd(inputArr);
                    } else if (commandArr[1].equals("even")) {
                        maxEven(inputArr);
                    }
                    break;
                case "min":
                    if (commandArr[1].equals("odd")) {
                        minOdd(inputArr);
                    } else if (commandArr[1].equals("even")) {
                        minEven(inputArr);
                    }
                    break;
                case "first":
                    if (commandArr[1].equals("odd")) {
                        firstOdd(inputArr);
                    } else if (commandArr[1].equals("even")) {
                        firstEven(inputArr);
                    }
                    break;
                case "last":
                    if (commandArr[2].equals("odd")) {
                        lastOdd(inputArr);
                    } else if (commandArr[2].equals("even")) {
                        lastEven(inputArr);
                    }
                    break;
            }
            command = scan.nextLine();
        }
    }

    private static int[] exchange(int[] inputArr, String index) {


        return new int[0];
    }

    private static void lastEven(int[] inputArr) {

    }
}
