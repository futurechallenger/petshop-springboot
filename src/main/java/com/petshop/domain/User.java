package com.petshop.domain;

import java.io.Serializable;

/**
 * Created by challenger on 23/6/2017.
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private int userId;
    private String userName;
    private String password;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

