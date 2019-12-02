package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Tester tester = new Tester();
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Admin admin = new Admin("Админ", "admin", "admin");
        int swicher = -1;
        boolean flag = true;
        var main = new Main();

        boolean adminFlag = false;
        while (true){

            if (adminFlag){
                flag = true;
                System.out.println("Что нужно сделать?");
                System.out.println("1. Добавить пользователя.");
                System.out.println("2. Авторизировать пользователя и начать тест.");
                System.out.println("3. Добавить вопрос.");
                System.out.println("4. Показать результаты теста.");
                System.out.println("5. Закончить работу.");

                while (flag) {
                    if (in.hasNextInt()) {
                        swicher = in.nextInt();
                        flag = false;
                    } else {
                        System.out.println("Вы ввели не число");
                        in.nextLine(); //чищу input buffer
                    }
                }
                in.nextLine();

                switch (swicher){
                    case 1:
                        main.createNewUser();
                        break;

                    case 2:
                        main.enter();
                        adminFlag = false;
                        break;
                    case 3:
                        main.addQuestion();
                        break;
                    case 4:
                        System.out.println(tester.getResult());
                        break;
                    case 5:
                        return;
                }
            }

            else {
                System.out.println("Войдите в систему!");
                System.out.print("\nВведите логин: ");
                String login = in.nextLine();
                System.out.print("\nВведите пароль: ");
                String password = in.nextLine();

                if (admin.enter(password, login)) {
                    System.out.println("Вход выполнен, администратор!");
                    adminFlag = true;
                }
                else{
                    if (!tester.findUser(login, password))
                    {
                        System.out.println("Такого пользователя нет в системе");
                    }
                    else
                        main.startTest();


                }

            }


        }
    }
    private void createNewUser(){
        System.out.print("\nВведите своё имя: ");
        String name = in.nextLine();
        System.out.print("\nВведите логин: ");
        String login = in.nextLine();
        System.out.print("\nВведите пароль: ");
        String password = in.nextLine();
        tester.addUser(name, login, password);
    }

    private void enter(){
        System.out.print("\nВведите логин: ");
        String login = in.nextLine();
        System.out.print("\nВведите пароль: ");
        String password = in.nextLine();
        if (!tester.findUser(login, password))
        {
            System.out.println("Такого пользователя нет в системе");
            return;
        }

        startTest();

    }

    private void startTest()
    {
        TestedUser currentUser = tester.getCurrentUser();
        System.out.println("Здравствуйте, " + currentUser.getName());
        System.out.println("Тестирование началось!\n");
        int answ = -1;
        Scanner in = new Scanner(System.in);
        boolean flag = true;
        int counter = 1;

        ArrayList<Question> questions = tester.getQuestions();

        for(int i = 0; i<questions.size(); i++){
            flag = true;
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

    private void addQuestion(){

        System.out.print("\nВведите вопрос: ");
        String question = in.nextLine();

        String[] answers = new String[4];
        System.out.println("Введите 4 варианта ответа\n");

        int counter = 0;

        while (counter!=4) {
            answers[counter] = in.nextLine();
            counter += 1;
        }
        int rightAnsw = -1;
        boolean flag = true;
        System.out.println("\nНомер правильного ответа: ");

        while (flag) {
            if (in.hasNextInt()) {
                rightAnsw = in.nextInt();
                flag = false;
            } else {
                System.out.println("Вы ввели не число");
                in.nextLine();
            }
        }
        in.nextLine();

        tester.addQuestion(new Question(question, answers, rightAnsw));
        System.out.println("Вопрос добавлен!");
    }

}
