package _08_MapsLambdaAndStreamAPI.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _04_Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Map<Double, Integer>> products = new LinkedHashMap<>();
        String input = scan.nextLine();
        while (!"buy".equals(input)){
            String product = input.split(" ")[0];
            double price = Double.parseDouble(input.split(" ")[1]);
            int quantity = Integer.parseInt(input.split(" ")[2]);




            input = scan.nextLine();
        }
    }
}
