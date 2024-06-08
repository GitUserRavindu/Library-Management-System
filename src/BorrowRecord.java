import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public class BorrowRecord implements Serializable {
    // Serialization ID
    @Serial
    private static final long serialVersionUID = 3L;

    // Attributes
    private Book book;
    private Member member;
    private Date borrowDate;
    private Date returnDate;

    // Constructor
    public BorrowRecord(Book book, Member member, Date borrowDate, Date returnDate) {
        this.book = book;
        this.member = member;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    // Getters
    public Book getBook() {return this.book;}
    public Member getMember() {return this.member;}
    public Date getBorrowDate() {return this.borrowDate;}
    public Date getReturnDate() {return this.returnDate;}

    // Setters
    public void setBook(Book book) {this.book = book;}
    public void setMember(Member member) {this.member = member;}
    public void setBorrowDate(Date borrowDate) {this.borrowDate = borrowDate;}
    public void setReturnDate(Date returnDate) {this.returnDate = returnDate;}

}
