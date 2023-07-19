package ex03;

import java.util.UUID;

public class Transaction {
    public Transaction(User r, User s, float tA) {
        recipient = r;
        sender = s;
        transferAmount = tA;
        if (transferAmount >= 0) {
            transferCategory = Transaction.TransferCategory.DEBIT;
            if (sender.getBalance() > Math.abs(tA)) {
                recipient.setBalance(recipient.getBalance() + tA);
                sender.setBalance(sender.getBalance() - tA);
                transferStatus = Transaction.TransferStatus.ACCEPTED;
            } else {
                transferStatus = Transaction.TransferStatus.REFUSED;
            }
        } else {
            transferCategory = Transaction.TransferCategory.CREDIT;
            if (sender.getBalance() > Math.abs(tA)) {
                recipient.setBalance(recipient.getBalance() - tA);
                sender.setBalance(sender.getBalance() + tA);
                transferStatus = Transaction.TransferStatus.ACCEPTED;
            } else {
                transferStatus = Transaction.TransferStatus.REFUSED;
            }
        }
        identifier = UUID.randomUUID();
    }

    public Transaction(Transaction other) {
        identifier = other.identifier;
        recipient = other.sender;
        sender = other.recipient;
        transferAmount = other.transferAmount * (-1);
        if (other.transferCategory == Transaction.TransferCategory.DEBIT) {
            transferCategory = Transaction.TransferCategory.CREDIT;
        } else {
            transferCategory = Transaction.TransferCategory.DEBIT;
        }
        transferStatus = other.transferStatus;

    }

    public void showInfo() {
        System.out.println(identifier + " " + recipient.getName() + " "
                + sender.getName() + " " + transferAmount + " "
                + transferCategory + " " + transferStatus);
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

    public Transaction.TransferCategory getTransferCategory() {
        return transferCategory;
    }

    public Transaction.TransferStatus getTransferStatus() {
        return transferStatus;
    }

    public float getTransferAmount() {
        return transferAmount;
    }

    private enum TransferCategory {
        DEBIT, CREDIT
    }

    private enum TransferStatus {
        REFUSED, ACCEPTED
    }

    private final UUID identifier;
    private User recipient;
    private User sender;
    private TransferCategory transferCategory; //(debits, credits)
    private TransferStatus transferStatus; // (refused, accepted)
    private float transferAmount;
}