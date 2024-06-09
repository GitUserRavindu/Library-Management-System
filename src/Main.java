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
