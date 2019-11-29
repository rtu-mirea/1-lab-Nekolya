package com.company;
import java.util.Scanner;

/*строки для тестирования
Часть 1 и 2:
Тут -56789.7 цифра 10.4 1.4 и 1.034 и еще -1.3245 и число 55.2 и последннее 57.0

        Часть 3 задание 1:
        fe80:0:0:0:300:f8ff:fe21:67cf

        Часть 3 задание 2:
        fe80:0:0:0:200:f8ff:fe21:67cf и ещё fe80:0:54:0:200:f8ff:fe21:67cf и fe80:43:0:0:200:f8ff:fe21:67cf ++ fe80:0:0:0:300:f8ff:fe21:67cf
        */

public class Main {

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку");
        String text = in.nextLine();

        StringClass sText = new StringClass(text);
        BString bText = new BString(text);
        Regular reText = new Regular(text);

        System.out.println();
        int choose;
        boolean fill = false;

        do {
            System.out.println("\n");
            System.out.println("Выберите действие:");
            System.out.println("-------Блок String-------");
            System.out.println("1. Найти максимальное число текста.");
            System.out.println("2. Сформировать новый текст, в котором, числа с плавающей точкой " +
                    "заменить числами с фиксированной точкой с точностью два знака");
            System.out.println("3. Все слова, стоящие непосредственно перед числом с плавающей" +
                    "точкой в исходной строке, записать прописными буквами и\n" +
                    "сформировать из них строку, в которой слова разделяются одним" +
                    "пробелом.");
            System.out.println("4. Определить, сколько слов в сформированной строке начинаются с " +
                    "заданной буквы.");
            System.out.println("-------Блок StringBuilder-------");
            System.out.println("5. Изменить текст, числа с плавающей точкой заменить числами с " +
                    "фиксированной точкой с точностью два знака после точки.");
            System.out.println("6. Найти сумму чисел в тексте, добавить в конец текста, представив в " +
                    "форме с плавающей точкой.");
            System.out.println("7. Вставить новое число перед каждым числом с большим значением.");
            System.out.println("-------Блок Регулярные выражения-------");
            System.out.println("8. Поверить соответствие строки формату IP-адреса v6.");
            System.out.println("9. В тексте найти все строки со значением IP-адреса v6 и " +
                    "заменить его элементы на числа в 16 системе счисления.");
            System.out.println("10. Выйти.");

            choose = in.nextInt();

            switch (choose) {
                case 1:
                    System.out.println("Max value: " + sText.findMax());
                    break;
                case 2:
                    System.out.println("Точность 2 знака после запятой:" + sText.formattedString());
                    break;
                case 3:
                    System.out.println("Caps:" + sText.caps());
                    break;
                case 4:
                    System.out.print("Введите символ: ");
                    text = in.next();
                    char ch = text.toCharArray()[0];
                    System.out.println("Количество слов, начинающихся с " + ch + " : " + sText.findWords(ch));
                    break;
                case 5:
                    System.out.println("Точность 2 знака после запятой: " + bText.formattedString());
                    break;
                case 6:
                    System.out.println("Строка с суммой вконце: " + bText.appendSum());
                    break;
                case 7:
                    System.out.println("Новое число перед каждым ольшим числом: " + bText.paste());
                    break;
                case 8:
                    if(reText.isIPV6())
                        System.out.println("Соответствует");
                    else
                        System.out.println("Не соответствует");
                    break;
                case 9:
                    System.out.println(reText.replace());
                    break;
                default:
                    System.out.println("Выберете номер действия");
            }
        } while (choose != 10);
        System.out.println("Выход");
        in.close();
    }
}
