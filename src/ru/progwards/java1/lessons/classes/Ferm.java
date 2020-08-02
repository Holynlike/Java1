package ru.progwards.java1.lessons.classes;

public class Ferm {
    public static void main(String[] args) {
        Cow Burenka = new Cow(320);
        System.out.println(Burenka.toStringFull());
        Hamster Mickie = new Hamster(5);
        System.out.println(Mickie.toStringFull());
        Duck Donald = new Duck(30);
        System.out.println(Donald.toStringFull());
        ComplexNum Standalone = new ComplexNum(1, 56);
        System.out.println(Standalone.toString());
        ComplexNum complex2 = new ComplexNum(3, 6);
        Standalone.add(complex2);
        System.out.println(Standalone.toString());
    }
}
