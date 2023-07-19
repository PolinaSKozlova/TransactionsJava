package ex02;

public class UserIdsGenerator {
    private static UserIdsGenerator uniqueInstance;
    private static int identifier = 0;

    public int generateId() {
        return ++identifier;
    }

    private UserIdsGenerator() {
    }

    public static UserIdsGenerator getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new UserIdsGenerator();
        }
        return uniqueInstance;
    }
}
