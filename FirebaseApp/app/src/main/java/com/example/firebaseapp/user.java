package com.example.firebaseapp;

public class user {
    String email;
    String name;

    public user() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public user(String email, String name) {
        this.email = email;
        this.name = name;
    }
}
