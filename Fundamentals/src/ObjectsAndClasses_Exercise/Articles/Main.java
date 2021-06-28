package ObjectsAndClasses_Exercise.Articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] articleData = scan.nextLine().split(",");
        Articles article = new Articles(articleData[0], articleData[1], articleData[2]);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            // "Edit: {new content}"; "ChangeAuthor: {new author}"; "Rename: {new title}"
            String[] command = scan.nextLine().split(":");
            switch (command[0]) {
                case "Edit":
                    article.edit(command[1]);
                    break;
                case "ChangeAuthor":
                    article.changeAuthor(command[1]);
                    break;
                case "Rename":
                    article.rename(command[1]);
                    break;
            }
        }
        System.out.println(article);
    }
}
