package ex03;

public class Program {
    public static void main(String[] args) {
        TransactionsList listTransactions = new TransactionsLinkedList();
        User userBob = new User("Bob", 340);
        User userAnn = new User("Ann", 280);
        User userKen = new User("Ken", 450);
        Transaction tr1 = new Transaction(userBob, userAnn, 100);
        Transaction tr1Inverse = new Transaction(tr1);
        userBob.showInfo();
        userAnn.showInfo();
        Transaction tr2 = new Transaction(userKen, userBob, 150);
        Transaction tr2Inverse = new Transaction(tr2);
        userKen.showInfo();
        userBob.showInfo();
        Transaction tr3 = new Transaction(userAnn, userKen, -50);
        Transaction tr3Inverse = new Transaction(tr3);
        userAnn.showInfo();
        userKen.showInfo();
        Transaction tr4 = new Transaction(userBob, userKen, -600);
        Transaction tr4Inverse = new Transaction(tr4);
        userBob.showInfo();
        userKen.showInfo();
        Transaction tr5 = new Transaction(userBob, userKen, -60);
        Transaction tr5Inverse = new Transaction(tr5);
        userBob.showInfo();
        userKen.showInfo();
        listTransactions.addTransaction(tr1);
        listTransactions.addTransaction(tr1Inverse);
        listTransactions.addTransaction(tr2);
        listTransactions.addTransaction(tr2Inverse);
        listTransactions.addTransaction(tr3);
        listTransactions.addTransaction(tr3Inverse);
        listTransactions.addTransaction(tr4);
        listTransactions.addTransaction(tr4Inverse);
        listTransactions.addTransaction(tr5);
        listTransactions.addTransaction(tr5Inverse);

        Transaction[] arrayTransaction = listTransactions.transformToArray();
        for (var it : arrayTransaction) {
            it.showInfo();
            System.out.print("recipient ");
            it.getRecipient().showInfo();
            System.out.print("sender ");
            it.getSender().showInfo();
        }
        try {
            listTransactions.removeTransaction(tr4.getIdentifier());
            listTransactions.removeTransaction(tr4Inverse.getIdentifier());
        } catch (TransactionNotFoundException e) {
            System.out.println(e.toString());
        }
        System.out.println();
        arrayTransaction = listTransactions.transformToArray();
        for (var it : arrayTransaction) {
            it.showInfo();
            System.out.print("recipient ");
            it.getRecipient().showInfo();
            System.out.print("sender ");
            it.getSender().showInfo();
        }
        System.out.println();
        try {
            listTransactions.removeTransaction(tr4.getIdentifier());
        } catch (TransactionNotFoundException e) {
            System.out.println(e.toString());
        }
    }
}
