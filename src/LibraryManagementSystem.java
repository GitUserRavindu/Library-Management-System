import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class LibraryManagementSystem implements Serializable {
    // Serialization ID
    @Serial
    private static final long serialVersionUID = 4L;

    private static final int MAX_BORROWED_BOOKS = 3;

    // Attributes
    public List<Book> bookList;
    public List<Member> memberList;
    public List<BorrowRecord> borrowRecordList;

    public HashMap<Integer, Book> bookMap;
    public HashMap<Integer, Member> memberMap;
    public HashMap<Integer, BorrowRecord> borrowRecordMap;

    // Constructor
    public LibraryManagementSystem() {
        this.bookList = new ArrayList<>();
        this.memberList = new ArrayList<>();
        this.borrowRecordList = new ArrayList<>();

        this.bookMap = new HashMap<>(); // Map ID with Object
        this.memberMap = new HashMap<>();
        this.borrowRecordMap = new HashMap<>();
    }

    //////// Book Management ////////

    // Add new Book to the database
    public void addNewBook(String title, String author, String ISBN) {
        Book newBook = new Book(title, author, ISBN);
        this.bookList.add(newBook);
        this.bookMap.put(newBook.getBookId(), newBook);
        System.out.println("New book added successfully.");
    }

    // Update the information of an existing book
    public void updateBookInfo(int id, String title, String author, String ISBN) {
        Book book = this.bookMap.get(id);
        book.setTitle(title);
        book.setAuthor(author);
        book.setISBN(ISBN);
        System.out.println("Book info updated successfully.");
    }

    // Search for a book by ISBN. Return the Book ID if found. Otherwise, return -1
    public int searchBookByISBN(String isbn) {
        for (Book book : this.bookList) {
            if (book.getISBN().equals(isbn)) {
                System.out.println("Book found");
                book.bookDetails();
                return book.getBookId();
            }
        }
        System.out.println("Book not found");
        return -1;
    }

    // Search for a book by Title. Return the Book ID if found. Otherwise, return -1
    public int searchBookByTitle(String title) {
        for (Book book : this.bookList) {
            if (book.getTitle().equals(title)) {
                System.out.println("Book found");
                book.bookDetails();
                return book.getBookId();
            }
        }
        System.out.println("Book not found");
        return -1;
    }

    //////// Member Management ////////

    // Add a new member to the database
    public void addNewMember(String name, int age) {
        Member newMember = new Member(name, age);
        this.memberList.add(newMember);
        this.memberMap.put(newMember.getMemberId(), newMember);
        System.out.println("New member added successfully.");
    }

    // Update the information of an existing member
    public void updateMemberInfo(int id, String name, int age) {
        Member member = this.memberMap.get(id);
        member.setName(name);
        member.setAge(age);
        System.out.println("Member information updated successfully.");
    }

    // Search for a member by name. Return the Member ID if found. Otherwise, return -1
    public int searchMemberByName(String name) {
        for (Member member : this.memberList) {
            if (member.getName().equals(name)) {
                System.out.println("Member found");
                member.memberDetails();
                return member.getMemberId();
            }
        }
        System.out.println("Member not found");
        return -1;
    }

    ////////// Borrowing Books Management //////////

    // Add a new borrow record to the database.
    public void addNewBorrowRecord(int bookId, int memberId) {
        Member borrower = this.memberMap.get(memberId);
        Book borrowingBook = this.bookMap.get(bookId);

        if (borrower.getNumberOfBorrowedBooks() <= MAX_BORROWED_BOOKS) {
            if (borrowingBook.isAvailable()) {
                borrowingBook.setAvailable(false);
                borrower.addBorrowedBook(borrowingBook);
                BorrowRecord record = new BorrowRecord(borrowingBook, borrower, LocalDate.now());
                System.out.println("Borrowing Record has been created successfully.");
                this.borrowRecordList.add(record);
                this.borrowRecordMap.put(record.getRecordId(), record);
            }
            else {
                System.out.println("This book is already borrowed by someone. Please come back later.");
            }
        }
        else {
            System.out.println("You cannot borrow more than 3 books. Please come back later.");
        }
    }

    // Handle the returning of borrowed books
    public void returningBook(int borrowRecordId) {
        BorrowRecord record = this.borrowRecordMap.get(borrowRecordId);
        Member borrower = record.getMember();
        Book borrowedBook = record.getBook();

        borrower.removeBorrowedBook(borrowedBook);
        borrowedBook.setAvailable(true);
        record.setReturnDate(LocalDate.now());
        System.out.println("Returning Book has been returned successfully.");
    }

    //////// Database Display Management ////////

    // Book Database Display
    public void displayBooks() {
        System.out.println();
        System.out.println("Library Book Database:");
        System.out.format("%5s%30s%30s%20s%20s", "ID", "Title", "Author", "ISBN", "Availability");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------");
        for (Book book : this.bookList) {
            System.out.format("%5d%30s%30s%20s%20b", book.getBookId(), book.getTitle(), book.getAuthor(), book.getISBN(), book.isAvailable());
            System.out.println();
        }
        System.out.println();
    }

    // Member Database Display
    public void displayMembers() {
        System.out.println();
        System.out.println("Library Member Database:");
        System.out.format("%5s%30s%20s%20s", "ID", "Name", "Age", "# Borrowed Books");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------");
        for (Member member : this.memberList) {
            System.out.format("%5d%30s%20d%20d", member.getMemberId(), member.getName(), member.getAge(), member.getNumberOfBorrowedBooks());
            System.out.println();
        }
        System.out.println();
    }

    // Borrowing Database Display
    public void displayBorrowedRecords() {
        System.out.println();
        System.out.println("Library Borrowed Record Database:");
        System.out.format("%5s%30s%30s%20s%20s", "ID", "Title", "Borrower", "Borrowed Date", "Returned Date");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------");
        for (BorrowRecord record : this.borrowRecordList) {
            System.out.format("%5d%30s%30s%20s%20s", record.getRecordId(), record.getBook().getTitle(), record.getMember().getName(), record.getBorrowDate(), record.getReturnDate());
            System.out.println();
        }
        System.out.println();
    }

}
