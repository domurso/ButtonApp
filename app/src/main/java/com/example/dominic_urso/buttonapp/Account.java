package com.example.dominic_urso.buttonapp;

public class Account {
    String user;
    String pass;

    public Account(String username, String password){
        user = username;
        pass = password;

    }

    public String getUsername(){
        return user;
    }

    public String getPassword(){
        return pass;
    }


}
