package _08_MapsLambdaAndStreamAPI.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _01_CountCharsInAString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        Map<Character, Integer> charCounts = new LinkedHashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char currentSymbol = text.charAt(i);
            if (currentSymbol == ' ') {
                continue;
            }
            charCounts.putIfAbsent(currentSymbol, 0);
            charCounts.put(currentSymbol, charCounts.get(currentSymbol) + 1);
        }
        charCounts.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
