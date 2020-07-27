package ru.progwards.java1.lessons.basics;
public class AccuracyDoubleFloat {
    public static void main(String[] args) {
        System.out.println(volumeBallDouble(1.0));
        System.out.println(volumeBallFloat(1.0f));
        calculateAccuracy(1.0);
    }
    public static double volumeBallDouble(double radius) {
        double pi = 3.14;
        return (4.0 / 3) * pi * Math.pow(radius, 3);
    }
    public static float volumeBallFloat(float radius) {
        float FloatPI = 3.14F;
        return (float) ((4.0F / 3) * FloatPI * Math.pow(radius, 3));
    }
    public static void calculateAccuracy(double radius) {
        float myFLO = (float) radius;
        System.out.println(volumeBallDouble(radius) - volumeBallFloat(myFLO));
    }
}