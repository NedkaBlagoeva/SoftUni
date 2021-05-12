package WhileLoop_Exercise;

import java.util.Scanner;

public class Cake_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int cakeWidth = Integer.parseInt(scan.nextLine());
        int cakeLength = Integer.parseInt(scan.nextLine());
        int allPieces = cakeLength * cakeWidth;
        String input = scan.nextLine();
        boolean isOver = false;

        while (!input.equals("STOP")) {
            int currentPieces = Integer.parseInt(input);
            allPieces -= currentPieces;
            if (allPieces <= 0) {
                isOver = true;
                break;
            }
            input = scan.nextLine();
        }
        if (isOver) {
            System.out.printf("No more cake left! You need %d pieces more.", Math.abs(allPieces));
        } else {
            System.out.printf("%d pieces are left.", Math.abs(allPieces));
        }


    }
}
