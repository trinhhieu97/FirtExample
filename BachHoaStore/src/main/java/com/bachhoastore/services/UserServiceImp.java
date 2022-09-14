package com.bachhoastore.services;

import com.bachhoastore.exception.NotFoundException;
import com.bachhoastore.model.IUserRepository;
import com.bachhoastore.model.User;
import com.bachhoastore.model.mongo.UserRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImp implements UserService{
    IUserRepository userRepository = new UserRepository();
//    List<User> list1 = userRepository.loadAllUsers();
//    Map<String, User> hashMap = userRepository.loadAllUsersMap();
    public UserServiceImp() {
    }
//    public Map<String, User> editMap(String mobile, User user1) throws IOException {
//        Map<String,User> users = userRepository.loadAllUsersMap();
//            User user = users.get(mobile);
//                String[] m = {user1.getName(),user1.getBirthday(),Integer.toString(user1.getSex()),user1.getEmail(),user1.getMobile()};
//                for (int i = 0; i < 5;i++) {
//                    if (!(m[i] ==null)){
//                        switch (i){
//                            case 0:
//                                user.setName(user1.getName());
//                                break;
//                            case 1:
//                                user.setBirthday(user1.getBirthday());
//                                break;
//                            case 2:
//                                user.setSex(user1.getSex());
//                                break;
//                            case 3:
//                                user.setEmail(user1.getEmail());
//                                break;
//                            case 4:
//                                user.setMobile(user1.getMobile());
//                                break;
//                        }
//                    }
//                }
//        return users;
//    }

    public List edit(String mobile, User user1) throws IOException {
        List<User> users = userRepository.loadAllUsers();
        int start = 0;
        int length = users.size();
        while (start < length){
            User user = users.get(start);
            String mo = user.getMobile();
            if (mo.equals(mobile)){
                String[] m = {user1.getName(),user1.getBirthday(),Integer.toString(user1.getSex()),user1.getEmail(),user1.getMobile()};
                for (int i = 0; i < 5;i++) {
                    if (!(m[i] ==null)){
                        switch (i){
                            case 0:
                                user.setName(user1.getName());
                                break;
                            case 1:
                                user.setBirthday(user1.getBirthday());
                                break;
                            case 2:
                                user.setSex(user1.getSex());
                                break;
                            case 3:
                                user.setEmail(user1.getEmail());
                                break;
                            case 4:
                                user.setMobile(user1.getMobile());
                                break;
                        }
                    }
                }
                break;
            }
            start++;
        }
        return users;
    }
    public User Login(String mobile, List<User> user1) throws IOException {
        List<User> users = userRepository.loadAllUsers();
        int start = 0;
        int length = users.size();
        User user = null;
        while (start < length) {
            user = users.get(start);
            String mo = user.getMobile();
            if (mo.equals(mobile)) {
                break;
            }
            start++;
        }
        return user;
    }
//    public Map<String,User> deleteUser(String mobile) throws IOException {
//        Map<String,User> users = userRepository.loadAllUsersMap();
//        users.remove(mobile);
//        return users;
//    }
//    @Override
//    public void registerUser(User user) throws IOException {
//        userRepository.addUser(user);
//        list1.add(user);
//        class ALocal {
//        }
//
//    }

    @Override
    public void addUser(User user) throws IOException {
        userRepository.addUser(user);
    }
    @Override
    public User editUser(String mobile, User user) {
        if (user == null){
            throw new NotFoundException();
        }
        return userRepository.editUser(mobile,user);
    }

    @Override
    public User loginByMobile(String mobile, String passWord) {
        return null;
    }

    @Override
    public List<User> searchUsersByName(String name) {

        return userRepository.searchUserByName(name);
    }

    @Override
    public List<User> searchUsersByMobile(String mobile) {
        return userRepository.searchUserByMobile(mobile);
    }

    @Override
    public boolean deleteUser(String mobile) {
        return userRepository.deleteUser(mobile);
    }
    @Override
    public User getUserByMobile(String mobile) {
        return userRepository.findUserByMobile(mobile);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.loadAllUsers();
    }

    @Override
    public List<String> SortUserName() {
        return userRepository.SortUserName();
    }

    @Override
    public List<User> addUsers(ArrayList<User> user) {
        return userRepository.addUsers(user);
    }
}
