package _06_ObjectsAndClasses.Exercise.OrderByAge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();
        List<Person> people = new ArrayList<>();
        while (!"End".equals(command)){
            String [] commandData = command.split("\\s+");
            String name = commandData[0];
            String ID = commandData[1];
            int age = Integer.parseInt(commandData[2]);;
            Person person = new Person(name, ID, age);
            people.add(person);
            command = scan.nextLine();
        }
        people.sort(Comparator.comparing(Person::getAge));
        for (Person person : people) {
            System.out.println(person);
        }
    }
}
