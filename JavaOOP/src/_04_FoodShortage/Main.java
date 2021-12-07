package _04_FoodShortage;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");

            switch (input.length) {
                case 4:
                    //"{name} {age} {id} {birthdate}
                    String name = input[0];
                    int age = Integer.parseInt(input[1]);
                    String id = input[2];
                    String birthDate = input[3];
                    Buyer citizen = new Citizen(name, age, id, birthDate);
                    break;
                case 3:
                    //"{name} {age}{group}"
                    Buyer rebel = new Rebel(input[0],Integer.parseInt(input[1]), input[2]);
                    break;
                default:
                    break;
            }
        }


    }
}
