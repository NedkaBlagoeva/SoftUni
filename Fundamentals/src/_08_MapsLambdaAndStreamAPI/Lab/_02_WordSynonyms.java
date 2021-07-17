package _08_MapsLambdaAndStreamAPI.Lab;

import java.util.*;

public class _02_WordSynonyms {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, List<String>> words = new LinkedHashMap<>();
        for (int i = 1; i <= n; i++) {
            String word = scan.nextLine();
            String synonym = scan.nextLine();
            if (!words.containsKey(word)) {
                words.put(word, new ArrayList<>());
            }
            words.get(word).add(synonym);
        }
        words.forEach((key, value) -> System.out.println(key + " - " + String.join(", ", value)));
    }
}
