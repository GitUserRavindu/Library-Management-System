public class Main {

    public static void main(String[] args) {
        System.out.println("Library Management System");

        LibraryManagementSystem lms = new LibraryManagementSystem();

        while (true) {
            Menu.MainMenu();
            int state = Menu.MainMenuHandler(lms);
            if (state == -1) {
                break;
            }
        }
    }
}

// Need to delete members and books. BUt if so, need to do something for borrow record display. Or
// Maybe I can delete the borrow records after books returned or delete the corresponding
// records if member/book deleted

// Maybe implement Search for a member by ID method