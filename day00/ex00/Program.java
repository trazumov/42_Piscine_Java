import java.util.UUID;

public class Program {
    private static Integer userId = 0;

    public static void main(String[] args) {
        Integer amount = 100;
        User Bob = new User("Bob", 1000, userId++);
        User Nick = new User("Nick", 1000, userId++);
		System.out.println("Users data: " + "\n\t" + Bob + "\n\t" + Nick);

        Transaction.TransferCategory debit = Transaction.TransferCategory.DEBIT;
        Transaction.TransferCategory credit = Transaction.TransferCategory.CREDIT;
        UUID id = UUID.randomUUID();

        Transaction trDebit1 = new Transaction(id, Bob, Nick, amount, debit);
        Transaction trCredit1 = new Transaction(id, Bob, Nick, -amount, credit);

        if (isValid(trDebit1) && isValid(trCredit1)) {
            Bob.setBalance(Bob.getBalance() + amount);
            Nick.setBalance(Nick.getBalance() - amount);
        }
		System.out.println(trDebit1);
        System.out.println(trCredit1);
        System.out.println("Users data: " + "\n\t" + Bob + "\n\t" + Nick);

        System.out.println("\nINCORRECT CASES:");
        id = UUID.randomUUID();
        Transaction trFault1 = new Transaction(id, Bob, Nick, amount, credit);
        Transaction trFault2 = new Transaction(id, Bob, Nick, 2000, debit);
        Nick.setBalance(Nick.getBalance() - 2000);
        User Jessy = new User("Jessy", -1, userId++);
		System.out.println("Users data: " + "\n\t" + Bob + "\n\t" + Nick + "\n\t" + Jessy);
    }

    public static boolean isValid(Transaction transaction) {
        if (transaction.getUUID() != null) {
            return true;
        }
        return false;
    }
}