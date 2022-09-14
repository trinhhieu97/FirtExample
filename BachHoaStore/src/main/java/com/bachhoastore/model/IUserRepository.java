package com.bachhoastore.model;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public interface IUserRepository {
    public void addUser(User user) throws IOException;
    public List<User> loadAllUsers();
    User findUserByMobile(String mobile);
    public User editUser(String mobile, User user);
    public boolean deleteUser(String mobile);

    List<User> searchUserByName(String name);

    List<User> searchUserByMobile(String mobile);

    List<String> SortUserName();

    List<User> addUsers(ArrayList<User> user);
}
