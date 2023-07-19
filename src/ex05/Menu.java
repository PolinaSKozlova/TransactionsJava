package ex05;

import ex05.Transactions.IllegalTransactionException;
import ex05.Transactions.TransactionNotFoundException;
import ex05.Transactions.TransactionsService;
import ex05.Users.User;
import ex05.Users.UserNotFoundException;

import java.util.Scanner;
import java.util.UUID;

public class Menu {
    public Menu(TransactionsService service) {
        transactionsService = service;
    }

    public void showMenu(String mode) {
        int menuNumber = 0;
        menuMode = mode;
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

    private void makeMenuNumber(int value) {
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
                viewAllUsersTransactions();
                break;
            case 5:
                if (menuMode.equals("dev")) {
                    removeTransferById();
                }
                break;
            case 6:
                if (menuMode.equals("dev")) {
                    checkValidityTransactions();
                }
                break;
            case 7:
                break;
            default:
                System.out.println("Wrong menu number");
        }

    }

    private void addUserMenu() {
        Scanner line = new Scanner(System.in);
        System.out.println("Enter a user name and a balance");
        String[] userInfo = line.nextLine().split(" ");
        if (userInfo.length != 2) {
            System.out.println("Wrong number of arguments");
            return;
        }
        User newUser = new User(userInfo[0],
                Float.parseFloat(userInfo[1]));
        transactionsService.addUser(newUser);
        System.out.println("User with id = " + newUser.getIdentifier()
                + " is added");

    }

    private void viewUserBalanceMenu() {
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

    private void performTransferMenu() {
        System.out.println("Enter a sender ID, a recipient ID, " +
                "and a transfer amount");
        Scanner line = new Scanner(System.in);
        String[] transactionInfo = line.nextLine().split(" ");
        if (transactionInfo.length != 3) {
            System.out.println("Wrong number of arguments");
            return;
        }
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

    private void viewAllUsersTransactions() {
        System.out.println("Enter a user ID");
        Scanner line = new Scanner(System.in);
        int userId = Integer.parseInt(line.nextLine());
        try {
            for (var us : transactionsService.retrieveUserTransfers(userId)) {
                System.out.println("To " + us.getSender().getName() +
                        "(id = " + us.getSender().getIdentifier() + ") " +
                        us.getTransferAmount() + " with id = "
                        + us.getIdentifier());
            }
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void removeTransferById() {
        System.out.println("Enter a user ID and a transfer ID");
        Scanner line = new Scanner(System.in);
        String[] transactionInfo = line.nextLine().split(" ");
        if (transactionInfo.length != 2) {
            System.out.println("Wrong number of arguments");
            return;
        }
        try {
            transactionsService.removeTransaction(UUID.fromString(transactionInfo[1]),
                    Integer.parseInt(transactionInfo[0]));
        } catch (UserNotFoundException |
                 TransactionNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void checkValidityTransactions() {
        System.out.println("Check results:");
        for (var tr : transactionsService.checkValidity()) {
            System.out.println(tr.getRecipient().getName() + "(id = " +
                    tr.getRecipient().getIdentifier() +
                    ") has an unacknowledged transfer id =" + tr.getIdentifier()
                    + " from " + tr.getSender().getName() + "(id = " +
                    tr.getSender().getIdentifier() + ") for "
                    + tr.getTransferAmount());
        }
    }

    private void showDevMenu() {
        System.out.println("1. Add a user");
        System.out.println("2. View user balances");
        System.out.println("3. Perform a transfer");
        System.out.println("4. View all transactions for a specific user");
        System.out.println("5. DEV – remove a transfer by ID");
        System.out.println("6. DEV – check transfer validity");
        System.out.println("7. Finish execution");
    }

    private void showProdMenu() {
        System.out.println("1. Add a user");
        System.out.println("2. View user balances");
        System.out.println("3. Perform a transfer");
        System.out.println("4. View all transactions for a specific user");
        System.out.println("5. Finish execution");
    }

    private TransactionsService transactionsService;
    private String menuMode;
}
