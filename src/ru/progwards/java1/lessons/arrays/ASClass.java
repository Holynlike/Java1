package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class ASClass {
    public static int arrayMax(int[] a) {
        Arrays.sort(a);
        if (a.length == 0) {
            return 0;
        } else {
            return a[a.length - 1];
        }
    }
}
