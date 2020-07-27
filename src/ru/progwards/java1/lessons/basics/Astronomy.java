package ru.progwards.java1.lessons.basics;

public class Astronomy {
    public static void main(String[] args) {
        System.out.println(earthSquare()); //Работает
        System.out.println(mercurySquare()); //Работает
        System.out.println(jupiterSquare()); //Работает
        System.out.println(earthVsMercury()); //Работает
    }

    public static double sphereSquare(Double r) {
        double pi = 3.14;
        return Math.pow(4.0 * pi * r, 2);
    }

    public static Double earthSquare() {
        return sphereSquare(6371.2);
    }

    public static Double mercurySquare() {
        return sphereSquare(2439.7);
    }

    public static Double jupiterSquare() {
        return sphereSquare(71492.0);
    }

    public static Double earthVsMercury() {
        return earthSquare() / mercurySquare();
    }
}

