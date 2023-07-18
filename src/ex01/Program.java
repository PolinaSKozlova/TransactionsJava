package ex01;

public class Program {
    public static void main(String[] args) {
        User userBob = new User("Bob", 200);
        System.out.println(userBob.getIdentifier() + " " + userBob.getName() + " " + userBob.getBalance());
        userBob.setBalance(430);
        System.out.println(userBob.getIdentifier() + " " + userBob.getName() + " " + userBob.getBalance());
        userBob.setBalance(20.99f);
        System.out.println(userBob.getIdentifier() + " " + userBob.getName() + " " + userBob.getBalance());
        User userKen = new User("Ken", 500);
        System.out.println(userKen.getIdentifier() + " " + userKen.getName() + " " + userKen.getBalance());
        userKen.setBalance(348.5f);
        System.out.println(userKen.getIdentifier() + " " + userKen.getName() + " " + userKen.getBalance());
        User userAnn = new User("Ann", 35);
        System.out.println(userAnn.getIdentifier() + " " + userAnn.getName() + " " + userAnn.getBalance());
        userAnn.setBalance(670.56f);
        System.out.println(userAnn.getIdentifier() + " " + userAnn.getName() + " " + userAnn.getBalance());
    }
}
