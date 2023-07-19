package ex05;

public class IllegalTransactionException extends Exception {
    public IllegalTransactionException() {
        super("The sum of transaction is greater than user balance");
    }

    public IllegalTransactionException(String message) {
        super(message);
    }
}
