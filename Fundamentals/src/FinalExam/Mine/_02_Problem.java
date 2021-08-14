package FinalExam.Mine;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02_Problem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String regex = "\\|(?<name>[A-Z]{4,})\\|:#(?<title>[A-Za-z]+\\s[A-Za-z]+)#";
        Pattern pattern = Pattern.compile(regex);

        int count = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < count; i++) {
            String text = scan.nextLine();
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                System.out.printf("%s, The %s%n>> Strength: %d\n>> Armor: %d\n",
                        matcher.group("name"), matcher.group("title"),
                        matcher.group("name").length(), matcher.group("title").length());
            } else {
                System.out.println("Access denied!");
            }
        }
    }
}
