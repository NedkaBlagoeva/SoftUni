package Exam20_21February2021;

import java.util.Scanner;

public class Spaceship_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double spaceshipWidth = Double.parseDouble(scan.nextLine());
        double spaceshipLength = Double.parseDouble(scan.nextLine());
        double spaceshipHigh = Double.parseDouble(scan.nextLine());
        double astronautsHigh = Double.parseDouble(scan.nextLine());
        double spaceshipVolume = spaceshipHigh * spaceshipLength * spaceshipWidth;

        double roomVolume = (astronautsHigh + 0.40) * 2 * 2;
        double astronauts = Math.floor(spaceshipVolume / roomVolume);

        if (astronauts < 3){
            System.out.println("The spacecraft is too small.");
        }else if (astronauts <= 10){
            System.out.printf("The spacecraft holds %.0f astronauts.", astronauts);
        }else {
            System.out.println("The spacecraft is too big.");
        }

    }
}
