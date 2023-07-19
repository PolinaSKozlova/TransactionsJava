package ex05.Transactions;

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
        if (head.transaction.getIdentifier().equals(transactionId)) {
            head = head.next;
            head.prev = null;
            --size;
            return;
        }
        if (tail.transaction.getIdentifier().equals(transactionId)) {
            tail = tail.prev;
            tail.next = null;
            --size;
            return;
        }
        Node current = head;
        while (current != null) {
            if (current.transaction.getIdentifier().equals(transactionId)) {
                break;
            }
            current = current.next;
        }
        if (current == null) {
            throw new TransactionNotFoundException("Transaction with id "
                    + transactionId + " not found");
        } else {
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
        Node next;
        Node prev;
    }

    private Node head;
    private Node tail;
    private int size = 0;
}
