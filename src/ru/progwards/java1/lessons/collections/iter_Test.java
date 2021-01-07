package ru.progwards.java1.lessons.collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class iter_Test {
    public static void main(String[] args) {
        iSetTest();
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
    public static void iSetTest() {
        Set<Integer>  fiboSet1000 =
                Set.of(0, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987);
        int sum = 0;
        for (int i = 2; i < 10; i++)
            sum += fiboSet1000.contains(i) ? 1 : 0;
        System.out.println(sum+" - сайз");
    }
}
