package _FinalExam._02_FinalExam;

import java.util.Scanner;

public class _01_WorldTour {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder inputStops = new StringBuilder(scan.nextLine());
        String commands = scan.nextLine();
        while (!"Travel".equals(commands)) {
            String[] tokens = commands.split(":");
            String command = tokens[0];
            switch (command) {
                case "Add Stop":
                    //•	Add Stop:{index}:{string}
                    int index = Integer.parseInt(tokens[1]);
                    String newStop = tokens[2];
                    if (isValidIndex(index, inputStops)) {
                        inputStops.insert(index, newStop);
                    }
                    System.out.println(inputStops);
                    break;
                case "Remove Stop":
                    //•	Remove Stop:{start_index}:{end_index}
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);

                    if (isValidIndex(startIndex, inputStops) && isValidIndex(endIndex, inputStops)) {
                        inputStops.delete(startIndex, endIndex + 1);
                    }
                    System.out.println(inputStops);
                    break;
                case "Switch":
                    //•	Switch:{old_string}:{new_string}
                    String oldString = tokens[1];
                    String newString = tokens[2];
                    String destinations = inputStops.toString();
                    destinations = destinations.replaceAll(oldString, newString);
                    inputStops = new StringBuilder(destinations);
                    System.out.println(inputStops);
                    break;
                default:
                    break;
            }
            commands = scan.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s", inputStops);
    }

    public static boolean isValidIndex(int index, StringBuilder text) {
        return index >= 0 && index < text.length();
    }
}
