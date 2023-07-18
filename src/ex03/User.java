package ex03;


public class User {
    public User(String name, float balance) {
        this.name = name;
        this.setBalance(balance);
        identifier = ++countId;
    }

    public void setBalance(float balance) {
        if (balance < 0) System.err.println("Initial balance can't be zero!");
        else this.balance = balance;
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

    public Transaction[] getUsersTransaction() {
        return userTransactions.transformToArray();
    }

    private static int countId = 0;
    private final int identifier;
    private final String name;
    private float balance;
    private TransactionsList userTransactions = new TransactionsLinkedList();
}

