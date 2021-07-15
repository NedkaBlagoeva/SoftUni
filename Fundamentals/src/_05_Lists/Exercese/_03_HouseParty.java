package _05_Lists.Exercese;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _03_HouseParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfCommands = Integer.parseInt(scan.nextLine());
        List<String> guests = new ArrayList<>();
        for (int i = 0; i < numberOfCommands; i++) {
            String command = scan.nextLine();
            String[] commandData = command.split("\\s+");
            if (commandData.length == 3) { // ["name" "is" "going"]
                if (!guests.contains(commandData[0])) {
                    guests.add(commandData[0]);
                } else {
                    System.out.printf("%s is already in the list!%n", commandData[0]);
                }
            } else {
                if (!guests.contains(commandData[0])) {
                    System.out.printf("%s is not in the list!%n", commandData[0]);
                } else {
                    guests.remove(commandData[0]);
                }
            }
        }
        guests.forEach(number -> System.out.println(number + " "));
    }
}
