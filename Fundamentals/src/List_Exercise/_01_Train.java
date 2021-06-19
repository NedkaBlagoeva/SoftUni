package List_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01_Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> wagons = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        int capacity = Integer.parseInt(scan.nextLine());
        String command = scan.nextLine();
        while (!command.equals("end")) {
            String[] commandData = command.split("\\s+");
            String commandWord = commandData[0];
            if (commandWord.equals("Add")) {
                int passengers = Integer.parseInt(commandData[1]);
                wagons.add(passengers);
            } else {
                int passengers = Integer.parseInt(commandData[0]);
                for (int i = 0; i < wagons.size(); i++) {
                    if (passengers + wagons.get(i) <= capacity) {
                        wagons.set(i, passengers + wagons.get(i));
                        break;
                    }
                }
            }
            command = scan.nextLine();
        }
        for (Integer wagon : wagons) {
            System.out.print(wagon + " ");
        }
    }
}
