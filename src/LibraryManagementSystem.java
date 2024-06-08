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
        System.out.println("New book added");
        System.out.println();
    }

    public void updateBookInfo(int id, String title, String author, String ISBN) {
        Book book = this.bookList.get(id);
        book.setTitle(title);
        book.setAuthor(author);
        book.setISBN(ISBN);
        System.out.println("Book info updated");
    }

    public boolean searchBookByISBN(String ISBN) {
        for (Book book : this.bookList) {
            if (book.getISBN().equals(ISBN)) {
                System.out.println("Book found");
                book.bookDetails();
                return true;
            }
        }
        System.out.println("Book not found");
        return false;
    }

    public int getIndexOfBookByISBN(String ISBN) {
        for (Book book : this.bookList) {
            if (book.getISBN().equals(ISBN)) {
                int idx = this.bookList.indexOf(book);
                // System.out.println("Book found. Index: " + idx);
                return idx;
            }
        }
        // System.out.println("Book not found");
        return -1; // Book not found
    }

    public boolean searchBookByTitle(String title) {
        for (Book book : this.bookList) {
            if (book.getTitle().equals(title)) {
                System.out.println("Book found");
                book.bookDetails();
                return true;
            }
        }
        System.out.println("Book not found");
        return false;
    }

    public int getIndexOfBookByTitle(String title) {
        for (Book book : this.bookList) {
            if (book.getTitle().equals(title)) {
                int idx = this.bookList.indexOf(book);
                // System.out.println("Book found. Index: " + idx);
                return idx;
            }
        }
        // System.out.println("Book not found");
        return -1;
    }

    // Member Management
    public void addNewMember(String name, int age) {
        Member newMember = new Member(name, age);
        this.memberList.add(newMember);
        System.out.println("New member added");
    }

    public void updateMemberInfo(int id, String name, int age) {
        Member member = this.memberList.get(id);
        member.setName(name);
        member.setAge(age);
        System.out.println("Member info updated");
    }

    public boolean searchMemberByName(String name) {
        for (Member member : this.memberList) {
            if (member.getName().equals(name)) {
                System.out.println("Member found");
                member.memberDetails();
                return true;
            }
        }
        System.out.println("Member not found");
        return false;
    }

    public int getIndexOfMemberByName(String name) {
        for (Member member : this.memberList) {
            if (member.getName().equals(name)) {
                int idx = this.memberList.indexOf(member);
                // System.out.println("Member found. Index: " + idx);
                return idx;
            }
        }
        // System.out.println("Member not found");
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
                System.out.println("Borrowing Record has successfully been created.");
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
        System.out.println("Returning Book has successfully been returned.");
    }

    // Display Management
    public void displayBooks() {
        System.out.println();
        System.out.println("Book list:");
        System.out.format("%5s%20s%20s%20s%20s", "ID", "Title", "Author", "ISBN", "Availability");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------");
        for (Book book : this.bookList) {
            System.out.format("%5d%20s%20s%20s%20b", book.getBookId(), book.getTitle(), book.getAuthor(), book.getISBN(), book.isAvailable());
            System.out.println();
        }
        System.out.println();
    }

    public void displayMembers() {
        System.out.println();
        System.out.println("Member list:");
        System.out.format("%5s%20s%20s%20s", "ID", "Name", "Age", "#BorrowedBooks");
        System.out.println();
        System.out.println("-----------------------------------------------------------------");
        for (Member member : this.memberList) {
            System.out.format("%5d%20s%20d%20d", member.getMemberId(), member.getName(), member.getAge(), member.getNumberOfBorrowedBooks());
            System.out.println();
        }
        System.out.println();
    }

    public void displayBorrowedRecords() {
        System.out.println();
        System.out.println("Borrowed record list:");
        System.out.format("%5s%20s%20s%20s%20s", "ID", "Title", "Borrower", "Borrowed Date", "Returned Date");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------");
        for (BorrowRecord record : this.borrowRecordList) {
            System.out.format("%5d%20s%20s%20s%20s", record.getRecordId(), record.getBook().getTitle(), record.getMember().getName(), record.getBorrowDate(), record.getReturnDate());
            System.out.println();
        }
        System.out.println();
    }

}
