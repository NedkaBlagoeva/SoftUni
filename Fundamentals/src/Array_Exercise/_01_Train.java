package Array_Exercise;

import java.util.Scanner;

public class _01_Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int people = Integer.parseInt(scan.nextLine());
            System.out.print(people + " ");
            sum += people;
        }
        System.out.println();
        System.out.println(sum);
    }
}
