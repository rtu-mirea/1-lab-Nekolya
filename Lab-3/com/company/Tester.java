package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Tester {
    private ArrayList<Question> questions;
    private ArrayList<TestedUser> users;
    private TestedUser currentUser;

    Tester()
    {
        questions = new ArrayList<>();
        users = new ArrayList<>();
    }


    public void addUser(String name, String login, String password){
        users.add(new TestedUser(name, login, password));
    }
    public void addQuestion(Question q){
        questions.add(q);
    }

    public boolean findUser(String login, String password){
        for( int i = 0; i<users.size(); i++){
            if ((users.get(i)).enter(login,password))
            {
                currentUser = users.get(i);
                return true;
            }
        }
        return false;
    }

    public TestedUser getCurrentUser() {
        return currentUser;
    }

    public ArrayList<Question> getQuestions(){
        return questions;
    }

    public String getResult(){
        StringBuilder res = new StringBuilder("Результаты тестирования:");
        for(int i = 0; i<users.size(); i++){
            res.append("\n").append(users.get(i).getName()).append(" - ").append(users.get(i).getResult()).append("%");
        }
        return res.toString();

    }

}
