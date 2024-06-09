import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class BorrowRecord implements Serializable {
    // Serialization ID
    @Serial
    private static final long serialVersionUID = 3L;

    private static int recordCount = 0;

    // Attributes
    private int recordId;
    private Book book;
    private Member member;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    // Constructor
    public BorrowRecord(Book book, Member member, LocalDate borrowDate) {
        this.book = book;
        this.member = member;
        this.borrowDate = borrowDate;
        this.returnDate = null;
        this.recordId = recordCount;
        recordCount++;
    }

    // Getters
    public Book getBook() {return this.book;}
    public Member getMember() {return this.member;}
    public LocalDate getBorrowDate() {return this.borrowDate;}
    public LocalDate getReturnDate() {return this.returnDate;}
    public int getRecordId() {return this.recordId;}
    public int getRecordCount() {return recordCount;}

    // Setters
    public void setBook(Book book) {this.book = book;}
    public void setMember(Member member) {this.member = member;}
    public void setBorrowDate(LocalDate borrowDate) {this.borrowDate = borrowDate;}
    public void setReturnDate(LocalDate returnDate) {this.returnDate = returnDate;}
    public void setRecordId(int recordId) {this.recordId = recordId;}
    public static void setRecordCount(int recordCount) {BorrowRecord.recordCount = recordCount;}

    public void borrowRecordDetails() {
        System.out.println("Borrow record ID: " + this.recordId);
        System.out.println("Borrowed Book: " + this.book);
        System.out.println("Borrower: " + this.member);
        System.out.println("Borrowed Date: " + this.borrowDate);
        System.out.println("Returned Date: " + this.returnDate);
    }

}
