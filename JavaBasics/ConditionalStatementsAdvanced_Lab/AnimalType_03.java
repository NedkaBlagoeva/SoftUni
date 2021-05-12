package ConditionalStatementsAdvanced_Lab;

import java.util.Scanner;

public class AnimalType_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String animal = scan.nextLine();

//        •	dog -> mammal
//        •	crocodile, tortoise, snake -> reptile
//        •	others -> unknown
        switch (animal){
            case "dog":
                System.out.println("mammal");
                break;
            case "crocodile":
            case "tortoise":
            case "snake":
                System.out.println("reptile");
                break;
            default:
                System.out.println("unknown");
        }


    }
}
