package ru.progwards.java1.lessons.test;

public class Calculator {
    private int result;

    public Calculator() {
        result = 0;
    }

    public void set(int num) {
        result = num;
    }

    public void add(int num) {
        result += num;
    }

    public void sub(int num) {
        result -= num;
    }

    public int getResult() {
        return result;
    }
}