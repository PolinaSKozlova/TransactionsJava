package ex00;

public class Program {
    public static void main(String[] args) {
        User userBob = new User("Bob", 100);
        System.out.println(userBob.getIdentifier() + " " + userBob.getName() + " " + userBob.getBalance());
        userBob.setBalance(400);
        System.out.println(userBob.getIdentifier() + " " + userBob.getName() + " " + userBob.getBalance());
        User userAnn = new User("Ann", 150);
        System.out.println(userAnn.getIdentifier() + " " + userAnn.getName() + " " + userAnn.getBalance());
        userAnn.setBalance(30);
        Transaction tr = new Transaction(userBob, userAnn, -100);
        System.out.println(tr.getIdentifier() + " " + tr.getTransferStatus());
        System.out.println(userAnn.getIdentifier() + " " + userAnn.getName() + " " + userAnn.getBalance());
        System.out.println(userBob.getIdentifier() + " " + userBob.getName() + " " + userBob.getBalance());
        Transaction tr2 = new Transaction(userAnn, userBob, 50);
        System.out.println(tr2.getIdentifier() + " " + tr2.getTransferStatus());
        System.out.println(userAnn.getIdentifier() + " " + userAnn.getName() + " " + userAnn.getBalance());
        System.out.println(userBob.getIdentifier() + " " + userBob.getName() + " " + userBob.getBalance());
    }
}
