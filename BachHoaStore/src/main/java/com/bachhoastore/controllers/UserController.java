package com.bachhoastore.controllers;

import com.bachhoastore.model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface UserController {
    public void registerUser(User user) throws IOException;
    User editUser(String mobile, User user);
    User loginByMobile(String mobile, String passWord);
    List<User> searchUsersByName(String name);
    List<User> searchUsersByMobile(String mobile);
    boolean deleteUser(String mobile);

    User getUser(String mobile);

    List<User> findAllUsers();

    ArrayList<User> addUsers(ArrayList<User> user);
}
