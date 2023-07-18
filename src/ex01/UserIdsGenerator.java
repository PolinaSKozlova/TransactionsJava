package ex01;

public class UserIdsGenerator {
    public int generateId() {
        return ++identifier;
    }

    public static UserIdsGenerator getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new UserIdsGenerator();
        }
        return uniqueInstance;
    }

    private UserIdsGenerator() {
    }

    private static UserIdsGenerator uniqueInstance;
    private static int identifier = 0;
}
