package ExamPrep.RetakeExam_14April2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _01_Bouquets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque <Integer> tulipStack = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt).forEach(tulipStack::push);
        ArrayDeque<Integer> daffodilsQueue = scan.nextLine().split()
    }
}
