
import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    private Node    _head;
    private Node    _last;
    private int     _size;

    private static class Node {
        Transaction data;
        Node        next;
        Node        prev;

        Node(Node prev, Transaction data, Node next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    public TransactionsLinkedList() {}

    public boolean add(Transaction data) {
        final Node last = _last;
        final Node newNode = new Node(last, data, null);
        _last = newNode;

        if (last == null) {
            _head = newNode;
        } else {
            last.next = newNode;
        }
        _size++;

        return true;
    }

    public boolean remove(UUID id) {
        if (id == null) {
            throw new TransactionNotFoundException("Transaction with 'null' UUID can't be removed");
        }

        for (Node tmp = _head; tmp != null; tmp = tmp.next) {
            if (tmp.data != null && id.equals(tmp.data.getUUID())) {
                System.out.println(ANSI_GREEN + "Removed transaction -> " + tmp.data + ANSI_RESET);
                unlink(tmp);
                return true;
            }
        }
        throw new TransactionNotFoundException("Transaction with UUID: " + id + " not found.");
    }

    private void unlink(Node tmp) {
        final Node next = tmp.next;
        final Node prev = tmp.prev;

        if (prev == null) {
            this._head = next;
        } else {
            prev.next = next;
            tmp.prev = null;
        }

        if (next == null) {
            this._last = prev;
        } else {
            next.prev = prev;
            tmp.next = null;
        }

        tmp.data = null;
        _size--;
    }

    public Transaction[]    toArray() {
        if (this._size == 0) {
            return null;
        }
        Transaction[] result = new Transaction[this._size];
        
        int i = 0;
        for (Node tmp = _head; tmp != null; tmp = tmp.next) {
            result[i++] = tmp.data;
        }

        return result;
    }

    @Override
    public String toString() {
        String str = ANSI_PURPLE + "TransactionsList:" +
                "size: " + this._size + "\n" + ANSI_RESET;

        for (Node tmp = _head; tmp != null; tmp = tmp.next) {
            str += ANSI_PURPLE + "\t" + tmp.data + "\n" + ANSI_RESET;
        }

        return str;
    }
}