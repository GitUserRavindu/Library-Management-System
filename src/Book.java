import java.io.Serial;
import java.io.Serializable;

public class Book implements Serializable {
    // Serialization UID
    @Serial
    private static final long serialVersionUID = 1L;

    private static int bookCount = 0;

    // Attributes
    private int bookId;
    private String title;
    private String author;
    private String ISBN;
    private boolean available;

    // Constructor
    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.available = true;
        this.bookId = bookCount;
        bookCount++;
    }

    // Getters
    public String getTitle() { return this.title;}
    public String getAuthor() { return this.author;}
    public String getISBN() { return this.ISBN;}
    public boolean isAvailable() { return this.available;}
    public int getBookId() { return this.bookId;}
    public static int getBookCount() { return Book.bookCount;}

    // Setters
    public void setTitle(String title) { this.title = title;}
    public void setAuthor(String author) { this.author = author;}
    public void setISBN(String ISBN) { this.ISBN = ISBN;}
    public void setAvailable(boolean available) { this.available = available;}
    public void setBookId(int bookId) { this.bookId = bookId;}
    public static void setBookCount(int bookCount) { Book.bookCount = bookCount;}

    // Book Details display
    public void bookDetails() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + ISBN);
        System.out.println("Available: " + available);
    }

}
