package _04_Methods.Lab;

import java.util.Scanner;

public class _06_CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int width = Integer.parseInt(scan.nextLine());
        int height = Integer.parseInt(scan.nextLine());
        int area = rectArea(width, height);
        System.out.println(area);
    }

    private static int rectArea(int a, int b) {
        return a * b;
    }
}
