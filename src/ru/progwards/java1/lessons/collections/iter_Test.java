package ru.progwards.java1.lessons.collections;

import java.util.Arrays;

public class iter_Test {
    public static void main(String[] args) {
        String[][] aaa = {{"1","2","3"},{"4","5","6"},{"7","8","9"}};
        System.out.println(new MatrixIterator<String>(aaa).myLEN);
        String[] a = new String[]{"Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота", "Воскресенье"};
        int[] o = new int[4];
        Arrays.fill(o, 32);
        ArrayIterator AI = new ArrayIterator(a);
        for (int i = 0; AI.hasNext(); i++) {
            System.out.println(AI.next());
        }
        MatrixIterator MI = new MatrixIterator<String>(aaa);
        for (int i = 0; MI.hasNext(); i++) {
            System.out.println(MI.next());
        }
    }
}
