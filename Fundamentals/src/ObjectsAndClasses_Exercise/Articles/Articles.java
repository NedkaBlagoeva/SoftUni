package ObjectsAndClasses_Exercise.Articles;

public class Articles {
    String title;
    String content;
    String author;

    public Articles(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void edit(String newContent) {
        this.content = newContent;
    }

    public void changeAuthor(String newAuthor) {
        this.author = newAuthor;
    }

    public void rename(String newTitle) {
        this.title = newTitle;
    }

    public String toString() {
        return this.title + " -" + this.content + ":" + this.author;
    }
}
