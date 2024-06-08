import java.io.Serializable;

public class Book implements Serializable {
    // Serialization UID
    private static final long serialVersionUID = 1L;

    // Attributes
    private String title;
    private String author;
    private String ISBN;

    // Constructor
    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
    }

    // Getters
    public String getTitle() { return this.title;}
    public String getAuthor() { return this.author;}
    public String getISBN() { return this.ISBN;}

    // Setters
    public void setTitle(String title) { this.title = title;}
    public void setAuthor(String author) { this.author = author;}
    public void setISBN(String ISBN) { this.ISBN = ISBN;}

}
