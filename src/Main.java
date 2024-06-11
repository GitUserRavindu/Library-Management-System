import utilities.ScannerUtil;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Library Management System");

        Scanner sc = ScannerUtil.scanner();
        LibraryManagementSystem lms = new LibraryManagementSystem();

        System.out.println("Do you want to load lib data? (y/n)");
        if (sc.nextLine().toLowerCase().equals("y")) {
            System.out.println("Loading...");
            lms.loadLibraryData();
            System.out.println("Library Data Loaded Successfully");
        }

        while (true) {
            Menu.MainMenu();
            int state = Menu.MainMenuHandler(lms);
            if (state == -1) {
                break;
            }
        }

        System.out.println("Do you want to save library data? (y/n)");
        if (sc.nextLine().toLowerCase().equals("y")) {
            System.out.println("Saving...");
            lms.saveLibraryData();
        }

        sc.close();
    }
}

// Need to delete members and books. BUt if so, need to do something for borrow record display. Or
// Maybe I can delete the borrow records after books returned or delete the corresponding
// records if member/book deleted

// Maybe implement Search for a member by ID method