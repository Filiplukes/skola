package com.example.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
    private String userEmail;
    private String password;
    private String rightUser;

    public Account() {
    }
    public Account(String userName, String userEmail, String password, String rightUser) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.password = password;
        this.rightUser = rightUser;
    }

    public Account(String userName, String userEmail, String password) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.password = password;
    }

    public Account(Long id, String userName, String userEmail, String password, String rightUser) {
        this.id = id;
        this.userName = userName;
        this.userEmail = userEmail;
        this.password = password;
        this.rightUser = rightUser;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRightUser() {
        return rightUser;
    }

    public void setRightUser(String rightUser) {
        this.rightUser = rightUser;
    }
}