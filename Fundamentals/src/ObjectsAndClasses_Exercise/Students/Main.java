package ObjectsAndClasses_Exercise.Students;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String [] studentData = scan.nextLine().split("\\s+");
            String firstName = studentData[0];
            String lastName = studentData[1];
            double grade = Double.parseDouble(studentData[2]);;
            Student student = new Student(firstName, lastName, grade);
            students.add(student);
        }
        students.sort(Comparator.comparing(Student :: getGrade));
        Collections.reverse(students);
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
