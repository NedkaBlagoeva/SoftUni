package _08_MapsLambdaAndStreamAPI.Exercise;

import java.util.*;

public class _07_StudentAcademy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, List<Double>> studentGrades = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String studentName = scan.nextLine();
            double grade = Double.parseDouble(scan.nextLine());
            studentGrades.putIfAbsent(studentName, new ArrayList<>());
            studentGrades.get(studentName).add(grade);
        }
        double averageGrade = 0;
        for (Map.Entry<String, List<Double>> entry : studentGrades.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                averageGrade += entry.getValue().get(i);
            }
            averageGrade /= entry.getValue().size();
            entry.getValue().add(0, averageGrade);
            averageGrade = 0;
        }
        studentGrades
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().get(0) >= 4.5)
                .sorted((g1, g2) -> Double.compare(g2.getValue().get(0), g1.getValue().get(0)))
                .forEach(entry -> System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue().get(0)));
    }
}