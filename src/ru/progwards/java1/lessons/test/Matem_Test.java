package ru.progwards.java1.lessons.test;

public class Matem_Test {

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.println(i + " * " + j + " = " + Matemat.Умножить(i, j));
            }
            System.out.println("\n===========");
        }
    }

}
