package ru.progwards.java1.lessons.test;

public class Goat implements Speaking, Eating {
    @Override
    public String eat() {
        return "Сено";
    }

    @Override
    public String say() {
        return "Мее";
    }
}