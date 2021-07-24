package _09_TextProcessing.Exercises;

import java.util.Scanner;

public class _03_ExtractFile {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] directories = scan.nextLine().split("\\\\");
        String lastElement = directories[directories.length - 1];
        System.out.println("File name: " + lastElement.split("\\.")[0]);
        System.out.println("File extension: " + lastElement.split("\\.")[1]);
    }
}
