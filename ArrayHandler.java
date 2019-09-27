package com.company;

import java.util.Random;
import java.util.Scanner;

public class ArrayHandler {

    ArrayHandler(){

    }

    short[] keyboardFilling(short[] arr) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++)
            arr[i] = in.nextShort();
        return arr;
    }

    short[] randomFilling(short[] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++)
            //arr[i] = (short) random.nextInt(1 << 15);
            arr[i] = (short)random.nextInt(50);
        return arr;
    }

    void showArray(short[] arr) {
        for (short i: arr)
            System.out.print(i + " ");
    }
    void showArrayBack(short[] arr) {
        for (int i = arr.length-1; i >= 0; i--)
            System.out.print(arr[i] + " ");
    }

/*
    Определить количество элементов массива, у
которых количество делителей меньше заданного
значения.

    Удалить из массива все числа, первая цифра
которых нечетна.
*/

    int arrDivCount(int lim, short[] arr){
        int counter = 0;
        for (short i: arr){
            if (lim>divCount(i))
                counter++;
        }
        return counter;
    }

    private int divCount(short a) {
        short i = 2;
        int counter = 2;
        while (i < a / 2 + 1) {
            if (a % i == 0)
                counter++;
            i++;
        }
        return counter;
    }

    short[] delSomething(short[] arr){
        int len = arr.length;
        int newLen = arr.length;
        for (int i = 0; i < len; i++){
            if(checkFirstNum(arr[i])){
                for(int j = i; j < arr.length - 1; j++)
                    arr[j] = arr [j+1];
                i--;
                len--;
                newLen--;
            }
        }
        short[] newArr =  new short[newLen];
        System.arraycopy(arr, 0, newArr, 0, newLen);
        arr = new short[newLen];
        //System.arraycopy(newArr, 0, arr, 0, newLen);
        arr = newArr;

        return arr;
    }

    private boolean checkFirstNum(short a){
        while(a>9)
            a/=10;
        //System.out.print(a + " ");
        //System.out.println(a%2==1);
        return (a%2==1);
    }

}

