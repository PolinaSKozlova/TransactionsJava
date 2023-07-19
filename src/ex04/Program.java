package ex04;

import java.util.UUID;

public class Program {
    public static void main(String[] args) {
        try {
            showResults();
        } catch (UserNotFoundException | IllegalTransactionException | TransactionNotFoundException e) {
            System.out.println(e.toString());
        }
    }

    public static void showResults() throws UserNotFoundException, IllegalTransactionException, TransactionNotFoundException {
        TransactionsService tS = new TransactionsService();
        User userBob = new User("Bob", 200);
        User userAnn = new User("Ann", 150);
        User userKen = new User("Ken", 500);
        Transaction tr = new Transaction(userAnn, userBob, -100);
        Transaction trInverse = new Transaction(tr);
        Transaction tr2 = new Transaction(userBob, userKen, -100);
        Transaction tr2Inverse = new Transaction(tr2);
        userBob.setUserTransactions(tr);
        userAnn.setUserTransactions(trInverse);
        userBob.setUserTransactions(tr2);
        userKen.setUserTransactions(tr2Inverse);
        tS.addUser(userBob);
        tS.addUser(userAnn);
        tS.addUser(userKen);
        tS.performTransferTransaction(userBob.getIdentifier(), userAnn.getIdentifier(), 50);
        tS.performTransferTransaction(userKen.getIdentifier(), userAnn.getIdentifier(), 100);
        tS.performTransferTransaction(userKen.getIdentifier(), userBob.getIdentifier(), -500);
        System.out.println("Bob transactions");
        for (var it : tS.retrieveUserTransfers(userBob.getIdentifier())) {
            it.showInfo();
        }
        System.out.println("Ann transactions");
        for (var it : tS.retrieveUserTransfers(userAnn.getIdentifier())) {
            it.showInfo();
        }
        System.out.println("Ken transactions");
        UUID refusedId = null;
        for (var it : tS.retrieveUserTransfers(userKen.getIdentifier())) {
            it.showInfo();
            if (it.getTransferStatus() == Transaction.TransferStatus.REFUSED) {
                refusedId = it.getIdentifier();
            }
        }
        tS.removeTransaction(refusedId, userKen.getIdentifier());
        System.out.println("Ken transactions after removing");
        for (var it : tS.retrieveUserTransfers(userKen.getIdentifier())) {
            it.showInfo();
        }
        System.out.println("Check validity");
        for (var it : tS.checkValidity()) {
            it.showInfo();
        }
    }
}

