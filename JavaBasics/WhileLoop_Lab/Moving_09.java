package WhileLoop_Lab;

import java.util.Scanner;

public class Moving_09 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int width = Integer.parseInt(scan.nextLine());
        int length = Integer.parseInt(scan.nextLine());
        int high = Integer.parseInt(scan.nextLine());
        String input = scan.nextLine();
        int sumBoxes = 0;
        int houseVolume = width * length * high;

        while (!input.equals("Done")) {
            int boxes = Integer.parseInt(input);
            sumBoxes += boxes;
            if (sumBoxes >= houseVolume) {
                break;
            }
            input = scan.nextLine();
        }
        int diff = Math.abs(sumBoxes - houseVolume);
        if (sumBoxes >= houseVolume) {
            System.out.printf("No more free space! You need %d Cubic meters more.", diff);
        } else {
            System.out.printf("%d Cubic meters left.", diff);
        }
    }
}
