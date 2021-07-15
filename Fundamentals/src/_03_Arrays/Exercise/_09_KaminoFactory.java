package _03_Arrays.Exercise;
import java.util.Arrays;
import java.util.Scanner;

public class _09_KaminoFactory {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        String input = scan.nextLine();

        int masterCounter = 0;
        int bestCounter = 0;
        int bestSequence = 0;
        int bestIndex = 0;
        int bestSum = 0;
        int[] bestDNA = new int[n];

        while (!"Clone them!".equals(input)) {
            int currentSum = 0, currentIndex = Integer.MAX_VALUE, currentSequence = 1;
            int[] currentDNA = Arrays.stream(input.split("!+"))
                    .limit(n).mapToInt(Integer::parseInt).toArray();

            masterCounter++;

            for (int j : currentDNA) {
                if (j == 1) {
                    currentSum++;
                }
            }
            for (int i = 0; i < currentDNA.length - 1; i++) {
                if (currentDNA[i] == currentDNA[i + 1] && currentDNA[i] == 1) {
                    currentSequence++;
                    if (i < currentIndex) {
                        currentIndex = i;
                    }
                }
            }
            if ((currentSequence > bestSequence)
                    || ((currentSequence == bestSequence) && (currentIndex < bestIndex))
                    || ((currentSequence == bestSequence) && (currentIndex == bestIndex) && (currentSum > bestSum))) {
                bestCounter = masterCounter;
                bestSequence = currentSequence;
                bestIndex = currentIndex;
                bestSum = currentSum;
                bestDNA = currentDNA;
            }
            input = scan.nextLine();
        }
        System.out.printf("Best DNA sample %d with sum: %d.%n", bestCounter, bestSum);
        for (int i : bestDNA) {
            System.out.print(i + " ");
        }
    }
}