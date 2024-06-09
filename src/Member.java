import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Member implements Serializable {
    // Serialization ID
    @Serial
    private static final long serialVersionUID = 2L;

    private static int memberCount = 0;

    // Attributes
    private String name;
    private int age;
    private int memberId;
    private List<Book> borrowedBooks;

    // Constructor
    public Member(String name, int age) {
        this.name = name;
        this.age = age;
        this.borrowedBooks = new ArrayList<>();
        this.memberId = memberCount;
        memberCount++;
    }

    // Getters
    public String getName() {return this.name;}
    public int getAge() {return this.age;}
    public int getMemberId() {return this.memberId;}
    public List<Book> getBorrowedBooks() {return this.borrowedBooks;}
    public int getMemberCount() {return Member.memberCount;}

    // Setters
    public void setName(String name) {this.name = name;}
    public void setAge(int age) {this.age = age;}
    public void setMemberId(int memberId) {this.memberId = memberId;}
    public static void setMemberCount(int memberCount) {Member.memberCount = memberCount;}

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

    public void memberDetails() {
        System.out.println("MemberId: " + this.memberId);
        System.out.println("Member: " + this.name);
        System.out.println("Age: " + this.age);

        System.out.print("Borrowed Books: [");
        for (Book book : this.borrowedBooks) {
            System.out.print(book.getTitle() + ", ");
        }
        System.out.println("]");
        System.out.println();
    }

    // Maybe we can add borrow history.
}
