package com.company;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите длину массива: ");
        int length = in.nextInt();
        short[] array = new short[length];

        ArrayHandler handler = new ArrayHandler();

        System.out.println();
        int choose;
        boolean fill = false;

        do {
            System.out.println("\n\n");
            System.out.println("Выберите действие:");
            System.out.println("1. Вывести массив.");
            System.out.println("2. Заполнить массив с клавиатуры.");
            System.out.println("3. Заполнить массив датчиком случайных чисел");
            System.out.println("4. Определить количество элементов массива, у" +
                    "которых количество делителей меньше заданного значения.");
            System.out.println("5. Удалить из массива все числа, первая цифра которых нечетна.");
            System.out.println("6. Вывод массива в направлении справа налево.");
            System.out.println("7. Выйти.");

            choose = in.nextInt();

            switch (choose) {
                case 1:
                    if (fill){
                        System.out.println("Вывод массива:");
                        handler.showArray(array);
                    }
                    else
                        System.out.println("Заполните массив");
                    break;
                case 2:
                    System.out.println("Заполнение массива с клавиатуры:");
                    handler.keyboardFilling(array);
                    System.out.println("Массив заполнен.");
                    fill = true;
                    break;
                case 3:
                    System.out.println("Заполнение массива датчиком случайных чисел:");
                    handler.randomFilling(array);
                    fill = true;
                    System.out.println("Массив заполнен");
                    break;
                case 4:
                    if (fill){
                        System.out.println("Kоличество элементов массива, у которых количество делителей меньше заданного значения.");
                        System.out.println("Введите ограничивающее значение:");
                        int lim = in.nextInt();
                        System.out.println("Количество элементов = " + handler.arrDivCount(lim, array));
                    }
                    else
                        System.out.println("Заполните массив");
                    break;
                case 5:
                    if (fill){
                        System.out.println("Удаление из массива всех чисел, первая цифра которых нечетна:");
                        array = handler.delSomething(array);

                        System.out.println("Результат:");
                        handler.showArray(array);
                    }
                    else
                        System.out.println("Заполните массив");
                    break;
                case 6:
                    if (fill){
                        System.out.println("Вывод массива наоборот:");
                        handler.showArrayBack(array);
                    }
                    else
                        System.out.println("Заполните массив");
                    break;
                default:
                    System.out.println("Выберете номер действия");
            }
        } while (choose != 7);
        System.out.println("Выход");
        in.close();

    }
}


