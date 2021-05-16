package BasicSyntaxConditionalStatementsAndLoops_MoreExercise;

import java.util.Scanner;

public class _04_ReverseString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();
        String backwards = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            backwards += word.charAt(i);
        }
        System.out.println(backwards);
    }
}
