package Users;

public class UserIdsGenerator {
  private static UserIdsGenerator uniqueInstance;
  private static int identifier = 0;

  private UserIdsGenerator() {}

  public int generateId() {
    return ++identifier;
  }

  public static UserIdsGenerator getInstance() {
    if (uniqueInstance == null) {
      uniqueInstance = new UserIdsGenerator();
    }
    return uniqueInstance;
  }
}
