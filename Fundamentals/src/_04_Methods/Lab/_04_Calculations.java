package _04_Methods.Lab;

import java.util.Scanner;

public class _04_Calculations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();
        int numb1 = Integer.parseInt(scan.nextLine());
        int numb2 = Integer.parseInt(scan.nextLine());

        switch (command) {
            case "add":
                add(numb1, numb2);
                break;
            case "multiply":
                multiply(numb1, numb2);
                break;
            case "subtract":
                subtract(numb1, numb2);
                break;
            case "divide":
                divide(numb1, numb2);
                break;
            default:
                break;
        }

    }

    private static void multiply(int a, int b) {
        System.out.println(a * b);
    }

    private static void subtract(int a, int b) {
        System.out.println(a - b);
    }

    private static void divide(int a, int b) {
        if (b != 0) {
            System.out.println(a / b);
        }
    }

    private static void add(int a, int b) {
        System.out.println(a + b);
    }
}
