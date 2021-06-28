package ObjectsAndClasses_Exercise.Articles2;

public class Articles {
    String title;
    String content;
    String author;

    public Articles(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public String toString() {
        return this.title + " -" + this.content + ":" + this.author;
    }
}
