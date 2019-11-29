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

    public void startTest(){
        System.out.println("Здравствуйте, " + currentUser.getName());
        System.out.println("Тестирование началось!\n");
        int answ = -1;
        Scanner in = new Scanner(System.in);
        boolean flag = true;
        int counter = 1;
        for(int i = 0; i<questions.size(); i++){
            System.out.println(i + 1 + ". "+ questions.get(i).getText());
            counter = 1;
            for(String answer: questions.get(i).getAnswers())
                System.out.println(counter++ + ") " + answer);


            while (flag) {
                if (in.hasNextInt()) {
                    answ = in.nextInt();
                    flag = false;
                } else {
                    System.out.println("Вы ввели не число");
                    in.nextLine();
                }
            }
            in.nextLine();

            if (questions.get(i).isCorrect(answ)) {
                currentUser.right();
            }
            currentUser.answ();
        }
        System.out.println("Тест окончен!");
    }

    public String getResult(){
        StringBuilder res = new StringBuilder("Результаты тестирования:");
        for(int i = 0; i<users.size(); i++){
            res.append("\n").append(users.get(i).getName()).append(" - ").append(users.get(i).getResult()).append("%");
        }
        return res.toString();

    }

}
