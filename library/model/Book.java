package library.model;

public class Book {
    // attributes
    private String title;
    private String publisher;
    private String author;

    // constructor
    public Book() {
    }

    public Book(String title, String publisher, String author) {
        this.title = title;
        this.publisher = publisher;
        this.author = author;
    }

    // setter and getter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // get information
    public void getInfo() {
        System.out.println(
                "{\n title: " + this.title + ",\n publisher: " + this.publisher + ",\n author:" + this.author + "}");
    }
}
