package Methods_Lab;

import java.util.Scanner;

public class _09_GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //int, char of String
        String type = scan.nextLine();

        switch (type) {
            case "int":
                int num1 = Integer.parseInt(scan.nextLine());
                int num2 = Integer.parseInt(scan.nextLine());
                int result = getMax(num1, num2);
                System.out.println(result);
                break;
            case "char":
                char char1 = scan.nextLine().charAt(0);
                char char2 = scan.nextLine().charAt(0);
                char result1 = getMax(char1, char2);
                System.out.println(result1);
                break;
            case "string":
                String text1 = scan.nextLine();
                String text2 = scan.nextLine();
                String result2 = getMax(text1, text2);
                System.out.println(result2);
                break;

        }
    }

    private static int getMax(int num1, int num2) {
        int result = 0;
        if (num1 > num2) {
            result = num1;
        } else {
            result = num2;
        }
        return result;
    }

    private static char getMax(char char1, char char2) {
        char result;
        if (char1 > char2) {
            result = char1;
        } else {
            result = char2;
        }
        return result;
    }

    private static String getMax(String text1, String text2) {
        String result = "";
        if (text1.compareTo(text2) > 0) {
            result = text1;
        } else {
            result = text2;
        }
        return result;
    }
}
