package DataTypesAndVariables_MoreExercise;

import java.util.Scanner;

public class _06_BalancedBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int openBracket = 0;
        int closeBracket = 0;
        boolean isBalanced = false;
        for (int line = 1; line <= n; line++) {
            String input = scan.nextLine();

            if (input.charAt(0) == 40) {
                openBracket++;
                if (openBracket - closeBracket >= 2) {
                    isBalanced = false;
                    break;
                }
            } else if (input.charAt(0) == 41) {
                closeBracket++;
                if (closeBracket > openBracket) {
                    isBalanced = false;
                    break;
                }
            }
        }
        if (openBracket == closeBracket) {
            isBalanced = true;
        } else {
            isBalanced = false;
        }
        if (isBalanced) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}
