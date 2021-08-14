package FinalExam._05_FinalExam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02_EmojiDetector {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String regex = "([:*]{2})(?<emoji>[A-Z][a-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        char[] symbols = input.toCharArray();
        long coolnessThreshold = 1;
        for (char symbol : symbols) {
            if (Character.isDigit(symbol)) {
                coolnessThreshold *= Integer.parseInt(String.valueOf(symbol));
            }
        }
        Map<String, Integer> matchedEmojis = new LinkedHashMap<>();
        int count = 0;
        while (matcher.find()) {
            matchedEmojis.put(matcher.group(), 0);
            count++;
        }
        for (var entry : matchedEmojis.entrySet()) {
            int sum = 0;
            for (int i = 2; i < entry.getKey().length() - 2; i++) {
                    sum += entry.getKey().charAt(i);
            }
            matchedEmojis.put(entry.getKey(), sum);
        }
        System.out.printf("Cool threshold: %d%n", coolnessThreshold);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", count);
        long finalCoolnessThreshold = coolnessThreshold;
        matchedEmojis.entrySet().stream().filter(entry -> entry.getValue() >= finalCoolnessThreshold).forEach(entry -> System.out.println(entry.getKey()));
    }
}
