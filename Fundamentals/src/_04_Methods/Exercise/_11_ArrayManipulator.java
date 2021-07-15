package _04_Methods.Exercise;

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
                    exchange(inputArr, commandArr[1]);
                    break;
                case "max":
                    if (commandArr[1].equals("odd")) {
                       // maxOdd(inputArr);
                    } else if (commandArr[1].equals("even")) {
                       // maxEven(inputArr);
                    }
                    break;
                case "min":
                    if (commandArr[1].equals("odd")) {
                      //  minOdd(inputArr);
                    } else if (commandArr[1].equals("even")) {
                       // minEven(inputArr);
                    }
                    break;
                case "first":
                    if (commandArr[1].equals("odd")) {
                       // firstOdd(inputArr);
                    } else if (commandArr[1].equals("even")) {
                        //firstEven(inputArr);
                    }
                    break;
                case "last":
                    if (commandArr[2].equals("odd")) {
                        //lastOdd(inputArr);
                    } else if (commandArr[2].equals("even")) {
                        lastEven(inputArr);
                    }
                    break;
            }
            command = scan.nextLine();
        }
    }

    private static void exchange(int[] inputArr, String index) {
        int arrIndex = Integer.parseInt(index);
        int []arrToIndex = new int[arrIndex + 1];
        int []arrAfterIndex = new int[inputArr.length - arrIndex - 1];
        for (int i = 0; i < arrIndex + 1; i++) {
            arrToIndex [i] = inputArr[i];
        }
        for (int item : arrToIndex) {
            System.out.print(item + " ");
        }
        System.out.println();
        for (int i = arrIndex + 1; i < inputArr.length; i++) {
            arrAfterIndex [i - arrIndex - 1] = inputArr[i];
        }
        for (int item : arrAfterIndex) {
            System.out.print(item + " ");
        }
        int [] exchangedArr = new int[inputArr.length];

    }

    private static void lastEven(int[] inputArr) {

    }
}
