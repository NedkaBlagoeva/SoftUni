package BasicSyntaxConditionalStatementsAndLoops_Lab;

import java.util.Scanner;

public class _04_BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int hours = Integer.parseInt(scan.nextLine());
        int minutes = Integer.parseInt(scan.nextLine());

        if (minutes > 29) {
            hours++;
            minutes = minutes + 30 - 60;
        } else {
            minutes += 30;
        }
        if (hours > 23) {
            hours = 0;
        }
        System.out.printf("%d:%02d", hours, minutes);
    }
}
