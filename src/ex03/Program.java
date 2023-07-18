package ex03;

public class Program {
    public static void main(String[] args) {
        TransactionsList listTransactions = new TransactionsLinkedList();
        User userBob = new User("Bob", 340);
        User userAnn = new User("Ann", 280);
        User userKen = new User("Ken", 450);
        Transaction tr1 = new Transaction(userBob, userAnn, 100);
        Transaction tr2 = new Transaction(userKen, userBob, 150);
        Transaction tr3 = new Transaction(userAnn, userKen, -50);
        Transaction tr4 = new Transaction(userBob, userKen, -600);
        Transaction tr5 = new Transaction(userBob, userKen, -60);
        listTransactions.addTransaction(tr1);
        listTransactions.addTransaction(tr2);
        listTransactions.addTransaction(tr3);
        listTransactions.addTransaction(tr4);
        listTransactions.addTransaction(tr5);
        Transaction[] arrayTransaction = listTransactions.transformToArray();
        for (var it : arrayTransaction) {
            System.out.println(it.getIdentifier() + " " + it.getRecipient().getName() + " " + it.getRecipient().getBalance() + " "
                    + it.getSender().getName() + " " + it.getSender().getBalance() + " " + it.getTransferAmount() + " " + it.getTransferStatus());
        }
        try {
            listTransactions.removeTransaction(tr4.getIdentifier());
        } catch (TransactionNotFoundException e) {
            System.out.println(e.toString());
        }
        System.out.println();
        arrayTransaction = listTransactions.transformToArray();
        for (var it : arrayTransaction) {
            System.out.println(it.getIdentifier() + " " + it.getRecipient().getName() + " " + it.getRecipient().getBalance() + " "
                    + it.getSender().getName() + " " + it.getSender().getBalance() + " " + it.getTransferAmount() + " " + it.getTransferStatus());
        }
        try {
            listTransactions.removeTransaction(tr4.getIdentifier());
        } catch (TransactionNotFoundException e) {
            System.out.println(e.toString());
        }
    }
}
