package ex02;

public class Program {
    public static void main(String[] args) {
        UsersList myUsersArray = new UsersArrayList();
        System.out.println("number of users "
                + myUsersArray.retrieveNumberOfUsers());
        System.out.println("array size " + myUsersArray.getSize());
        User userBob = new User("Bob", 320);
        User userAnton = new User("Anton", 1000.5f);
        User userRoma = new User("Roma", 455);
        User userAnn = new User("Ann", 55);
        User userSerge = new User("Serge", 543f);
        User userSasha = new User("Sasha", 32);
        User userIvan = new User("Ivan", 320);
        myUsersArray.addUser(userBob);
        myUsersArray.addUser(userAnton);
        myUsersArray.addUser(userRoma);
        myUsersArray.addUser(userAnn);
        myUsersArray.addUser(userSerge);
        myUsersArray.addUser(userSasha);
        myUsersArray.addUser(userIvan);
        System.out.println();
        System.out.println("number of users "
                + myUsersArray.retrieveNumberOfUsers());
        System.out.println("array size " + myUsersArray.getSize());
        try {
            for (int i = 0; i < myUsersArray.retrieveNumberOfUsers(); ++i) {
                System.out.println(myUsersArray.retrieveUserByIndex(i).
                        getIdentifier() + " "
                        + myUsersArray.retrieveUserByIndex(i).getName() + " "
                        + myUsersArray.retrieveUserByIndex(i).getBalance());
            }
        } catch (UserNotFoundException e) {
            System.out.println(e.toString());
        }
        System.out.println();
        User userPolina = new User("Polina", 987);
        User userKris = new User("Kris", 879.54f);
        User userMarat = new User("Marat", 631);
        User userSanya = new User("Sanya", 76);
        User userGena = new User("Gena", -100);
        myUsersArray.addUser(userPolina);
        myUsersArray.addUser(userKris);
        myUsersArray.addUser(userMarat);
        myUsersArray.addUser(userSanya);
        myUsersArray.addUser(userGena);
        System.out.println("number of users "
                + myUsersArray.retrieveNumberOfUsers());
        System.out.println("array size " + myUsersArray.getSize());
        try {
            for (int i = 0; i < myUsersArray.retrieveNumberOfUsers(); ++i) {
                System.out.println(myUsersArray.retrieveUserByIndex(i).
                        getIdentifier() + " "
                        + myUsersArray.retrieveUserByIndex(i).getName() + " "
                        + myUsersArray.retrieveUserByIndex(i).getBalance());
            }
        } catch (UserNotFoundException e) {
            System.out.println(e.toString());
        }
        try {
            System.out.println(myUsersArray.retrieveUserById(7).
                    getIdentifier() + " "
                    + myUsersArray.retrieveUserById(7).getName() + " "
                    + myUsersArray.retrieveUserById(7).getBalance());
        } catch (UserNotFoundException e) {
            System.out.println(e.toString());
        }
        System.out.println();
        try {
            myUsersArray.retrieveUserById(19);
        } catch (UserNotFoundException e) {
            System.out.println(e.toString());
        }
        try {
            myUsersArray.retrieveUserByIndex(39);
        } catch (UserNotFoundException e) {
            System.out.println(e.toString());
        }
    }
}
