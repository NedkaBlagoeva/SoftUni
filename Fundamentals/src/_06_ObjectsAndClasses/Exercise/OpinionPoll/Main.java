package _06_ObjectsAndClasses.Exercise.OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String [] inputData = scan.nextLine().split("\\s+");
            String name = inputData[0];
            int age = Integer.parseInt(inputData[1]);
            Person person = new Person(name, age);
            if (person.getAge() > 30) {
                people.add(person);
            }
        }
        people.sort(Comparator.comparing(Person :: getName));
        for (Person person : people) {
            System.out.println(person.toString());
        }
    }
}
