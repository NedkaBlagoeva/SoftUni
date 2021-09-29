package _05_FunctionalProgramming.Lab;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _05_FilterByAge {
    public static class Person {
        private final String name;
        private final int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Person> personList = IntStream.range(0, n).mapToObj(ignored -> {
            String[] tokens = scan.nextLine().split(", ");
            return new Person(tokens[0], Integer.parseInt(tokens[1]));
        }).collect(Collectors.toList());

        String condition = scan.nextLine();
        int ageLimit = Integer.parseInt(scan.nextLine());
        String[] printFormat = scan.nextLine().split("\\s+");

        Predicate<Person> filter = getFilter(condition, ageLimit);
        Consumer<Person> print = getPrint(printFormat);

        personList.stream().filter(filter).forEach(print);

    }

    private static Predicate<Person> getFilter(String condition, int ageLimit) {
        return condition.equals("older")
                ? person -> person.age >= ageLimit
                : person -> person.age <= ageLimit;
    }

    private static Consumer<Person> getPrint(String[] printFormat) {
        if (printFormat.length == 2) {
            return person -> System.out.printf("%s - %d%n", person.name, person.age);
        } else if (printFormat[0].equals("name")) {
            return person -> System.out.println(person.name);
        }
        return person -> System.out.println(person.age);

    }
}
