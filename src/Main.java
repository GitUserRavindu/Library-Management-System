public class Main {

    public static void main(String[] args) {
        System.out.println("Library Management System");

        LibraryManagementSystem lms = new LibraryManagementSystem();

        lms.addNewBook("TestingTitle1", "TestingAuthor1", "ISBN01");
        lms.addNewBook("TestingTitle2", "TestingAuthor2", "ISBN02");
        lms.addNewBook("TestingTitle3", "TestingAuthor3", "ISBN03");

        lms.addNewMember("TestingMember1", 18);
        lms.addNewMember("TestingMember2", 18);
        lms.addNewMember("TestingMember3", 18);

        lms.displayBooks();
        lms.displayMembers();

        lms.addNewBorrowRecord("TestingTitle1", 2);
        lms.addNewBorrowRecord("TestingTitle2", 2);
        lms.addNewBorrowRecord("TestingTitle2", 2);

        lms.displayBooks();
        lms.displayMembers();
        lms.displayBorrowedRecords();

        lms.returningBook(1);

        lms.displayBooks();
        lms.displayMembers();
        lms.displayBorrowedRecords();
    }
}
