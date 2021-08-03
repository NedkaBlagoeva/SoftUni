package _09_TextProcessing.MoreExercise;

import java.util.Scanner;

public class _05_HTML {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int count = 0;
        while (!"end of comments".equals(input)) {
            count++;
            if (count == 1) {
                System.out.printf("<h1>%n%s%n</h1>%n", input);
            } else if (count == 2) {
                System.out.printf("<article>%n%s%n</article>%n", input);
            } else {
                System.out.printf("<div>%n%s%n</div>%n", input);
            }
            input = scan.nextLine();
        }
    }
}
