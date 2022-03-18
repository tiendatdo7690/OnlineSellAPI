package com.example.demo.entitiesAPI;

import org.hibernate.annotations.Type;

import javax.persistence.Column;

public class UserAccountAPI {

    private Long id;

    private String userName;

    private String passWord;

    private Boolean status;

    public UserAccountAPI() {
    }

    public UserAccountAPI(Long id, String userName, String passWord, Boolean status) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
