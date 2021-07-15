package _03_Arrays.Exercise;

import java.util.Scanner;

public class _02_CommonElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] array1 = scan.nextLine().split(" ");
        String[] array2 = scan.nextLine().split(" ");
//        for (String secondWord : array2) {
//            for (String firstWord : array1) {
//                if(secondWord.equals(firstWord)) {
//                    System.out.print(firstWord + " ");
//                }
//            }
//        }

        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array1.length; j++) {
                if (array2[i].equals(array1[j])) {
                    System.out.print(array1[j] + " ");
                }
            }
        }
    }
}
