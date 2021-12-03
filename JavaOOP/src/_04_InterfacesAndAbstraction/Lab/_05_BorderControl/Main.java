package _04_InterfacesAndAbstraction.Lab._05_BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<Identifiable> identifiableList = new ArrayList<>();
        while (!input.equals("End")) {
            String[] inputTokens = input.split("\\s+");
            if (inputTokens.length == 2) {
                //"{model} {id}"
                String model = inputTokens[0];
                String id = inputTokens[1];

                Identifiable robot = new Robot(model, id);
                identifiableList.add(robot);
            } else {
                // "{name} {age} {id}
                String name = inputTokens[0];
                int age = Integer.parseInt(inputTokens[1]);
                String id = inputTokens[2];

                Identifiable citizen = new Citizen(name, age, id);
                identifiableList.add(citizen);
            }

            input = scan.nextLine();
        }

        String fakeIdsNumber = scan.nextLine();

        identifiableList.stream()
                .filter(id -> id.getId().endsWith(fakeIdsNumber))
                .forEach(id -> System.out.println(id.getId()));
    }
}
