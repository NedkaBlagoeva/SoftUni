package Array_Exercise;

import java.util.Scanner;

public class _04_ArrayRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] array = scan.nextLine().split(" ");
        int rotations = Integer.parseInt(scan.nextLine());
        String temp = "";
        for (int i = 1; i <= rotations; i++) {
            temp = array[0];
            for (int j = 0; j < array.length - 1; j++) {
                array[j] = array[j + 1];
            }
            array[array.length - 1] = temp;
        }
        System.out.print(String.join(" ", array));
    }
}
