package com.bachhoastore.views;

import com.bachhoastore.model.User;
import com.bachhoastore.validates.UserValidator;

import java.util.List;
import java.util.Scanner;
public class ConsoleView {
    public static User nhapThongTinUser(){
        Scanner scanner = new Scanner(System.in);
        int length = 5;
        int index = 0;
        User user = new User();
        while (index++ < length) {
            switch (index){
                case 1:
                    System.out.println("1. Nhập Name: ");
                    String name = scanner.nextLine();
                    if(UserValidator.validateName(name)){
                        user.setName(name);
                        break;
                    }
                    index --;
                    break;
                case 2:
                    System.out.println("2. Nhập Birthday: ");
                    String birthday = scanner.nextLine();
                    user.setBirthday(birthday);
                    break;
                case 3:
                    System.out.println("3. Nhập Giới Tính: ");
                    int sex = Integer.valueOf(scanner.nextLine());
                    user.setSex(sex);
                    break;
                case 4:
                    System.out.println("4. Nhập Email: ");
                    String email = scanner.nextLine();
                    user.setEmail(email);
                    break;
                case 5:
                    System.out.println("5. Nhập Mobile: ");
                    String mobile = scanner.nextLine();
                    user.setMobile(mobile);
                    break;
            }
        }
        return user;
    }
    public static User NhapThongTinEdit(){
        Scanner scanner = new Scanner(System.in);
        User user1 = new User();
        System.out.println("nhâp 1: edit name");
        System.out.println("nhâp 2: edit age");
        System.out.println("nhâp 3: edit sex");
        System.out.println("nhâp 4: edit email");
        System.out.println("nhâp 5: edit mobile");
        System.out.println("nhập 6: edit ket thuc");
        for (int i =0; i < 5;i++) {
            System.out.println("Nhap so:");
            int h = scanner.nextInt();
            if (h == 6) {
                break;
            } else {
                switch (h) {
                    case 1:
                        System.out.println("Name edit: ");
                        Scanner scanner1 = new Scanner(System.in);
                        String e = scanner1.nextLine();
                        user1.setName(e);
                        break;
                    case 2:
                        Scanner scanner2 = new Scanner(System.in);
                        System.out.println("Birthday edit: ");
                        user1.setBirthday(scanner2.nextLine());
                        break;
                    case 3:
                        Scanner scanner3 = new Scanner(System.in);
                        System.out.println("Sex edit: ");
                        user1.setSex(scanner3.nextInt());
                        break;
                    case 4:
                        Scanner scanner4 = new Scanner(System.in);
                        System.out.println("Email edit: ");
                        user1.setEmail(scanner4.nextLine());
                        break;
                    case 5:
                        Scanner scanner5 = new Scanner(System.in);
                        System.out.println("Mobile edit: ");
                        user1.setMobile(scanner5.nextLine());
                        break;
                }
            }
        }
        return user1;
    }
    public static String thongTinDangNhap(){
        System.out.println("Nhập só Mobile: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void displayUser(User user) {
        if(user == null){
            // show message not found user
            System.out.println("Not found User");
            return;
        }
        System.out.println(user);
    }

    public static void displayUsers(List<User> users) {
        if(users == null){
            // show message not found user
            System.out.println("Not found User");
            return;
        }
        if(users.isEmpty()){
            System.out.println("empty!");
        }
        System.out.println(  String.format("%20s|%20s|%20s|%20s|%20s","Name", "Birthday", "Sex", "Email", "Mobile"));
        for (User user : users) {
            System.out.println(user);
        }
    }
}
