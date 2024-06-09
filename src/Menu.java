import utilities.ScannerUtil;
import java.util.Scanner;

public class Menu {
    public static void MainMenu() {
        System.out.println();
        System.out.println("------------------------------------");
        System.out.println("Welcome to Library Management System");
        System.out.println("------------------------------------");
        System.out.println("What do you want to do?");
        System.out.println();
        System.out.println("1. Add a new book");
        System.out.println("2. Update an existing book information");
        System.out.println("3. Search for a book by Title");
        System.out.println("4. Search for a book by ISBN");
        System.out.println("5. Display book database");
        System.out.println();
        System.out.println("6. Register a new member");
        System.out.println("7. Update an existing member");
        System.out.println("8. Search for a member by name");
        System.out.println("9. Display Member Database");
        System.out.println();
        System.out.println("10. Add a new borrowing record");
        System.out.println("11. Returning a borrowed book");
        System.out.println("12. Display Borrowed Book Database");
        System.out.println();
        System.out.println("13. Exit");
        System.out.println("------------------------------------");
    }

    public static int MainMenuHandler(LibraryManagementSystem lms) {
        Scanner sc = ScannerUtil.scanner();
        int choice = sc.nextInt();
        sc.nextLine();
        System.out.println();

        switch (choice) {
            case 1: {
                System.out.println("You have selected to Add a New Book");
                System.out.println("Please enter the following details of the new book");
                System.out.println("Book Title : ");
                String title = sc.nextLine();
                System.out.println("Book Author : ");
                String author = sc.nextLine();
                System.out.println("Book ISBN : ");
                String isbn = sc.nextLine();
                lms.addNewBook(title, author, isbn);
                break;
            }
            case 2: {
                System.out.println("You have selected to Update an Existing Book Information");
                System.out.println("How do you want find the book in the database?");
                System.out.println("1. I have the book ID");
                System.out.println("2. I have the book Title");
                System.out.println("3. I have the book ISBN");

                int subChoice = sc.nextInt();
                sc.nextLine();
                System.out.println();
                int index;

                switch (subChoice) {
                    case 1: {
                        System.out.println("Enter the book ID: ");
                        index = sc.nextInt(); // Need to handle wrong inputs
                        sc.nextLine();
                        System.out.println();
                        String[] updatedDetails = Menu.UpdatedBookInformation();
                        lms.updateBookInfo(index, updatedDetails[0], updatedDetails[1], updatedDetails[2]);
                        break;
                    }
                    case 2: {
                        System.out.println("Enter the book Title: ");
                        String title = sc.nextLine();
                        index = lms.searchBookByTitle(title);
                        if (index == -1) {
                            System.out.println("Please try again.");
                            break;
                        }
                        String[] updatedDetails = Menu.UpdatedBookInformation();
                        lms.updateBookInfo(index, updatedDetails[0], updatedDetails[1], updatedDetails[2]);
                        break;
                    }
                    case 3: {
                        System.out.println("Enter the book ISBN: ");
                        String isbn = sc.nextLine();
                        index = lms.searchBookByISBN(isbn);
                        if (index == -1) {
                            System.out.println("Please try again.");
                        }
                        else {
                            String[] updatedDetails = Menu.UpdatedBookInformation();
                            lms.updateBookInfo(index, updatedDetails[0], updatedDetails[1], updatedDetails[2]);
                        }
                        break;
                    }
                    default: {
                        System.out.println("Invalid choice. Please try again later.");
                        break;
                    }
                }
                break;
            }
            case 3: {
                System.out.println("You have selected to search for a book by title");
                System.out.println("Enter the book title : ");
                String title = sc.nextLine();
                lms.searchBookByTitle(title);
                break;
            }
            case 4: {
                System.out.println("You have selected to search for a book by ISBN");
                System.out.println("Enter the book ISBN : ");
                String isbn = sc.nextLine();
                lms.searchBookByISBN(isbn);
                break;
            }
            case 5: {
                System.out.println("You have selected to display the books database.");
                lms.displayBooks();
                break;
            }
            case 6: {
                System.out.println("You have selected to register a new member");
                System.out.println("Please enter the following details of the new member");
                System.out.println("Member Name : ");
                String name = sc.nextLine();
                System.out.println("Member Age : ");
                int age = sc.nextInt();
                sc.nextLine();
                lms.addNewMember(name, age);
                break;
            }
            case 7: {
                System.out.println("You have selected to update a member information");
                System.out.println("How do you want to find the member in the database?");
                System.out.println("1. I have the member ID");
                System.out.println("2. I have the member Name");

                int subChoice = sc.nextInt();
                sc.nextLine();
                System.out.println();
                int index;

                switch (subChoice) {
                    case 1: {
                        System.out.println("Enter the member ID : ");
                        index = sc.nextInt();
                        sc.nextLine();
                        System.out.println();
                        String[] updatedDetails = Menu.UpdatedMemberInformation();
                        lms.updateMemberInfo(index, updatedDetails[0], Integer.parseInt(updatedDetails[1]));
                        break;
                    }
                    case 2: {
                        System.out.println("Enter the Member Name: ");
                        String name = sc.nextLine();
                        index = lms.searchMemberByName(name);
                        if (index == -1) {
                            System.out.println("Please try again.");
                        }
                        else {
                            String[] updatedDetails = Menu.UpdatedMemberInformation();
                            lms.updateMemberInfo(index, updatedDetails[0], Integer.parseInt(updatedDetails[1]));
                        }
                        break;
                    }
                    default: {
                        System.out.println("Invalid choice. Please try again later.");
                    }
                }
                break;
            }
            case 8: {
                System.out.println("You have selected to search for a member by name");
                System.out.println("Enter the name : ");
                String name = sc.nextLine();
                lms.searchMemberByName(name);
                break;
            }
            case 9: {
                System.out.println("You have selected to display the member database.");
                lms.displayMembers();
                break;
            }
            case 10: {
                System.out.println("You have selected to enter a new borrowing record");
                System.out.println("Please enter the following details");
                System.out.println("Book ID : ");
                int bookId = sc.nextInt();
                sc.nextLine();
                System.out.println("Borrower ID : ");
                int memberId = sc.nextInt();
                sc.nextLine();
                lms.addNewBorrowRecord(bookId, memberId);
                break;
            }
            case 11: {
                System.out.println("You have selected to return a borrowed book");
                System.out.println("Enter the borrow record ID : ");
                int id = sc.nextInt();
                sc.nextLine();
                lms.returningBook(id);
                break;
            }
            case 12: {
                System.out.println("You have selected to display the borrowed book database.");
                lms.displayBorrowedRecords();
                break;
            }
            case 13: {
                System.out.println("You have selected to exit");
                return -1;
            }
            default: {
                System.out.println("Invalid choice. Try again later.");
                break;
            }
        }
        return 0;
    }

    public static String[] UpdatedBookInformation() {
        System.out.println();
        Scanner sc = ScannerUtil.scanner();
        System.out.println("Enter the updated book title: ");
        String title = sc.nextLine();
        System.out.println("Enter the updated book author: ");
        String author = sc.nextLine();
        System.out.println("Enter the updated book isbn: ");
        String isbn = sc.nextLine();
        return new String[]{title, author, isbn};
    }

    public static String[] UpdatedMemberInformation() {
        System.out.println();
        Scanner sc = ScannerUtil.scanner();
        System.out.println("Enter the updated member name : ");
        String name = sc.nextLine();
        System.out.println("Enter the updated member age : ");
        String age = sc.nextLine();
        return new String[]{name, age};
    }
}