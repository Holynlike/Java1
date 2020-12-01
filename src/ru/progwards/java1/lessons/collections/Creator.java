package ru.progwards.java1.lessons.collections;

import java.util.ArrayList;
import java.util.Collection;

public class Creator {
    public static void main(String[] args) {
        fillEven(13);
        fillOdd(13);
        fill3(5);
    }

    public static Collection<Integer> fillEven(int n) {
        ArrayList<Integer> list = new ArrayList();
        for (int i = 1; i <= n; i++) {
            list.add(i * 2);
        }
        System.out.println("fillEven(int " + n + ")");
        System.out.println(list.toString());
        return list;
    }

      public static Collection<Integer> fillOdd(int n) {
        ArrayList<Integer> list = new ArrayList();
        for (int i = n; i >= 1; i--) {
            list.add(i * 2-1);
        }
        System.out.println("fillOdd(int " + n + ")");
        System.out.println(list.toString());
        return list;
    }

    public static Collection<Integer> fill3(int n){
        ArrayList<Integer> list = new ArrayList();
        for (int i = 1; i <= n; i++) {
            list.add(i);
            list.add(i*i);
            list.add(i*i*i);
        }
        System.out.println("fill3(int " + n + ")");
        System.out.println(list.toString());
        return list;
    }
}