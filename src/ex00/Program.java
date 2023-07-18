package ex00;

public class Program {
    public static void main(String[] args) {
        User userBob = new User("Bob", 100);
        userBob.showInfo();
        userBob.setBalance(400);
        userBob.showInfo();
        User userAnn = new User("Ann", 150);
        userAnn.showInfo();
        userAnn.setBalance(30);
        userAnn.showInfo();
        Transaction tr = new Transaction(userBob, userAnn, -100);
        Transaction trInverse = new Transaction(tr);
        tr.showInfo();
        trInverse.showInfo();
        userBob.showInfo();
        userAnn.showInfo();
        Transaction tr2 = new Transaction(userAnn, userBob, 50);
        Transaction tr2Inverse = new Transaction(tr2);
        tr2.showInfo();
        tr2Inverse.showInfo();
        userBob.showInfo();
        userAnn.showInfo();
    }
}
