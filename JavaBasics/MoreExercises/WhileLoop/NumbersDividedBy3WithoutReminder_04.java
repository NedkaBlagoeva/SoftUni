package MoreExercises.WhileLoop;

public class NumbersDividedBy3WithoutReminder_04 {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            if (i%3 == 0){
                System.out.println(i);
            }
        }
    }
}
