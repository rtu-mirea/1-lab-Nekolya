package com.company;

public class Question {
    private String text;
    private String[] answers;
    private int rightAnswer;

    public String getText() {
        return text;
    }

    public String[] getAnswers() {
        return answers;
    }


    Question(String t, String[] a, int r){
        text = t;
        answers = a;
        rightAnswer = r;
    }
    Question()
    {
        text = "";
        answers = new String[]{};
        rightAnswer = -1;
    }

    public boolean isCorrect(int answ) {
        if(rightAnswer==answ)
            return true;
        return false;
    }
}