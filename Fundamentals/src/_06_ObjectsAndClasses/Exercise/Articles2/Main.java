package _06_ObjectsAndClasses.Exercise.Articles2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Articles> articles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            //("{title}, {content}, {author}   Science, planets, Bill
            String[] inputData = scan.nextLine().split(",\\s+");
            String title = inputData[0];
            String content = inputData[1];
            String author = inputData[2];
            Articles article = new Articles(title, content, author);
            articles.add(article);
        }
        String command = scan.nextLine();
        switch (command) {
            case "title":
                articles.sort(Comparator.comparing(Articles::getTitle));
                break;
            case "content":
                articles.sort(Comparator.comparing(Articles::getContent));
                break;
            case "author":
                articles.sort(Comparator.comparing(Articles::getAuthor));
                break;
        }
        for (Articles article : articles) {
            System.out.println(article);
        }
    }
}
