package Exam28_29March2020;

import java.util.Scanner;

public class FoodForPets_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int days = Integer.parseInt(scan.nextLine());
        double food = Double.parseDouble(scan.nextLine());
        int sumCatFood = 0;
        int sumDogFood = 0;
        double biscuits = 0.0;
        double eatenFood = 0.0;

        for (int i = 1; i <= days; i++) {
            int dogFood = Integer.parseInt(scan.nextLine());
            int catFood = Integer.parseInt(scan.nextLine());
            sumCatFood += catFood;
            sumDogFood += dogFood;
            if (i % 3 == 0) {
                biscuits += (catFood + dogFood) * 0.1;
            }
        }
        eatenFood = sumDogFood + sumCatFood ;
        System.out.printf("Total eaten biscuits: %.0fgr.\n", biscuits);
        System.out.printf("%.2f%% of the food has been eaten.\n", eatenFood/ food * 100);
        System.out.printf("%.2f%% eaten from the dog.\n", sumDogFood / eatenFood * 100);
        System.out.printf("%.2f%% eaten from the cat.", sumCatFood / eatenFood * 100);
//•	"Total eaten biscuits: {количество изядени бисквитки}gr."
//•	"{процент изядена храна}% of the food has been eaten."
//•	"{процент изядена храна от кучето}% eaten from the dog."
//•	"{процент изядена храна от котката}% eaten from the cat."

    }
}
