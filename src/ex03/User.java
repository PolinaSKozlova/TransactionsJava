package ex03;

public class User {
    private final int identifier;
    private final String name;
    private float balance;
    private TransactionsList userTransactions = new TransactionsLinkedList();

    public User(String name, float balance) {
        identifier = UserIdsGenerator.getInstance().generateId();
        this.name = name;
        this.setBalance(balance);
    }

    public void setBalance(float balance) {
        if (balance < 0) {
            System.err.println("Balance " + name + " can't be less than zero");
        } else {
            this.balance = balance;
        }
    }

    public void showInfo() {
        System.out.println(identifier + " " + name + " " + balance);
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
}

