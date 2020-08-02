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

    public ComplexNum add(ComplexNum num) { //сложение комплексных чисел по формуле:  (a + bi) + (c + di) = (a + c) + (b + d)i
        return new ComplexNum(this.a += num.a, this.b += num.b);
    }

    public ComplexNum sub(ComplexNum num) { //вычитание комплексных чисел по формуле: (a + bi) - (c + di) = (a - c) + (b - d)i
        return new ComplexNum(this.a -= num.a, this.b -= num.b);
    }

    public ComplexNum mul(ComplexNum num) {  //  (a + bi) * (c + di) = (a*c - b*d) + (b*c + a*d)i
        int c = num.a, d = num.b, resultA, resultB;
        int a = this.a, b = this.b;
        resultA = (a * c - b * d);
        resultB = (b * c + a * d);
        return new ComplexNum(resultA, resultB);
    }

    public ComplexNum div(ComplexNum num) {
        int c = num.a, d = num.b, resultA, resultB;
        int a = this.a, b = this.b;
        resultA = (a * c + b * d) / (c * c + d * d);
        resultB = (b * c - a * d) / (c * c + d * d);
        return new ComplexNum(resultA, resultB);
    }
}
