import java.util.UUID;
import java.util.jar.Attributes.Name;

public class Program {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        User User1 = new User("User1", 1000);
        User User2 = new User("User2", 1000);
        User User3 = new User("User3", 500);
        User User4 = new User("User4", 670);
        UsersList usersList = new UsersArrayList();
        System.out.println(usersList);

        usersList.addUser(User1);
        usersList.addUser(User2);
        usersList.addUser(User3);
        usersList.addUser(User4);
        System.out.println(ANSI_GREEN + usersList + ANSI_RESET);

        for (int i = 5; i < 10; i++) {
            usersList.addUser(new User("User" + i, 1000));
        }
        System.out.println(ANSI_GREEN + usersList + ANSI_RESET);

        System.out.println("\t + Number of users - " + usersList.numberOfUsers());
        System.out.println("\t + Get by id 7 - " + usersList.retrieveByID(7));
        System.out.println("\t + Get by index 5 - " + usersList.retrieveByIndex(5));

        System.out.println(ANSI_RED + "\nINCORRECT CASES:" + ANSI_RESET);
        try {
            System.out.println("Try to get User with non existing index: 14");
            usersList.retrieveByIndex(14);
        } catch (RuntimeException e) {
            System.out.println(ANSI_RED + e.getMessage() + ANSI_RESET);
        }

        try {
            System.out.println("Try to get User with non existing ID: 15");
            usersList.retrieveByID(15);
        } catch (RuntimeException e) {
            System.out.println(ANSI_RED + e.getMessage() + ANSI_RESET);
        }

        try {
            System.out.println("Try to add existing User: test3");
            usersList.addUser(User3);
        } catch (RuntimeException e) {
            System.out.println(ANSI_RED + e.getMessage() + ANSI_RESET);
        }
    }
}