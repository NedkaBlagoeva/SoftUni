package MoreExercises.ForLoop;

public class Clock_09 {
    public static void main(String[] args) {
        int hours = 0;
        int minutes = -1;
       // int i = 0;
        // while (i < 1440) {
        for (int i = 0; i < 1440; i++) {

            minutes++;
            if (minutes == 60) {
                hours++;
                minutes = 0;
            }
           // i++;
            System.out.printf("%d :% 2d\n",hours,minutes);
        }
    }
}
