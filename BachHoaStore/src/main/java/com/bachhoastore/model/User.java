package com.bachhoastore.model;

public class User {
    private int id;
    private String name;
    private String birthday;
    private int sex;
    private String email;
    private String mobile;
    private String password;

    public User(){
    }
    public User(String name,
                String birthday,
                int sex,
                String email,
                String mobile,
                String password) {
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public int getSex() {
        return sex;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return String.format("%20s|%20s|%20d|%20s|%20s|%20s"+"\n",name,birthday,sex,email,mobile,password);
    }
}
