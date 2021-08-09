package FinalExam._04_FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02_FancyBarcodes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String regex = "@#+[A-Z][A-Za-z0-9]{4,}[A-Z]@#+";
        Pattern pattern = Pattern.compile(regex);
        for (int i = 0; i < n; i++) {
            String barcode = scan.nextLine();
            Matcher matcher = pattern.matcher(barcode);
            if (matcher.find()) {
                StringBuilder group = new StringBuilder();
                String validBarcode = matcher.group();
                for (int j = 0; j < validBarcode.length(); j++) {
                    if (Character.isDigit(validBarcode.charAt(j))) {
                        group.append(validBarcode.charAt(j));
                    }
                }
                if (group.length() == 0) {
                    System.out.println("Product group: 00");
                } else {
                    System.out.printf("Product group: %s%n", group);
                }
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
