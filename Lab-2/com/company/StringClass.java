package com.company;
    /*
    Создать класс с именем, определяющим номер задания, для решения задач
варианта.
2.1. Данными класса должен быть входной текст и дополнительные строки
для промежуточных вычислений.
2.2. Основные операции указаны в варианте. Их надо оформить методами
созданного класса. Если операция содержит отдельную задачу, то ее
так же оформить отдельным методом.
2.3. При разработке методов класса использовать объект и методы класса
String.
    Дан текст отчета по проведенному эксперименту, в котором помимо
слов содержатся числовые значения, представленные в форме с
плавающей точкой.
 Найти максимальное число текста.
 Сформировать новый текст, в котором, числа с плавающей точкой
заменить числами с фиксированной точкой с точностью два знака
после точки.
 Все слова, стоящие непосредственно перед числом с плавающей
точкой в исходной строке, записать прописными буквами и
сформировать из них строку, в которой слова разделяются одним
пробелом.
 Определить, сколько слов в сформированной строке начинаются с
заданной буквы.
    * */

import java.security.PrivateKey;

public class StringClass {
    private String text;
    private String formatted;
    private String caps;

    StringClass(String t) {
        text = t;
    }
    public String findMax() { //не может быть дабл, потому что цифр в сообщении может не быть
        double max = Integer.MIN_VALUE;
        boolean flag = true;
        double digit = 0;
        for (String word : text.split(" ")) {
            try {
                digit = Double.parseDouble(word);
                if (digit > max)
                    max = digit;
            } catch(NumberFormatException e) {

            }
        }
        if (flag)
            return Double.toString(max);
        return "Чисел не найдено";
    }

    public String formattedString() {
        double digit = 0;
        formatted = "";
        for (String word : text.split(" ")) {
            try {
                digit = Double.parseDouble(word);
                formatted += " " + String.format("%.2f", digit);

            } catch(NumberFormatException e) {
                formatted += " " + word;
            }
        }
        return formatted;
    }

    public String caps() {
        double digit = 0;
        caps = "";
        String[] words =  text.split(" ");
        for (int i = 0; i < words.length-1; i++) {
            try {
                digit = Double.parseDouble(words[i+1]); //Если предыдущее слово тоже цифра
                try {
                    digit = Double.parseDouble(words[i]);
                } catch(NumberFormatException e) {
                    caps += " " + words[i].toUpperCase();
                }
            } catch(NumberFormatException e) {

            }
        }
        return caps;
    }

    public String findWords(char ch) {
        int counter = 0;
        for (String word : text.split(" ")) {
            if (word.toCharArray()[0] == ch)
                counter++;
        }
        return Integer.toString(counter);
    }
}
