package com.company;

import java.io.Serializable;

public class Admin extends User implements Serializable {
    Admin(String name, String login, String password) {
        super(name, login, password);
    }
}
