package ex05;

import ex05.Transactions.IllegalTransactionException;
import ex05.Transactions.Transaction;
import ex05.Transactions.TransactionNotFoundException;
import ex05.Transactions.TransactionsService;
import ex05.Users.User;
import ex05.Users.UserNotFoundException;

import java.util.UUID;

public class Program {
    public static void main(String[] args) {
        checkArgs(args);
        TransactionsService service = new TransactionsService();
        Menu menu = new Menu(service);
        menu.showMenu(args[0].substring("--profile=".length()));
    }

    private static void checkArgs(String[] args) {
        if (args.length != 1) {
            System.out.println("Wrong number of arguments");
            System.exit(1);
        }
        if (!args[0].startsWith("--profile=")) {
            System.out.println("Wrong argument");
            System.exit(1);
        }
    }
}
