package ex05;

import ex05.Transactions.IllegalTransactionException;
import ex05.Transactions.TransactionsService;
import ex05.Users.User;
import ex05.Users.UserNotFoundException;

import java.util.Scanner;
import java.util.UUID;

public class Menu {
    public static void showMenu(String mode) {
        int menuNumber = 0;
        Scanner s = new Scanner(System.in);
        if (mode.equals("dev")) {
            while (menuNumber != 7) {
                showDevMenu();
                menuNumber = s.nextInt();
                makeMenuNumber(menuNumber);
                System.out.println("---------------------------------------" +
                        "------------------");
            }
        }
        if (mode.equals("prod")) {
            while (menuNumber != 5) {
                showProdMenu();
                menuNumber = s.nextInt();
                makeMenuNumber(menuNumber);
                System.out.println("---------------------------------------" +
                        "------------------");

            }

        }
        s.close();
    }

    private static void makeMenuNumber(int value) {

        switch (value) {
            case 1:
                addUserMenu();
                break;
            case 2:
                viewUserBalanceMenu();
                break;
            case 3:
                performTransferMenu();
                break;
            case 4:
                System.out.println("View all transactions for a specific user");
                break;
            case 5:
                System.out.println("DEV – remove a transfer by ID");
                break;
            case 6:
                System.out.println("DEV – check transfer validity");
                break;
            case 7:
                break;
            default:
                System.out.println("Wrong menu number");
        }
    }

    private static void addUserMenu() {
        Scanner line = new Scanner(System.in);
        System.out.println("Enter a user name and a balance");
        String[] userInfo = line.nextLine().split(" ");
        User newUser = new User(userInfo[0],
                Float.parseFloat(userInfo[1]));
        transactionsService.addUser(newUser);
        System.out.println("User with id = " + newUser.getIdentifier()
                + " is added");
    }

    private static void viewUserBalanceMenu() {
        Scanner line = new Scanner(System.in);
        System.out.println("Enter a user ID");
        String id = line.nextLine();
        try {
            System.out.println(transactionsService.retrieveUserById
                    (Integer.parseInt(id)).getName() + " - " +
                    transactionsService.retrieveUserById
                            (Integer.parseInt(id)).getBalance());
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void performTransferMenu() {
        System.out.println("Enter a sender ID, a recipient ID, " +
                "and a transfer amount");
        Scanner line = new Scanner(System.in);
        String[] transactionInfo = line.nextLine().split(" ");
        try {
            transactionsService.performTransferTransaction(
                    Integer.parseInt(transactionInfo[0]),
                    Integer.parseInt(transactionInfo[1]),
                    Float.parseFloat(transactionInfo[2]));
        } catch (UserNotFoundException | IllegalTransactionException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("The transfer is completed");
    }

    private static void showDevMenu() {
        System.out.println("1. Add a user");
        System.out.println("2. View user balances");
        System.out.println("3. Perform a transfer");
        System.out.println("4. View all transactions for a specific user");
        System.out.println("5. DEV – remove a transfer by ID");
        System.out.println("6. DEV – check transfer validity");
        System.out.println("7. Finish execution");
    }

    private static void showProdMenu() {
        System.out.println("1. Add a user");
        System.out.println("2. View user balances");
        System.out.println("3. Perform a transfer");
        System.out.println("4. View all transactions for a specific user");
        System.out.println("5. Finish execution");
    }

    private static TransactionsService transactionsService
            = new TransactionsService();
}
