package com.bachhoastore;

import com.bachhoastore.controllers.UserController;
import com.bachhoastore.controllers.UserControllerImp;
import com.bachhoastore.model.User;
import com.bachhoastore.views.ConsoleView;


import java.io.IOException;
import java.util.*;
public class Application {
    public static void main(String[] args) throws IOException {
        UserController userController = new UserControllerImp();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Nhap so 0: Thêm thông tin User");
            System.out.println("Nhap so 1: Cập nhật thông tin User");
            System.out.println("Nhap so 2: Xóa thông tin User");
            System.out.println("Nhap so 3: Hiển thị thông tin User cần tìm");
            System.out.println("Nhap so 4: Hiển thị tất cả thông tin User");
            System.out.println("Nhap so:");
            int number = scanner.nextInt();
            String mobile;
            switch (number) {
                case 0: //thêm thông tin User
                    User user = ConsoleView.nhapThongTinUser();
                    userController.registerUser(user);
                    break;
                case 1://Edit thông tin User
                    System.out.println("nhập mobile:");
                    Scanner scanner1 = new Scanner(System.in);
                    mobile = scanner1.nextLine();
                    User user1 = ConsoleView.NhapThongTinEdit();
                    userController.editUser(mobile, user1);
                    break;
                case 2://Delete thông tin User
                    System.out.println("Nhập mobile: ");
                    Scanner scanner2 = new Scanner(System.in);
                    mobile = scanner2.next();
                    userController.deleteUser(mobile);
                    break;
                case 3://Hiển thông tin User cần tìm
                    System.out.println("nhập mobile:");
                    Scanner scanner3 = new Scanner(System.in);
                    mobile = scanner3.nextLine();
                    User user3 = userController.getUser(mobile);
                    ConsoleView.displayUser(user3);
                    break;
                case 4://Hiển thị tất cả thông tin User
                    List<User> users = userController.findAllUsers();
                    ConsoleView.displayUsers(users);
                    break;
                default:
            }
        }
    }
}
