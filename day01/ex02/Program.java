import java.util.UUID;
import java.util.jar.Attributes.Name;

public class Program {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    
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
        System.out.println(usersList);

        for (int i = 5; i < 15; i++) {
            usersList.addUser(new User("User" + i, 1000));
        }
        System.out.println(usersList);

        System.out.println(ANSI_PURPLE + "Number of users - " + usersList.numberOfUsers() + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "Get by id 7 - " + usersList.retrieveByID(7) + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "Get by index 5 - " + usersList.retrieveByIndex(5) + ANSI_RESET);

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