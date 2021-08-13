package FinalExam._03_FinalExamRetake;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _01_SecretChat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String message = scan.nextLine();
        String instructions = scan.nextLine();
        while (!"Reveal".equals(instructions)) {
            String[] tokens = instructions.split(":\\|:");
            String command = tokens[0];
            switch (command) {
                case "InsertSpace":
                    int index = Integer.parseInt(tokens[1]);
                    StringBuilder toInsert = new StringBuilder(message);
                    toInsert.insert(index, " ");
                    message = toInsert.toString();
                    System.out.println(message);
                    break;
                case "Reverse":
                    StringBuilder substring = new StringBuilder(tokens[1]);
                    if (message.contains(substring)) {
//                        String temp1 = message.substring(0, message.indexOf(substring.toString()));
//                        String temp2 = message.substring(message.indexOf(substring.toString()) + substring.length());
//                        message = temp1 + temp2;

                        message = message.replaceFirst(Pattern.quote(substring.toString()),
                                Matcher.quoteReplacement(""));
                        message = message.concat(substring.reverse().toString());
                        System.out.println(message);
                    } else {
                        System.out.println("error");
                    }

                    break;
                case "ChangeAll":
                    String oldString = tokens[1];
                    String newString = tokens[2];
                    if (message.contains(oldString)) {
                        message = message.replace(oldString, newString);
                        System.out.println(message);
                    }
                    break;
                default:
                    break;
            }
            instructions = scan.nextLine();
        }
        System.out.println("You have a new text message: " + message);
    }
}
