package _03_Arrays.Lab;

import java.util.Scanner;

public class _01_DayOfWeek {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = Integer.parseInt(scan.nextLine());

        String[] dayOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        if (input >= 1 && input <= 7) {
            System.out.println(dayOfWeek[input - 1]);
        } else {
            System.out.println("Invalid day!");
        }
    }
}
