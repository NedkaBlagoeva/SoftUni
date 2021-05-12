package Exam28_29March2020;

import java.util.Scanner;

public class CareOfPuppy_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int food = Integer.parseInt(scan.nextLine()) * 1000;
        String input = scan.nextLine();
        int sumFood = 0;
        while (!input.equals("Adopted")){
            sumFood += Double.parseDouble(input);

            input = scan.nextLine();
        }
        if (sumFood <= food){
            System.out.printf("Food is enough! Leftovers: %d grams.", food - sumFood);
        }else{
            System.out.printf("Food is not enough. You need %d grams more.", sumFood - food);
        }
    }
}
