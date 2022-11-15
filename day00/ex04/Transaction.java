import java.util.UUID;

public class Transaction {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public enum TransferCategory {
        DEBIT,
        CREDIT
    }

    private UUID                id;
    private User                recipient;
    private User                sender;
    private Integer             amount;
    private TransferCategory    category;

    public Transaction(UUID id, User recipient, User sender, Integer amount, TransferCategory category) {
        if ((amount > 0 && category == TransferCategory.CREDIT) ||
                (amount < 0 && category == TransferCategory.DEBIT)) {
            System.err.println(ANSI_RED +
            "Can't create Transaction -> Wrong Transfer Category"
            + ANSI_RESET);
        } else if ((category == TransferCategory.DEBIT && sender.getBalance() < amount) ||
                (category == TransferCategory.CREDIT && sender.getBalance() < -amount)) {
            System.err.println(ANSI_RED +
            "Can't create Transaction -> Insufficient balance"
            + ANSI_RESET);
        } else {
            this.id = id;
            this.recipient = recipient;
            this.sender = sender;
            this.amount = amount;
            this.category = category;
        }
    }

    @Override
    public String toString() {
        String str = "Transaction{ ";

        if (this.category == TransferCategory.DEBIT) {
            str += this.recipient.getName() + " -> " + this.sender.getName() + ", +"
                    + this.amount + ", INCOME, " + this.id + " }";
        } else {
            str += this.sender.getName() + " -> " + this.recipient.getName() + ", "
                    + this.amount + ", OUTCOME, " + this.id + " }";
        }

        return str;
    }

    public UUID getUUID() {
        return this.id;
    }

    public User getRecipient() {
        return this.recipient;
    }

    public User getSender() {
        return this.sender;
    }

    public int getAmount() {
        return this.amount;
    }

    public TransferCategory getTransferCategory() {
        return this.category;
    }
}