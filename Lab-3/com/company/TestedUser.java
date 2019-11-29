package com.company;

public class TestedUser extends User {
    private int questionsCount;
    private int rightAnswersCount;

    TestedUser(String name, String login, String password)
    {
        super(name, login, password);
        questionsCount = 0;
        rightAnswersCount = 0;
    }
    TestedUser()
    {
        super();
        questionsCount = 0;
        rightAnswersCount = 0;
    }

    public void answ()
    {
        questionsCount++;
    }
    public void right()
    {
        rightAnswersCount++;
    }

    public int getResult(){
        if (questionsCount == 0)
            return 0;
        double a = (double)rightAnswersCount/questionsCount*100.0;
        return (int)a;
    }
}
