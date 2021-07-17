package _08_MapsLambdaAndStreamAPI.Lab;

import java.util.*;

public class _03_OddOccurrences {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] words = scan.nextLine().split(" ");
        Map<String, Integer> wordCounts = new LinkedHashMap<>();
        for (String word : words) {
            String currentWord = word.toLowerCase();
            wordCounts.putIfAbsent(currentWord, 0);
            wordCounts.put(currentWord, wordCounts.get(currentWord) + 1);
        }
        List<String> oddKeys = new ArrayList<>();

        for (var s : wordCounts.entrySet()) {
            if (s.getValue() % 2 != 0) {
                oddKeys.add(s.getKey());
            }
        }
        System.out.print(String.join(", ", oddKeys));

    }
}

