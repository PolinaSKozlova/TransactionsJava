package ex05.Users;

import java.util.Arrays;

public class UsersArrayList implements UsersList {
    private User arrayList[];
    private int position = 0;
    private int size = 10;

    public UsersArrayList() {
        arrayList = new User[size];
    }

    @Override
    public void addUser(User newUser) {
        if (position == size) {
            resizeArrayList();
        }
        arrayList[position++] = newUser;
    }

    @Override
    public User retrieveUserById(int userId) throws UserNotFoundException {
        for (int i = 0; i < position; ++i) {
            if (arrayList[i].getIdentifier() == userId) {
                return arrayList[i];
            }
        }
        throw new UserNotFoundException("Can't find user with " + userId
                + " id");
    }

    @Override
    public User retrieveUserByIndex(int arrayIndex)
            throws UserNotFoundException {
        try {
            return arrayList[arrayIndex];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new UserNotFoundException("Can't find user with "
                    + arrayIndex + " index");
        }
    }

    @Override
    public int retrieveNumberOfUsers() {
        return position;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public User[] getArrayList() {
        return arrayList;
    }

    private void resizeArrayList() {
        size *= 2;
        arrayList = Arrays.copyOf(arrayList, size);
    }
}
