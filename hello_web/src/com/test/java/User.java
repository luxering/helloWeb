package com.test.java;

/**
 * Created by IntelliJ IDEA.
 * User: luxer
 * Date: 10/10/2017
 * Time: 20:04
 * To change this template use File | Settings | File Templates.
 */
public class User {
    private String username;
    private String password;
    private String user_img_url;
    private int userId;
    private int signUpDate;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_img_url() {
        return user_img_url;
    }

    public void setUser_img_url(String user_img_url) {
        this.user_img_url = user_img_url;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSignUpDate() {
        return signUpDate;
    }

    public void setSignUpDate(int signUpDate) {
        this.signUpDate = signUpDate;
    }
}
