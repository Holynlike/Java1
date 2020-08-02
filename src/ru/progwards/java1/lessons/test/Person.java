package ru.progwards.java1.lessons.test;

public class Person {
    private String name;
    private int age;
    private String country;

    public Person() {
        country = "RU";
    } // Конструктор по умолчанию

    public Person(String name, int age) { // Конструктор, вызываемый с параметрами
        this();
        this.age = age;
        this.country = country;
        this.name = name;
    }

    public String getName() {
        return name;
    } // Вернуть имя

    public int getAge() {
        return age;
    } // Вернуть возраст

    public String getCountry() {
        return country;
    } // Вернуть страну
}