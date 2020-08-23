package ru.progwards.java1.lessons.test;

public class Person2 {
    public void add(int num) {
        int[] a = new int[0];
        int[] b = new int[a.length + 1];

        System.arraycopy(a, 0, b, 0, a.length);
        b[a.length - 1] = num;
    }

    public static class Child1 {
        String hello() {
            return "привет";
        }
    }

    public class Child2 {
        String hello() {
            return "servus";
        }
    }
}

