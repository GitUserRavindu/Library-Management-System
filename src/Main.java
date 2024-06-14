import utilities.ScannerUtil;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Library Management System - v0.1.0");

        Scanner sc = ScannerUtil.scanner();
        LibraryManagementSystem lms = new LibraryManagementSystem();

        // Prompting for library data loading.
        while (true) {
            System.out.println();
            System.out.println("Do you want to load library data? (y/n)");
            String line = sc.nextLine();

            if (line.equalsIgnoreCase("y")) {
                System.out.println("Loading...");
                int result = lms.loadLibraryData();
                if (result == -1) {
                    System.out.println("Library Data Load Failed. No saved data was found.");
                }
                else {
                    System.out.println("Library Data Loaded Successfully");
                }
                System.out.println("Proceeding to the main menu...");
                break;
            }
            else if (line.equalsIgnoreCase("n")) {
                System.out.println("Library data is not loaded. Proceeding to the main menu...");
                break;
            }
            else {
                System.out.println("Invalid input. Please try again.");
            }
        }

        // Main System.
        while (true) {
            Menu.MainMenu();
            int state = Menu.MainMenuHandler(lms);
            if (state == -1) {
                break;
            }
        }

        while (true) {
            System.out.println();
            System.out.println("Do you want to save the library data? (y/n)");
            String line = sc.nextLine();

            if (line.equalsIgnoreCase("y")) {
                System.out.println("Saving...");
                int result = lms.saveLibraryData();
                if (result == -1) {
                    System.out.println("Library Data Saving Failed.");
                }
                else {
                    System.out.println("Library Data is saved Successfully");
                }
                System.out.println("Proceeding...");
                break;
            }
            else if (line.equalsIgnoreCase("n")) {
                System.out.println("Library data is not saved. Proceeding...");
                break;
            }
            else {
                System.out.println("Invalid input. Please try again.");
            }
        }

        System.out.println();
        System.out.println("Closing the Library Management System...");
        System.out.println("Have a nice day!");
        System.out.println();
        sc.close();
    }
}

// Need to delete members and books. BUt if so, need to do something for borrow record display. Or
// Maybe I can delete the borrow records after books returned or delete the corresponding
// records if member/book deleted
// or implement another method to store history with borrower name only, without storing Member object.
// then, deleting the member has no effect on displaying borrow record db.
// Need to improve line spaces
// Need to add exit in any moment