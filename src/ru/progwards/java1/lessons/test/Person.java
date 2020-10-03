package ru.progwards.java1.lessons.test;

public class Person {

    public static void main(String[] args) {
        System.out.println(Child1.hello());
        Person People = new Person();
        People.Mani();
    }
    public void Mani(){
        Child2 C2 = new Child2();
        System.out.println(C2.hello());
    }
    public class Child2{
        public String hello(){return "servus";}
    }
    Child1.surrounder S;
Child1 C3 = new Child1();
//    {
//        S = new Child1.surrounder;
//    }

    public static class Child1{
        public class surrounder{

        }
        public static String hello(){return "привет";}
    }










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