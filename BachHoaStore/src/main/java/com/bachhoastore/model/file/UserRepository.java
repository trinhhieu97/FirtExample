package com.bachhoastore.model.file;

import com.bachhoastore.model.IUserRepository;
import com.bachhoastore.model.User;

import java.io.*;
import java.util.*;

public class UserRepository {
    static final String OUTPUT_FILE = "testout.txt";
    public void addUser(User user) throws IOException {
        try (FileWriter fileWriter = new FileWriter(OUTPUT_FILE,true)){
            fileWriter.write(user.toString());
        }
    }
    public List<User> loadAllUsers(){
        List<User> users = new ArrayList<>();
        String line = "null";
        FileInputStream fileInputStream = null;
        BufferedReader bufferedReader = null;
        try {
            fileInputStream = new FileInputStream(OUTPUT_FILE);
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            line = bufferedReader.readLine();
            while (line != null && !line.isEmpty()) {
                String[] list = line.split("\\|");
                String name = list[0];
                String birthday = list[1];
                int sex = Integer.parseInt(list[2]);
                String email = list[3];
                String mobile = list[4];
                String password = list[5];
                User user = new User(name, birthday, sex, email, mobile,password);
                users.add(user);
                line = bufferedReader.readLine();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return users;
    }
    public void saveAllUser(List users) {
        int start = 1;
        StringBuffer h = new StringBuffer(users.get(0).toString());
        while (start < users.size()) {
            h.append(users.get(start).toString());
            start++;
        }
        try (FileWriter k = new FileWriter(OUTPUT_FILE)){
            k.write(String.valueOf(h));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public User findUserByMobile(String mobile) {
        return null;
    }

    public void saveAllUserMap(Map<String, User> users) {
        String m = "null";
        int start = 1;
        StringBuffer h = new StringBuffer();
        for (Map.Entry<String, User> entry : users.entrySet()) {
            h.append(entry.getValue().toString());
        }
        try {
            FileWriter k = new FileWriter(OUTPUT_FILE);
            k.write(String.valueOf(h));
            k.close();
        } catch (Exception e) {
        }
    }
}
