package FinalExam._01_FinalExamRetake;

import java.util.Scanner;

public class _01_TheImitationGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String message = scan.nextLine();
        String commands = scan.nextLine();
        while (!"Decode".equals(commands)) {
            String[] tokens = commands.split("\\|");
            String command = tokens[0];
            switch (command) {
                case "Move":
                    int numberOfLetters = Integer.parseInt(tokens[1]);
                    StringBuilder rotate = new StringBuilder(message);
                    for (int i = 0; i < numberOfLetters; i++) {
                        rotate.append(rotate.charAt(0));
                        rotate.deleteCharAt(0);
                    }
                    message = rotate.toString();
                    rotate.setLength(0);
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[1]);
                    String valueToInsert = tokens[2];
                    StringBuilder builderToInsert = new StringBuilder(message);
                    builderToInsert.insert(index, valueToInsert);
                    message = builderToInsert.toString();
                    builderToInsert.setLength(0);
                    break;
                case "ChangeAll":
                    String oldString = tokens[1];
                    String newString = tokens[2];
                    message = message.replace(oldString, newString);
                    break;
                default:
                    break;
            }
            commands = scan.nextLine();
        }
        System.out.printf("The decrypted message is: %s", message);
    }
}
