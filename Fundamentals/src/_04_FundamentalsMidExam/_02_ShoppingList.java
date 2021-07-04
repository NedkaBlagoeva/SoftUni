package _04_FundamentalsMidExam;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _02_ShoppingList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List <String> groceries = Arrays.stream(scan.nextLine().split("!")).collect(Collectors.toList());
        String input = scan.nextLine();
        while (!"Go Shopping".equals(input)){
            String [] commands = input.split("\\s+");
            String command = commands[0];
            switch (command){
                case "Urgent":
                    break;
                case "Unnecessary":
                    break;
                case "Correct":
                    break;
                case "Rearrange":
                    break;
                default:
                    break;
            }
            input = scan.nextLine();
        }
        for (int i = 0; i < groceries.size() - 1; i++) {
            
        }
    }
}
