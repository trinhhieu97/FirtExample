package com.bachhoastore.controllers;

import com.bachhoastore.model.User;
import com.bachhoastore.model.mongo.UserRepository;
import com.bachhoastore.services.AuthenticationService;
import com.bachhoastore.services.JwtService;
import com.bachhoastore.services.UserService;
import com.bachhoastore.services.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
@RestController
@RequestMapping("users")

/**
 * URL: localhost:8080/users/id1
 * HOST, address, domain: localhost:8080
 * URI: /users/id1
 * /users
 *    POST /
 *    GET /{userId}
 */
public class HomeController {
    @Autowired
    UserService userService;
    @Autowired
    JwtService jwtService;
    @Autowired
    AuthenticationService authenticationService;
    @PostMapping
    public User index(@RequestBody User user) throws IOException {
        System.out.println(user.toString());
        userService.addUser(user);
        return user;
    }
//    @PostMapping("/login")
//    public String login(@RequestBody LoginDto loginDto) throws IOException {
//        String token = authenticationService.login(loginDto);
//        return token;
////        String token = jwtService.generateTokenLogin(loginDto.getEmail());
////        return new LoginRespond(token);
//    }
    @PostMapping("/mobile/{mobile}")
    public User updateUser(@RequestHeader("token") String token, @RequestBody User user,@PathVariable("mobile") String usermobile) throws IOException {
        if(!jwtService.validateTokenLogin(token)){
            throw new RuntimeException("token not valid");
        }
        User user1 = userService.editUser(usermobile,user);
        return user1;
    }
    @PostMapping("/addUsers")
    public ArrayList<User> addUsers(@RequestHeader("token") String token,@RequestBody ArrayList<User> user) throws IOException {
        if(!jwtService.validateTokenLogin(token)){
            throw new RuntimeException("token not valid");
        }
        ArrayList<User> user1 = (ArrayList<User>) userService.addUsers(user);
        return user1;
    }

    @GetMapping("/{mobile}")
    public ArrayList<User> getUserByMobile(@RequestHeader("token") String token,@PathVariable("mobile") String usermobile) {
        if(!jwtService.validateTokenLogin(token)){
            throw new RuntimeException("token not valid");
        }
        ArrayList<User> listUser = (ArrayList<User>) userService.searchUsersByMobile(usermobile);
        return listUser;
    }
    @GetMapping("/name/{name}")
    public ArrayList<User> getUserByName(@RequestHeader("token") String token,@PathVariable("name") String username) {
        if(!jwtService.validateTokenLogin(token)){
            throw new RuntimeException("token not valid");
        }
        ArrayList<User> listUser = (ArrayList<User>) userService.searchUsersByName(username);
        return listUser;
    }
    @GetMapping
    public  ArrayList<User> getAllUser(@RequestHeader("token") String token) {
        if(!jwtService.validateTokenLogin(token)){
            throw new RuntimeException("token not valid");
        }
        ArrayList<User> listUser = (ArrayList<User>) userService.getAllUsers();
        return listUser;
    }
    @GetMapping("/sortAllUser")
    public ArrayList<String> getAndSortAllUser(@RequestHeader("token") String token) {
        if(!jwtService.validateTokenLogin(token)){
            throw new RuntimeException("token not valid");
        }
        ArrayList<String> listUser = (ArrayList<String>) userService.SortUserName();
        return listUser;
    }
    @DeleteMapping("/{mobile}")
    public boolean deleteUser(@RequestHeader("token") String token,@PathVariable("mobile") String usermobile) {
        if(!jwtService.validateTokenLogin(token)){
            throw new RuntimeException("token not valid");
        }
        userService.deleteUser(usermobile);
        return true;
    }
}
