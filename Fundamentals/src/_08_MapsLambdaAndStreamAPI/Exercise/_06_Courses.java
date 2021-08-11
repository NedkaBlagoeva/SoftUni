package _08_MapsLambdaAndStreamAPI.Exercise;

import java.util.*;

public class _06_Courses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, List<String>> courses = new LinkedHashMap<>();
        while (!"end".equals(input)) {
            String[] tokens = input.split(" : ");
            String courseName = tokens[0];
            String studentName = tokens[1];

            courses.putIfAbsent(courseName, new ArrayList<>());
            courses.get(courseName).add(studentName);
            input = scan.nextLine();
        }
        courses
                .entrySet()
                .stream()
                .sorted((p1, p2) -> Integer.compare(p2.getValue().size(), p1.getValue().size())
                ).forEach(entry -> {
            System.out.println(entry.getKey() + ": " + entry.getValue().size());
            entry.getValue().stream().sorted().forEach(StudentName -> System.out.println("-- " + StudentName));
        });
    }
}