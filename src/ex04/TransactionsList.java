package ex04;

import java.util.UUID;

public interface TransactionsList {
    public void addTransaction(Transaction newTransaction);

    public void removeTransaction(UUID transactionId)
            throws TransactionNotFoundException;

    public Transaction[] transformToArray();

    public int getSize();
}
