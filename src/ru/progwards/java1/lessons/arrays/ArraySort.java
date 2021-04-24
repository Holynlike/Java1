package ru.progwards.java1.lessons.arrays;

public class ArraySort {
    int SortedArr[];

    public static void sort(int[] a) { // Классика, сортировка - пузырек
        int tmp; // сам пузырек
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) { // сравнение
                    tmp = a[j];
                    a[j] = a[i];
                    a[i] = tmp; // обмен
                }
            }
        }
    }
}
