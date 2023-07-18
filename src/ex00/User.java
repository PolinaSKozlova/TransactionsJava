package ex00;

public class User {
    public User(String name, float balance) {
        this.name = name;
        this.setBalance(balance);
        identifier = ++countId;
    }

    public void setBalance(float balance) {
        if (balance < 0) {
            System.err.println("Initial balance can't be zero!");
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

    public void showInfo() {
        System.out.println(identifier + " " + name + " " + balance);
    }

    private static int countId = 0;
    private final int identifier;
    private final String name;
    private float balance;
}
