package WhileLoop_Exercise;

import java.util.Scanner;

public class Walking_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int stepsCount = 0;
       // boolean goalReached = false;

        while (!input.equals("Going home")) {
            int steps = Integer.parseInt(input);
            stepsCount += steps;
            if (stepsCount >= 10000) {
                break;
            }
            input = scan.nextLine();
        }
        if (input.equals("Going home")) {
            int stepsHome = Integer.parseInt(scan.nextLine());
            stepsCount += stepsHome;
        }
        int diff = Math.abs(stepsCount - 10000);
        if (stepsCount >= 10000) {
            System.out.printf("Goal reached! Good job!\n" +
                    "%d steps over the goal!", diff);
        } else {
            System.out.printf("%d more steps to reach goal.", diff);
        }

    }
}
