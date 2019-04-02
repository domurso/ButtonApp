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

    public void setUsername(String username){
        user = username;
    }

    public void setPassword(String password){
        pass = password;
    }

    public String toString(){
        return  "Username:" + user + "\n" +
                "Password:" + pass;
    }


}
