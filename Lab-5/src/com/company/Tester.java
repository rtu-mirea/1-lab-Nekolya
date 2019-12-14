package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Tester implements Serializable {
    private ArrayList<Question> questions;
    private ArrayList<User> users;
    private User currentUser;
    private int currentQuest;

    Tester()
    {
        questions = new ArrayList<>();
        users = new ArrayList<>();
        users.add(new Admin("Admin", "admin", "admin"));
        users.add(new TestedUser("Test", "test", "test"));
        currentQuest = 0;
    }

    public boolean testEnd(){
        if (currentQuest < questions.size())
            return false;
        currentQuest = 0;
        return true;
    }

    public void setCurrentQuest(){
        currentQuest++;
    }

    public Question getCurrentQuest() throws IndexOutOfBoundsException{
        return questions.get(currentQuest);
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

    public User getCurrentUser() {
        return currentUser;
    }

    public ArrayList<Question> getQuestions(){
        return questions;
    }

    public String getCurrentUserResult(){
        StringBuilder res = new StringBuilder("Результат тестирования: ");
        res.append(currentUser.getName()).append(" - ").append(((TestedUser)currentUser).getResult()).append("%");
        return res.toString();
    }

    public String getResult(){


            StringBuilder res = new StringBuilder("Результаты тестирования:");
            for(int i = 0; i<users.size(); i++){
                if (users.get(i) instanceof TestedUser)
                    res.append("\n").append(users.get(i).getName()).append(" - ").append(((TestedUser)users.get(i)).getResult()).append("%");
            }
            return res.toString();





    }

}
