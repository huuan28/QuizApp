package com.example.quizapp.model;

import java.io.Serializable;

public class User implements Serializable {
    String id;
    String name;
    String password;
    String gender;
    String email;
    String birth;
    int avatar;
    public User() {
    }

    public User(String id, String name, String password, String gender, String email, String birth, int avatar) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.email = email;
        this.birth = birth;
        this.avatar = avatar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }
}
