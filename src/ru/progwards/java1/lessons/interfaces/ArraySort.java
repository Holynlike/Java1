package ru.progwards.java1.lessons.interfaces;

public class ArraySort implements CompareWeight {
    int SortedArr[];

    public static void sort(CompareWeight[] a) {
        CompareWeight tmp;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i].compareWeight(a[j]) == CompareResult.GREATER) {
                    tmp = a[j];
                    a[j] = a[i];
                    a[i] = tmp;
                }
            }
        }
    }

    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeigt) {
        return null;
    }
}