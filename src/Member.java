import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Member implements Serializable {
    // Serialization ID
    @Serial
    private static final long serialVersionUID = 2L;

    // Attributes
    private String name;
    private int age;
    private int memberId;
    private List<Book> borrowedBooks = new ArrayList<>();

    // Constructor
    public Member(String name, int age, int memberId) {
        this.name = name;
        this.age = age;
        this.memberId = memberId;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getters
    public String getName() {return this.name;}
    public int getAge() {return this.age;}
    public int getMemberId() {return this.memberId;}
    public List<Book> getBorrowedBooks() {return this.borrowedBooks;}

    // Setters
    public void setName(String name) {this.name = name;}
    public void setAge(int age) {this.age = age;}
    public void setMemberId(int memberId) {this.memberId = memberId;}

    // Other Methods
    public void addBorrowedBook(Book book) {
        this.borrowedBooks.add(book);
    }

    public void removeBorrowedBook(Book book) {
        this.borrowedBooks.remove(book);
    }

    public int getNumberOfBorrowedBooks() {
        return this.borrowedBooks.size();
    }

}
