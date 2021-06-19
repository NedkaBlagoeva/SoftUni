package List_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _02_ChangeList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        String command = scan.nextLine();
        while (!command.equals("end")){
            String [] commandData = command.split("\\s+");
            String commandWord = commandData[0];
            switch (commandWord){
                case "Delete":
                    int elementToDelete = Integer.parseInt(commandData[1]);
                    for (int i = 0; i < numbers.size(); i++) {
                        numbers.remove(Integer.valueOf(elementToDelete));
                    }
                    break;
                case "Insert":
                    int elementToInsert = Integer.parseInt(commandData[1]);
                    int position = Integer.parseInt(commandData[2]);
                    numbers.add(position, elementToInsert);
                    break;
            }
            command = scan.nextLine();
        }
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}
