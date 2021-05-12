package FirstStepsInCoding_Lab;

import java.util.Scanner;

public class PetShop_08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
       // System.out.print("Enter how many dogs are there: ");
        int countDogs = Integer.parseInt(scan.nextLine());
      //  System.out.print("Enter how many other animals are there: ");
        int countOther = Integer.parseInt(scan.nextLine());
        double sumNeeded = countDogs * 2.50 +countOther * 4;
        System.out.println(sumNeeded + " lv.");


    }
}
