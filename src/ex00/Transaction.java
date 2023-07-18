package ex00;

import java.util.UUID;

public class Transaction {
    public Transaction(User r, User s, float tA) {
        recipient = r;
        sender = s;
        transferAmount = tA;
        if (transferAmount >= 0) {
            transferCategory = TransferCategory.DEBIT;
            if (sender.getBalance() > Math.abs(tA)) {
                recipient.setBalance(recipient.getBalance() + tA);
                sender.setBalance(sender.getBalance() - tA);
                transferStatus = TransferStatus.ACCEPTED;
            } else {
                transferStatus = TransferStatus.REFUSED;
            }
        } else {
            transferCategory = TransferCategory.CREDIT;
            if (sender.getBalance() > Math.abs(tA)) {
                recipient.setBalance(recipient.getBalance() - tA);
                sender.setBalance(sender.getBalance() + tA);
                transferStatus = TransferStatus.ACCEPTED;
            } else {
                transferStatus = TransferStatus.REFUSED;
            }
        }
        identifier = UUID.randomUUID();
    }

    public Transaction(Transaction other) {
        identifier = other.identifier;
        recipient = other.sender;
        sender = other.recipient;
        transferAmount = other.transferAmount * (-1);
        if (other.transferCategory == TransferCategory.DEBIT) transferCategory = TransferCategory.CREDIT;
        else transferCategory = TransferCategory.DEBIT;
        transferStatus = other.transferStatus;

    }

    public void showInfo() {
        System.out.println(identifier + " " + recipient.getName() + " " + sender.getName() + " " + transferAmount + " " + transferCategory + " " + transferStatus);
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

    public TransferStatus getTransferStatus() {
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
