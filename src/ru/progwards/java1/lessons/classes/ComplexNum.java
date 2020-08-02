package ru.progwards.java1.lessons.classes;

public class ComplexNum {
    int a, b;

    public ComplexNum(int a, int b) {
        this.a = a;
        this.b = b;
    } // Конструктор

    public static void main(String[] args) {
        System.out.println();
    }

    @Override
    public String toString() {
        return Integer.toString(a) + "+" + Integer.toString(b) + "i";
    }
    // приведение к строке, выдать в формате a+bi, например, при a=1 и b=56 должно быть выдано 1+56i
    //public ComplexNum add(ComplexNum num){ //сложение комплексных чисел по формуле: (a + bi) + (c + di) = (a + c) + (b + d)i

    //}


}
