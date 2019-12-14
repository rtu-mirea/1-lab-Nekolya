package com.company;

import java.io.Serializable;

public class DisciplineAssessment implements Serializable {
    private int gradebookNumber;
    private String cipher;
    private String discipline;
    private String date;
    private int assessment;
    private String teacherSurname;

    DisciplineAssessment(int gN, String cip, String disc,
                         String dat, int assess, String tSurname){
        gradebookNumber = gN;
        cipher = cip;
        discipline = disc;
        date = dat;
        assessment = assess;
        teacherSurname = firstUpperCase(tSurname);
    }

    private String firstUpperCase(String word){
        if(word == null || word.isEmpty()) return word; //или return word;
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }

    public int getAssessmentBy(int gradebookNum, String disc){
        if (gradebookNum == gradebookNumber && disc.equals(discipline)) {
            return assessment;
        }
        return -1;
    }


    public boolean sameDD(DisciplineAssessment d){
        if (date == d.date && discipline == d.discipline)
            return true;
        return false;
    }

    public boolean setAssessment(int gradebookNum, int assessment) {
        if (gradebookNumber == gradebookNum) {
            this.assessment = assessment;
            return true;
        }
        return false;
    }


    public void increaseLength(){
        cipher = expand(cipher);
        discipline = expand(discipline);
        date= expand(date);
        teacherSurname = expand(teacherSurname);
    }

    private String expand(String str){
        for(int i = str.length(); i < 16; i++)
            str += " ";
        return str;
    }

    public String getInfo(){
        StringBuilder result = new StringBuilder();
        result.append("Номер зачетной книжки: ").append(gradebookNumber);
        result.append("\nШифр группы: ").append(cipher);
        result.append("\nДисциплина: ").append(discipline);
        result.append("\nДата: ").append(date);
        result.append("\nОценка: ").append(assessment);
        result.append("\nФимилия преподавателя: ").append(teacherSurname);
        return result.toString();
    }

    public String getCipher() {
        return cipher;
    }

    public String getDiscipline() {
        return discipline;
    }

    public String getDate() {
        return date;
    }

    public String getTeacherSurname() {
        return teacherSurname;
    }

    public int getAssessment() {
        return assessment;
    }
    public int getGradebookNumber() {
        return gradebookNumber;
    }
}
