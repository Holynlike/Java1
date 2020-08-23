package ru.progwards.java1.lessons.test;

public class Dog implements Speaking, Eating {
    @Override
    public String eat() {
        return "Мясо";
    }

    @Override
    public String say() {
        return "Гав";
    }
}