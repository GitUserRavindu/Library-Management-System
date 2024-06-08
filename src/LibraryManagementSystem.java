import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

public class LibraryManagementSystem implements Serializable {
    // Serialization ID
    @Serial
    private static final long serialVersionUID = 4L;

    // Attributes
    public List<Book> bookList;
    public List<Member> memberList;
    public List<BorrowRecord> borrowRecordList;

    // Constructor
    public LibraryManagementSystem() {
        this.bookList = new ArrayList<Book>();
        this.memberList = new ArrayList<>();
        this.borrowRecordList = new ArrayList<>();
    }

    // Books Management
    public void addNewBook(String title, String author, String ISBN) {
        Book newBook = new Book(title, author, ISBN);
        this.bookList.add(newBook);
    }

    public void updateBookInfo(int id, String title, String author, String ISBN) {
        Book book = this.bookList.get(id);
        book.setTitle(title);
        book.setAuthor(author);
        book.setISBN(ISBN);
    }

    public boolean searchBookByISBN(String ISBN) {
        for (Book book : this.bookList) {
            if (book.getISBN().equals(ISBN)) {
                return true;
            }
        }
        return false;
    }

    public int getIndexOfBookByISBN(String ISBN) {
        for (Book book : this.bookList) {
            if (book.getISBN().equals(ISBN)) {
                return bookList.indexOf(book);
            }
        }
        return -1; // Book not found
    }

    public boolean searchBookByTitle(String title) {
        for (Book book : this.bookList) {
            if (book.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    public int getIndexOfBookByTitle(String title) {
        for (Book book : this.bookList) {
            if (book.getTitle().equals(title)) {
                return bookList.indexOf(book);
            }
        }
        return -1;
    }

    // Member Management
    public void addNewMember(String name, int id, int age) {
        Member newMember = new Member(name, age);
        this.memberList.add(newMember);
    }

    public void updateMemberInfo(int id, String name, int age) {
        Member member = this.memberList.get(id);
        member.setName(name);
        member.setAge(age);
    }

    public boolean searchMemberByName(String name) {
        for (Member member : this.memberList) {
            if (member.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public int getIndexOfMemberByName(String name) {
        for (Member member : this.memberList) {
            if (member.getName().equals(name)) {
                return memberList.indexOf(member);
            }
        }
        return -1;
    }

    // Borrowing Books Management
    public void addNewBorrowRecord(String bookTitle, int borrowerID) {
        Member borrower = this.memberList.get(borrowerID);
        Book borrowingBook = this.bookList.get(this.getIndexOfBookByTitle(bookTitle));

        if (borrower.getNumberOfBorrowedBooks() <= 3) {
            if (borrowingBook.isAvailable()) {
                borrowingBook.setAvailable(false);
                borrower.addBorrowedBook(borrowingBook);
                BorrowRecord record = new BorrowRecord(borrowingBook, borrower, LocalDate.now());
                System.out.println("Borrowing Recording has successfully been created.");
                this.borrowRecordList.add(record);
            }
            else {
                System.out.println("The book is already borrowed");
            }
        }
        else {
            System.out.println("You cannot borrow more than 3 books");
        }
        return;
    }

    public void returningBook(int borrowId) {
        BorrowRecord record = this.borrowRecordList.get(borrowId);
        Member borrower = record.getMember();
        Book borrowingBook = record.getBook();

        borrower.removeBorrowedBook(borrowingBook);
        borrowingBook.setAvailable(true);
        record.setReturnDate(LocalDate.now());
    }

    // Display Management
    public void displayBooks() {
        for (Book book : this.bookList) {
            System.out.format("%5d %20s %20s %20s %5b", book.getBookId(), book.getTitle(), book.getAuthor(), book.getISBN(), book.isAvailable());
            System.out.println();
        }
    }

    public void displayMembers() {
        for (Member member : this.memberList) {
            System.out.format("%5d %20s %5d %5d", member.getMemberId(), member.getName(), member.getAge(), member.getNumberOfBorrowedBooks());
            System.out.println();
        }
    }

    public void displayBorrowedRecords() {
        for (BorrowRecord record : this.borrowRecordList) {
            System.out.format("%5d %20s %20s %20s %20s", record.getRecordId(), record.getBook().getTitle(), record.getMember().getName(), record.getBorrowDate(), record.getReturnDate());
            System.out.println();
        }
    }

}
