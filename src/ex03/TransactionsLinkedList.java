package ex03;

import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {
    @Override
    public void addTransaction(Transaction newTransaction) {
        Node tmpTransaction = new Node(newTransaction);
        if (head == null) {
            head = tmpTransaction;
            tail = head;
        } else {
            tail.next = tmpTransaction;
            tmpTransaction.prev = tail;
            tail = tmpTransaction;
            tail.next = null;
        }
        ++size;
    }

    @Override
    public void removeTransaction(UUID transactionId)
            throws TransactionNotFoundException {
        Node current = head;
        for (; current != null; current = current.next) {
            if (current.transaction.getIdentifier() == transactionId) break;
        }
        if (current == null)
            throw new TransactionNotFoundException("Transaction with id "
                    + transactionId + " not found");
        else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
            --size;
        }
    }

    @Override
    public Transaction[] transformToArray() {
        Transaction[] resultArray = new Transaction[size];
        Node current = head;
        for (int i = 0; i < size && current != null; ++i) {
            resultArray[i] = current.transaction;
            current = current.next;
        }
        return resultArray;
    }

    @Override
    public int getSize() {
        return size;
    }

    static class Node {
        public Node(Transaction transaction) {
            this.transaction = transaction;
        }

        Transaction transaction;
        Node next = null;
        Node prev = null;
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;
}
