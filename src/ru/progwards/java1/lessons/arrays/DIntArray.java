package ru.progwards.java1.lessons.arrays;
import java.util.Arrays;
public class DIntArray {
    private int[] arr1 = new int[0];
    private int[] arr2;
    public DIntArray() {
    } // Конструктор по-умолчанию

    public void add(int num) {//добавляет элемент num в конец массива
        arr2 = new int[arr1.length];
        arr2 = Arrays.copyOf(arr1, arr1.length);// во второй массив копирую первый
        arr1 = new int[arr1.length + 1]; // меняю размер первого массива
        arr1 = Arrays.copyOf(arr2, arr2.length + 1);// второй массив копирую обратно в первый
        arr1[arr1.length - 1] = num;  // наконец, в первом прописываю в последний элемент значение num
    }

    public void atInsert(int pos, int num) {     // Добавить элемент num в pos - позицию в массиве
        int[] arr3 = new int[arr1.length - pos]; //  создадим новый, буферный массив.
        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = arr1[pos + i];
        }
        arr2 = new int[arr1.length];
        arr2 = Arrays.copyOf(arr1, arr1.length); // во второй массив копирую первый
        arr1 = new int[arr1.length + 1]; // меняю размер первого массива

        for (int i = 0; i < pos - 1; i++) {
            arr1[i] = arr2[i];
        }
        arr1[pos - 1] = num; // вписываем нужное значение в массив
        for (int i = pos; i < arr1.length; i++) {
            arr1[i] = arr2[i - 1];
        }
    }

    public void atDelete(int pos) {  // Удаление значения в позиции pos
        arr2 = new int[arr1.length]; // копия массива
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr1 = new int[arr1.length - 1];
        for (int i = 0; i <= pos; i++) { // до pos копируем значения в ццикле
            arr1[i] = arr2[i];
        }
        for (int i = pos; i < arr2.length; i++) { // после pos копируем значения в цикле
            arr1[i - 1] = arr2[i];
        }
    }

    public int at(int pos) {
        if (arr1.length == 0) {
            return arr1[0];
        } else {
            return arr1[pos];
        }
    }// Добавлю пару тестировочных функций:

    public int myLen() {
        return arr1.length;
    } // - для показа количества элементов в массиве

    public void Show() {
        System.out.println(Arrays.toString(arr1));
    }//для вывода всего массива в консольку
}