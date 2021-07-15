package _02_DataTypesAndVariables.Ex;

import java.util.Scanner;

public class _03_Elevator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //the number of people n and the capacity p
        int people = Integer.parseInt(scan.nextLine());
        int capacity = Integer.parseInt(scan.nextLine());
        int courses = 0;
        if (people % capacity != 0) {
            courses = people / capacity + 1;
        } else {
            courses = people / capacity;
        }

        System.out.println(courses);
    }
}
