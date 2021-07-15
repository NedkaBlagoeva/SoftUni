package _03_Arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _09_KaminoFactoryNo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int length = Integer.parseInt(scan.nextLine());
        String input = scan.nextLine();
        int bestSequenceIndex = 0;
        int bestSequenceSum = 0;
        int[] finalSequence = new int[length];
        while (!input.equals("Clone them!")) {
            int[] sequence = Arrays.stream(input.split("!")).mapToInt(Integer::parseInt).toArray();
            int sum = 0;
            int sequenceIn = 1;
            int bestSequence = 0;

            for (int i : sequence) {
                if (i == 1) {
                    sum++;
                }
            }

            for (int i = 0; i < sequence.length - 1; i++) {
                if (sequence[i] == sequence[i + 1]) {
                    sequenceIn++;
                } else {
                    sequenceIn = 0;
                }

                if (sequenceIn > bestSequence) {
                    bestSequence = sequenceIn;
                    bestSequenceIndex = i - sequenceIn + 2;
                    finalSequence = sequence;
                    bestSequenceSum = sum;
                } else if (sequenceIn == bestSequence && sum > bestSequenceSum) {

                }
            }
            input = scan.nextLine();
        }
        System.out.printf("Best DNA sample %d with sum: %d.%n", bestSequenceIndex, bestSequenceSum);
        for (int i : finalSequence) {
            System.out.print(i + " ");
        }
    }
}
