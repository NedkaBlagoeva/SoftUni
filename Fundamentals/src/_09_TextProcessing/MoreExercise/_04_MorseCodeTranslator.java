package _09_TextProcessing.MoreExercise;

import java.util.Scanner;

public class _04_MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] text = scan.nextLine().split("\\s+");
        StringBuilder decodedMassage = new StringBuilder();
        for (String letter : text) {
            switch (letter) {
                case ".-":
                    decodedMassage.append("A");
                    break;
                case "-...":
                    decodedMassage.append("B");
                    break;
                case "-.-.":
                    decodedMassage.append("C");
                    break;
                case "-..":
                    decodedMassage.append("D");
                    break;
                case ".":
                    decodedMassage.append("E");
                    break;
                case "..-.":
                    decodedMassage.append("F");
                    break;
                case "--.":
                    decodedMassage.append("G");
                    break;
                case "....":
                    decodedMassage.append("H");
                    break;
                case "..":
                    decodedMassage.append("I");
                    break;
                case ".---":
                    decodedMassage.append("J");
                    break;
                case "-.-":
                    decodedMassage.append("K");
                    break;
                case ".-..":
                    decodedMassage.append("L");
                    break;
                case "--":
                    decodedMassage.append("M");
                    break;
                case "-.":
                    decodedMassage.append("N");
                    break;
                case "---":
                    decodedMassage.append("O");
                    break;
                case ".--.":
                    decodedMassage.append("P");
                    break;
                case "--.-":
                    decodedMassage.append("Q");
                    break;
                case ".-.":
                    decodedMassage.append("R");
                    break;
                case "...":
                    decodedMassage.append("S");
                    break;
                case "-":
                    decodedMassage.append("T");
                    break;
                case "..-":
                    decodedMassage.append("U");
                    break;
                case "...-":
                    decodedMassage.append("V");
                    break;
                case ".--":
                    decodedMassage.append("W");
                    break;
                case "-..-":
                    decodedMassage.append("X");
                    break;
                case "-.--":
                    decodedMassage.append("Y");
                    break;
                case "--..":
                    decodedMassage.append("Z");
                    break;
                case "|":
                    decodedMassage.append(" ");
                    break;
                default:
                    break;
            }
        }
        System.out.println(decodedMassage);
    }
}
