package _08_MapsLambdaAndStreamAPI.Exercise;

import java.util.Scanner;

public class _06_Courses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] strings = scan.nextLine().split(" ");
        String word1 = strings[0];
        String word2 = strings[1];
        String longerWord = "";
        String smallerWord = "";
        int sum = 0;
        if (word1.length() > word2.length()){
            longerWord = word1;
            smallerWord = word2;
        } else {
            longerWord = word2;
            smallerWord = word1;
        }

        for (int i = 0; i < smallerWord.length(); i++) {
            sum += smallerWord.charAt(i) * longerWord.charAt(i);
        }
        String left = longerWord.substring(smallerWord.length());
        for (char letter : left.toCharArray()) {
            sum += letter;
        }
        System.out.println(sum);
    }
}
