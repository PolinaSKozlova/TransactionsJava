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
