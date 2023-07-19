package ex04;

import java.util.UUID;

public class Program {
    public static void main(String[] args) {
        showResults();
    }

    public static void showResults() {
        TransactionsService tS = new TransactionsService();
        User userBob = new User("Bob", 200);
        User userAnn = new User("Ann", 150);
        User userKen = new User("Ken", 500);
        Transaction tr = null;
        try {
            tr = new Transaction(userAnn, userBob, -100);
        } catch (IllegalTransactionException e) {
            System.out.println(e.toString());
            ;
        }
        Transaction trInverse = new Transaction(tr);
        Transaction tr2 = null;
        try {
            tr2 = new Transaction(userBob, userKen, -100);
        } catch (IllegalTransactionException e) {
            System.out.println(e.toString());
        }
        Transaction tr2Inverse = new Transaction(tr2);
        userBob.setUserTransactions(tr);
        userAnn.setUserTransactions(trInverse);
        userBob.setUserTransactions(tr2);
        userKen.setUserTransactions(tr2Inverse);
        tS.addUser(userBob);
        tS.addUser(userAnn);
        tS.addUser(userKen);
        try {
            tS.performTransferTransaction(userBob.getIdentifier(), userAnn.getIdentifier(), 50);
            tS.performTransferTransaction(userKen.getIdentifier(), userAnn.getIdentifier(), 100);
            tS.performTransferTransaction(userAnn.getIdentifier(), userKen.getIdentifier(), -50);
            tS.performTransferTransaction(userKen.getIdentifier(), userBob.getIdentifier(), -500);
        } catch (UserNotFoundException | IllegalTransactionException e) {
            System.out.println(e.toString());
        }
        System.out.println("Bob transactions");
        try {
            for (var it : tS.retrieveUserTransfers(userBob.getIdentifier())) {
                it.showInfo();
            }
        } catch (UserNotFoundException e) {
            System.out.println(e.toString());
        }
        System.out.println("Ann transactions");

        try {
            for (var it : tS.retrieveUserTransfers(userAnn.getIdentifier())) {
                it.showInfo();
            }
        } catch (UserNotFoundException e) {
            System.out.println(e.toString());
        }
        System.out.println("Ken transactions");
        UUID refusedId = userKen.getUserTransactions().transformToArray()[0].getIdentifier();
        try {
            for (var it : tS.retrieveUserTransfers(userKen.getIdentifier())) {
                it.showInfo();
            }
        } catch (UserNotFoundException e) {
            System.out.println(e.toString());
        }
        try {
            tS.removeTransaction(refusedId, userKen.getIdentifier());
        } catch (TransactionNotFoundException | UserNotFoundException e) {
            System.out.println(e.toString());
        }
        System.out.println("Ken transactions after removing");
        try {
            for (var it : tS.retrieveUserTransfers(userKen.getIdentifier())) {
                it.showInfo();
            }
        } catch (UserNotFoundException e) {
            System.out.println(e.toString());
        }
        System.out.println("Check validity");
        for (var it : tS.checkValidity()) {
            it.showInfo();
        }
    }
}

