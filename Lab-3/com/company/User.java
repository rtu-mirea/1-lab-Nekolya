package com.company;

public class User {
    private String name;
    private String login;
    private String password;

    public String getName()
    {
        return name;
    }


    User(String name, String login, String password){
        this.name = name;
        this.login = login;
        this.password = password;
    }



//////////////////////
    public Boolean enter(String login, String password){
        if (login.equals(this.login) && password.equals(this.password)){
            return true;
        }
        return false;
    }
}
