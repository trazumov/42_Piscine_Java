public class User {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    private Integer id;
    private String name;
    private Integer balance;
    private TransactionsList list;

    public User(String name, int balance) {
        this.name = name;

        if (balance < 0) {
            this.balance = 0;
            System.err.println(ANSI_RED + 
            "Incorrect balance: " + balance + " for user: " + name
            + ANSI_RESET);
        } else {
            this.balance = balance;
        }
        this.id = UserIdsGenerator.getInstance().generateId();
        this.list = new TransactionsLinkedList();
    }

    @Override
    public String toString() {
        return ANSI_YELLOW + "User{ id=" + this.id +
                ", name='" + this.name + "\'" +
                ", balance=" + this.balance + " }" + ANSI_RESET;
    }

    public  String    getName() {
        return this.name;
    }

    public  int     getId() {
        return this.id;
    }

    public  int     getBalance() {
        return this.balance;
    }

    public void	setBalance(Integer balance) {
        if (balance < 0) {
            System.err.println(ANSI_RED +
            "Can't set negative balance for " + this.getName()
            + ANSI_RESET);
        } else {
            this.balance = balance;
        }
    }

    public TransactionsList getList() {
        return list;
    }
}
