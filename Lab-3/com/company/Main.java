package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Admin admin = new Admin("Админ", "admin", "admin");
	    Tester tester = new Tester();
        int swicher = -1;
        Scanner in = new Scanner(System.in);
        boolean flag = true;

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
                        createNewUser(tester, in);
                        break;

                    case 2:
                        enter(tester, in);
                        adminFlag = false;
                        break;
                    case 3:
                        addQuestion(tester, in);
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
                        tester.startTest();


                }

            }


        }
    }
    public static void createNewUser(Tester tester, Scanner in){
        System.out.print("\nВведите своё имя: ");
        String name = in.nextLine();
        System.out.print("\nВведите логин: ");
        String login = in.nextLine();
        System.out.print("\nВведите пароль: ");
        String password = in.nextLine();
        tester.addUser(name, login, password);
    }

    public static void enter(Tester tester, Scanner in){
        System.out.print("\nВведите логин: ");
        String login = in.nextLine();
        System.out.print("\nВведите пароль: ");
        String password = in.nextLine();
        if (!tester.findUser(login, password))
        {
            System.out.println("Такого пользователя нет в системе");
            return;
        }

        tester.startTest();

    }

    public static void addQuestion(Tester tester, Scanner in){

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
