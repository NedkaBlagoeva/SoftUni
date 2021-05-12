package Exam20_21April2019;

import java.util.Scanner;

public class EasterEggs_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int countEggs = Integer.parseInt(scan.nextLine());
        int countRed = 0;
        int countOrange = 0;
        int countBlue = 0;
        int countGreen = 0;
        int maxEggsByColour = 0;
        String colour = "";


        for (int i = 1; i <= countEggs ; i++) {
            String eggColour = scan.nextLine();

            switch (eggColour){
                case "red":
                    countRed ++;
                    break;
                case "orange":
                    countOrange ++;
                    break;
                case "blue":
                    countBlue ++;
                    break;
                case "green":
                    countGreen ++;
                    break;
            }
        }
        if (countRed > maxEggsByColour){
            maxEggsByColour = countRed;
            colour = "red";

        }
        if (countOrange > maxEggsByColour){
            maxEggsByColour = countOrange;
            colour = "orange";

        }
        if (countBlue > maxEggsByColour){
            maxEggsByColour = countBlue;
            colour = "blue";

        }
        if (countGreen > maxEggsByColour){
            maxEggsByColour = countGreen;
            colour = "green";

        }
        System.out.printf("Red eggs: %d\n", countRed);
        System.out.printf("Orange eggs: %d\n", countOrange);
        System.out.printf("Blue eggs: %d\n", countBlue);
        System.out.printf("Green eggs: %d\n",countGreen);
        System.out.printf("Max eggs: %d -> %s", maxEggsByColour, colour);
    }
}
