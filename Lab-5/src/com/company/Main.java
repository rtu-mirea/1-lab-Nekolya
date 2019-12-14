package com.company;

public class Main {

    public static Tester tester = new Tester();
    public static void main(String[] args) {
        AuthorizationWindow authorizationWindow = new AuthorizationWindow();
        authorizationWindow.setVisible(true);
        TestedUser user = new TestedUser("", "", "");
        TestedUser t = user;
        t.right();
        t.answ();
    }
}
