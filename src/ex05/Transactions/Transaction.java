package ex05.Transactions;

import ex05.Users.User;

import java.util.UUID;

public class Transaction {
    public Transaction(User r, User s, float tA)
            throws IllegalTransactionException {
        recipient = r;
        sender = s;
        transferAmount = tA;
        if (transferAmount >= 0) {
            transferCategory = TransferCategory.DEBIT;
            if (sender.getBalance() > Math.abs(tA)) {
                recipient.setBalance(recipient.getBalance() + tA);
                sender.setBalance(sender.getBalance() - tA);
            } else {
                throw new IllegalTransactionException("Sum on the sender " +
                        "balance is not enough for transaction");
            }
        } else {
            transferCategory = TransferCategory.CREDIT;
            if (sender.getBalance() > Math.abs(tA)) {
                recipient.setBalance(recipient.getBalance() - tA);
                sender.setBalance(sender.getBalance() + tA);
            } else {
                throw new IllegalTransactionException("Sum on the sender " +
                        "balance is not enough for transaction");
            }
        }

        identifier = UUID.randomUUID();
    }

    public Transaction(Transaction other) {
        identifier = other.identifier;
        recipient = other.sender;
        sender = other.recipient;
        transferAmount = other.transferAmount * (-1);
        if (other.transferCategory == TransferCategory.DEBIT) {
            transferCategory = TransferCategory.CREDIT;
        } else {
            transferCategory = TransferCategory.DEBIT;
        }
    }

    public void showInfo() {
        System.out.println(identifier + " " + recipient.getName() + " "
                + sender.getName() + " " + transferAmount
                + " " + transferCategory);
    }

    public UUID getIdentifier() {
        return identifier;
    }

    public User getRecipient() {
        return recipient;
    }

    public User getSender() {
        return sender;
    }

    public TransferCategory getTransferCategory() {
        return transferCategory;
    }

    public float getTransferAmount() {
        return transferAmount;
    }

    public enum TransferCategory {
        DEBIT, CREDIT
    }

    private final UUID identifier;
    private User recipient;
    private User sender;
    private TransferCategory transferCategory; //(debits, credits)
    private float transferAmount;
}