package com.bachhoastore.validates;

public class UserValidator {

    public static boolean validateName(String name) {
        if(name == null || name.isEmpty()){
            return false;
        }
        int length = name.length();
        return length > 1 && length < 31;
    }
}
