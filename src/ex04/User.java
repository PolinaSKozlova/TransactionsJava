package ex04;

public class User {
    private final int identifier;
    private final String name;
    private float balance;
    private TransactionsList userTransactions = new TransactionsLinkedList();

    public User(String name, float balance) throws IllegalArgumentException {
        identifier = UserIdsGenerator.getInstance().generateId();
        this.name = name;
        this.setBalance(balance);
    }

    public void setBalance(float balance) throws IllegalArgumentException {
        if (balance < 0) {
            throw new IllegalArgumentException();
        } else {
            this.balance = balance;
        }
    }

    public void showInfo() {
        System.out.println(identifier + " " + name + " " + balance);
        for (var it : userTransactions.transformToArray()) {
            System.out.println(it.getIdentifier() + " " +
                    it.getRecipient().getName() + " " + it.getSender().getName()
                    + " " + it.getTransferAmount() + " "
                    + it.getTransferCategory());
        }
    }

    public int getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    public float getBalance() {
        return balance;
    }

    public void setUserTransactions(Transaction other) {
        userTransactions.addTransaction(other);
    }

    public TransactionsList getUserTransactions() {
        return userTransactions;
    }
}

