package NestedLoops_Lab;

public class Clock_01 {
    public static void main(String[] args) {

        for (int hours = 0; hours <= 23; hours++) {
            for (int minutes = 0; minutes <= 59; minutes++) {
                System.out.printf("%d:%d\n", hours, minutes);
            }
        }
    }
}
