import java.util.UUID;

public class TransactionsService {
    private UsersList usersList;

    public TransactionsService() {
        usersList = new UsersArrayList();
    }

    public void addUser(User user) {
        usersList.addUser(user);
    }

    public int getBalanceByUserId(int id) {
        User user = usersList.retrieveByID(id);
        return user.getBalance();
    }

    public void createTransaction(int recipientId, int senderId, int amount) {
        if (amount <= 0) {
            throw new IllegalTransactionException("Amount can't be negative or equal to zero");
        }

        User recipient = usersList.retrieveByID(recipientId);
        User sender = usersList.retrieveByID(senderId);
        performTransfer(recipient, sender, amount);
    }

    private void performTransfer(User recipient, User sender, int amount) {
        Transaction.TransferCategory debit = Transaction.TransferCategory.DEBIT;
        Transaction.TransferCategory credit = Transaction.TransferCategory.CREDIT;

        if (sender.getBalance() >= amount) {
            UUID id = UUID.randomUUID();
            Transaction trDebit = new Transaction(id, recipient, sender, amount, debit);
            Transaction trCredit = new Transaction(id, recipient, sender, -1 * amount, credit);

            recipient.setBalance(recipient.getBalance() + amount);
            sender.setBalance(sender.getBalance() - amount);

            recipient.getList().add(trDebit);
            sender.getList().add(trCredit);
        } else {
            throw new IllegalTransactionException("Insufficient balance for user: " + sender.getName()
                    + ", balance: " + sender.getBalance());
        }
    }

    public Transaction[] getTransactionsByUserId(int userId) {
        return usersList.retrieveByID(userId).getList().toArray();
    }

    public void removeTransaction(int userId, UUID id) {
        usersList.retrieveByID(userId).getList().remove(id);
    }

    public Transaction[] unpairedTransactions() {
        int start = 0;
        int max = 10;
        Transaction[] result = new Transaction[max];
        int size = usersList.numberOfUsers();

        for (int userIndex = 0; userIndex < size; userIndex++) {
            User user = usersList.retrieveByIndex(userIndex);
            Transaction[] userTransactions = user.getList().toArray();

            for (int j = 0; j < userTransactions.length; j++) {
                if (isUnpaired(userIndex, userTransactions[j].getUUID(), size)) {
                    if (start == max) {
                        max *= 2;
                        Transaction[] tmp = result;
                        result = new Transaction[max];

                        for (int k = 0; k < tmp.length; k++) {
                            result[k] = tmp[k];
                        }
                    }
                    result[start++] = userTransactions[j];
                }
            }
        }
        return modifyArray(start, result);
    }

    private boolean isUnpaired(int index, UUID id, int size) {
        for (int i = 0; i < size; i++) {
            if (index == i) {
                continue;
            }
            User userComp = usersList.retrieveByIndex(i);
            Transaction[] transactions = userComp.getList().toArray();

            for (int j = 0; j < transactions.length; j++) {
                if (id.equals(transactions[j].getUUID())) {
                    return false;
                }
            }
        }
        return true;
    }

    private Transaction[] modifyArray(int max, Transaction[] tmp) {
        Transaction[] result = new Transaction[max];

        for (int i = 0; i < max; i++) {
            result[i] = tmp[i];
        }
        return result;
    }
}
