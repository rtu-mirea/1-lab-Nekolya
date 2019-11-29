package com.company;
/*
Дан текст отчета по проведенному эксперименту, в котором помимо слов содержатся
числовые значения, представленные в форме с плавающей точкой.
•	Изменить текст, числа с плавающей точкой заменить числами
с фиксированной точкой с точностью два знака после точки.
•	Найти сумму чисел в тексте, добавить в конец текста, представив в форме с плавающей точкой.
•	Вставить новое число перед каждым числом с большим значением...(?)
 */
public class BString {
    private String text;
    private StringBuilder formatted = new StringBuilder();
    private StringBuilder sum = new StringBuilder();
    private StringBuilder newNum = new StringBuilder();

    BString(String t) {
        text = t;
    }

    public StringBuilder formattedString() {
        formatted.setLength(0);
        double digit = 0;
        for (String word : text.split(" ")) {
            try {
                digit = Double.parseDouble(word);
                formatted.append(String.format("%.2f", digit));

            } catch(NumberFormatException e) {

                formatted.append(word);
            }
            formatted.append(" ");
        }
        return formatted;
    }

    public StringBuilder appendSum() {
        double digit = 0;
        sum.setLength(0);
        double res = 0;
        sum.append(text).append(" ");
        for (String word : text.split(" ")) {
            try {
                digit = Double.parseDouble(word);
                res += digit;

            } catch (NumberFormatException e) {
            }
        }
        return sum.append(res);
    }


    public StringBuilder paste() {
        int counter = 1;
        double max = Integer.MIN_VALUE;
        double digit = 0;
        newNum.setLength(0);
        for (String word : text.split(" ")) {
            try {
                digit = Double.parseDouble(word);
                if (digit > max){
                    max = digit;
                    newNum.append(counter).append(" max) ").append(word);
                    counter++;
                }
                else
                    newNum.append(word);
            } catch(NumberFormatException e) {
                newNum.append(word);
            }
            newNum.append(" ");
        }
        return newNum;

    }
}
