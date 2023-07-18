package ex01;

public class Program {
    public static void main(String[] args) {
        User userBob = new User("Bob", 200);
        userBob.showInfo();
        userBob.setBalance(430);
        userBob.showInfo();
        userBob.setBalance(20.99f);
        userBob.showInfo();
        User userKen = new User("Ken", 500);
        userKen.showInfo();
        userKen.setBalance(348.5f);
        userKen.showInfo();
        User userAnn = new User("Ann", 35);
        userAnn.showInfo();
        userAnn.setBalance(670.56f);
        userAnn.showInfo();
    }
}
