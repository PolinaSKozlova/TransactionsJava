package ex02;

public interface UsersList {
    public void addUser(User newUser);

    public User retrieveUserById(int userId) throws UserNotFoundException;

    public User retrieveUserByIndex(int arrayIndex)
            throws UserNotFoundException;

    public int retrieveNumberOfUsers();

    public int getSize();
}

