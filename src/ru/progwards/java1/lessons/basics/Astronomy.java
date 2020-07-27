package ru.progwards.java1.lessons.basics;
public class Astronomy {
    public static void main(String[] args) {
        System.out.println(sphereSquare(510.7912004420851));
        System.out.println(earthSquare());
        System.out.println(mercurySquare());
        System.out.println(jupiterSquare());
        System.out.println(earthVsMercury());
        System.out.println(earthVsJupiter());
    }
    public static double sphereSquare(Double r) {
        double pi = 3.14;
        return 4.0 * pi * Math.pow(r, 2);
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
    public static Double earthVsJupiter(){
        return earthSquare() / jupiterSquare();
    }
}