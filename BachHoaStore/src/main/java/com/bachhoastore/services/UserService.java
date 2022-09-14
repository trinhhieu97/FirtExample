package com.bachhoastore.services;

import com.bachhoastore.model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface UserService {
    void addUser(User user) throws IOException; // Thêm một user mới
    User editUser(String mobile, User user); // thay đổi thông tin user sẵn có
    User loginByMobile(String mobile, String passWord);
    List<User> searchUsersByName(String name); // suport wildcard hie*

    List<User> searchUsersByMobile(String mobile); // suport wildcard hie*

    boolean deleteUser(String mobile);

    User getUserByMobile(String mobile);

    List<User> getAllUsers();
    List<String> SortUserName();

    List<User> addUsers(ArrayList<User> user);
}
