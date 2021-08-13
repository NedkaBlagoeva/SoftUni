package FinalExam._03_FinalExamRetake;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02_MirrorWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        String regex = "([#@])(?<firstWord>[A-Za-z]{3,})\\1\\1(?<secondWord>[A-Za-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        Map<String, String> matchedPairs = new LinkedHashMap<>();
        int count = 0;
        int countMirrorPairs = 0;
        while (matcher.find()) {
            count++;
            StringBuilder reversed = new StringBuilder((matcher.group("secondWord")));
            reversed.reverse();
            if (matcher.group("firstWord").equals(reversed.toString())) {
                countMirrorPairs++;
                matchedPairs.put(matcher.group("firstWord"), matcher.group("secondWord"));
            }
        }
        if (count == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.printf("%d word pairs found!%n", count);
        }
        if (countMirrorPairs == 0) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            String output = matchedPairs.toString()
                    .replace("{", "")
                    .replace("}", "")
                    .replace("=", " <=> ");
            System.out.println(output);
        }
    }
}
