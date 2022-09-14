package com.bachhoastore.controllers;

import com.bachhoastore.model.User;
import com.bachhoastore.services.UserService;
import com.bachhoastore.services.UserServiceImp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class UserControllerImp implements UserController{
    private UserService userService = new UserServiceImp();
    public UserControllerImp(){
    }
    @Override
    public void registerUser(User user) throws IOException {
        userService.addUser(user);
    }
    @Override
    public User editUser(String mobile, User user) {
        return userService.editUser(mobile, user);
    }

    @Override
    public User loginByMobile(String mobile, String passWord) {
        return userService.loginByMobile(mobile, passWord);
    }

    @Override
    public List<User> searchUsersByName(String name) {
        return userService.searchUsersByName(name);
    }

    @Override
    public List<User> searchUsersByMobile(String mobile) {
        return userService.searchUsersByMobile(mobile);
    }

    @Override
    public boolean deleteUser(String mobile) {
        return userService.deleteUser(mobile);
    }
    @Override
    public User getUser(String mobile) {
        return userService.getUserByMobile(mobile);
    }
    @Override
    public List<User> findAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    public ArrayList<User> addUsers(ArrayList<User> user) {
        return null;
    }
}
