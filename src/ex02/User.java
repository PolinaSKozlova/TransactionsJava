package ex02;

public class User {
    public User(String name, float balance) {
        identifier = UserIdsGenerator.getInstance().generateId();
        this.name = name;
        this.setBalance(balance);
    }

    public void setBalance(float balance) {
        if (balance < 0) {
            System.err.println("Balance can't be less than zero");
        } else {
            this.balance = balance;
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

    private final int identifier;
    private final String name;
    private float balance;
}
