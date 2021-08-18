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
                    int maxIndex = max(inputArr, commandArr[1]);
                    if (maxIndex == 0) {
                        System.out.println("No matches");
                    } else {
                        System.out.println(maxIndex);
                    }
                    break;
                case "min":
                    int minIndex = min(inputArr, commandArr[1]);
                    if (minIndex == 0) {
                        System.out.println("No matches");
                    } else {
                        System.out.println(minIndex);
                    }
                    break;
                case "first":
                    int countFirst = Integer.parseInt(commandArr[1]);
                    String typeFirst = commandArr[2];
                    first(inputArr, countFirst, typeFirst);
                    break;
                case "last":
                    int countLast = Integer.parseInt(commandArr[1]);
                    String typeLast = commandArr[2];
                    last(inputArr, countLast, typeLast);
                    break;
            }
            command = scan.nextLine();
        }
        System.out.println(Arrays.toString(inputArr));
    }


    private static boolean isValidIndex(int[] inputArr, int index) {
        return index >= 0 && index < inputArr.length;
    }

    private static void exchange(int[] inputArr, String index) {
        int arrIndex = Integer.parseInt(index);
        if (isValidIndex(inputArr, arrIndex)) {
            int temp = 0;
            for (int i = 0; i <= arrIndex; i++) {
                temp = inputArr[0];
                for (int j = 0; j < inputArr.length - 1; j++) {
                    inputArr[j] = inputArr[j + 1];
                }
                inputArr[inputArr.length - 1] = temp;
            }
        } else {
            System.out.println("Invalid index");
        }
    }

    private static int max(int[] inputArr, String type) {
        int maxEven = Integer.MIN_VALUE;
        int maxEvenIndex = 0;
        int maxOdd = Integer.MIN_VALUE;
        int maxOddIndex = 0;
        for (int i = 0; i < inputArr.length; i++) {
            if (inputArr[i] % 2 == 0) {
                if (maxEven <= inputArr[i]) {
                    maxEven = inputArr[i];
                    maxEvenIndex = i;
                }
            } else {
                if (maxOdd <= inputArr[i]) {
                    maxOdd = inputArr[i];
                    maxOddIndex = i;
                }
            }
        }
        return
                "even".equals(type) ? maxEvenIndex : maxOddIndex;
    }

    private static int min(int[] inputArr, String type) {
        int minEven = Integer.MAX_VALUE;
        int minEvenIndex = 0;
        int minOdd = Integer.MAX_VALUE;
        int minOddIndex = 0;
        for (int i = 0; i < inputArr.length; i++) {
            if (inputArr[i] % 2 == 0) {
                if (minEven >= inputArr[i]) {
                    minEven = inputArr[i];
                    minEvenIndex = i;
                }
            } else {
                if (minOdd >= inputArr[i]) {
                    minOdd = inputArr[i];
                    minOddIndex = i;
                }
            }
        }
        return "even".equals(type) ? minEvenIndex : minOddIndex;
    }

    private static void first(int[] inputArr, int count, String type) {
        int countOfEven = 0;
        int countOfOdd = 0;
        int[] even = new int[count];
        int[] odd = new int[count];
        if (count > inputArr.length) {
            System.out.println("Invalid count");
        } else {
            for (int i = 0; i < inputArr.length; i++) {
                if (inputArr[i] % 2 == 0) {
                    countOfEven++;
                    if (countOfEven <= count) {
                        even[countOfEven - 1] = inputArr[i];
                    }
                } else {
                    countOfOdd++;
                    if (countOfOdd <= count) {
                        odd[countOfOdd - 1] = inputArr[i];
                    }

                }
            }
        }

        if (type.equals("even")) {
            if (countOfEven > count) {
                System.out.print("[");
                for (int i = 0; i < count - 1; i++) {
                    System.out.print(even[i] + ", ");
                }
                System.out.print(even[even.length-1]);
                System.out.print("]");
                System.out.println();
            } else if (countOfEven == 0) {
                System.out.println("[]");
            } else {
                System.out.println(Arrays.toString(even));
            }
        }
        if (type.equals("odd")) {
            if (countOfOdd > count) {
                System.out.print("[");
                for (int i = 0; i < count - 1; i++) {
                    System.out.print(odd[i] + ", ");
                }
                System.out.print(odd[odd.length-1]);
                System.out.print("]");
                System.out.println();
            } else if (countOfEven == 0) {
                System.out.println("[]");
            } else {
                System.out.println(Arrays.toString(odd));
            }
        }
    }

    private static void last(int[] inputArr, int count, String type) {
        int countOfEven = 0;
        int countOfOdd = 0;
        int[] even = new int[count];
        int[] odd = new int[count];
        if (count > inputArr.length) {
            System.out.println("Invalid count");
        } else {
            for (int i = inputArr.length - 1; i >= 0; i--) {
                if (inputArr[i] % 2 == 0) {
                    countOfEven++;
                    if (countOfEven <= count) {
                        even[count - countOfEven] = inputArr[i];
                    }
                } else {
                    countOfOdd++;
                    if (countOfOdd <= count) {
                        odd[count - countOfOdd] = inputArr[i];
                    }
                }
            }
            if (type.equals("even")) {
                if (countOfEven > count) {
                    System.out.print("[");
                    for (int i = 0; i < count - 1; i++) {
                        System.out.print(even[i] + ", ");
                    }
                    System.out.print(even[even.length-1]);
                    System.out.print("]");
                    System.out.println();
                } else if (countOfEven == 0) {
                    System.out.println("[]");
                } else {
                    System.out.println(Arrays.toString(even));
                }
            }
            if (type.equals("odd")) {
                if (countOfOdd > count) {
                    System.out.print("[");
                    for (int i = 0; i < count - 1; i++) {
                        System.out.print(odd[i] + ", ");
                    }
                    System.out.print(odd[odd.length-1]);
                    System.out.print("]");

                    System.out.println();
                } else if (countOfEven == 0) {
                    System.out.println("[]");
                } else {
                    System.out.println(Arrays.toString(odd));
                }
            }
        }
    }
}