package ex04;

import java.util.HashMap;
import java.util.UUID;

public class TransactionsService {
    public void addUser(User newUser) {
        users.addUser(newUser);
    }

    public float getUserBalance(int userId) throws UserNotFoundException {
        return users.retrieveUserById(userId).getBalance();
    }

    public void performTransferTransaction(int recipientId, int senderId, float sum) throws UserNotFoundException, IllegalTransactionException {
        Transaction transferUser1 = new Transaction(users.retrieveUserById(recipientId), users.retrieveUserById(senderId), sum);
        Transaction transferUser2 = new Transaction(transferUser1);
        users.retrieveUserById(recipientId).setUserTransactions(transferUser1);
        users.retrieveUserById(senderId).setUserTransactions(transferUser2);
    }

    public Transaction[] retrieveUserTransfers(int userId) throws UserNotFoundException {
        return users.retrieveUserById(userId).getUserTransactions().transformToArray();
    }

    public void removeTransaction(UUID transactionId, int userId) throws UserNotFoundException,
            TransactionNotFoundException {
        users.retrieveUserById(userId).getUserTransactions().removeTransaction(transactionId);
    }

    public Transaction[] checkValidity() {
        HashMap<UUID, Transaction> unpairedTransactions = new HashMap<>();
        for (int i = 0; i < users.retrieveNumberOfUsers(); ++i) {
            Transaction[] userTransaction = users.getArrayList()[i].getUserTransactions().transformToArray();
            for (int j = 0; j < userTransaction.length; ++j) {
                if (unpairedTransactions.containsKey(userTransaction[j].getIdentifier())) {
                    unpairedTransactions.remove(userTransaction[j].getIdentifier());
                } else {
                    unpairedTransactions.put(userTransaction[j].getIdentifier(), userTransaction[j]);
                }
            }
        }
        return unpairedTransactions.values().toArray(new Transaction[0]);
    }

//    public User[] getUsersList() {
//        return users.getArrayList();
//    }

    private UsersList users = new UsersArrayList();
}
