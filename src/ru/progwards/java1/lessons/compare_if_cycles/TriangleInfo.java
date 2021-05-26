package ru.progwards.java1.lessons.compare_if_cycles;

public class TriangleInfo {
    public static void main(String[] args) {
        System.out.println("Вызвана функция isTriangle: с параметрами 3, 4, 5 " + isTriangle(3, 4, 5));
        System.out.println("Вызвана функция isTriangle: с параметрами 1, 4, 5 " + isTriangle(1, 4, 5));
        System.out.println("Вызвана функция isTriangle: с параметрами 1, 2, 2 " + isTriangle(1, 2, 2));
        System.out.println(isTriangle2(3, 4, 5));
        System.out.println(isTriangle2(1, 4, 5));
        System.out.println(isTriangle2(1, 2, 2));
        System.out.println(isTriangle3(3, 4, 5));
        System.out.println(isTriangle3(1, 4, 5));
        System.out.println(isTriangle3(1, 2, 2));
    }

    // Вариант 1
    public static boolean isTriangle(int a, int b, int c) {
        return a < (b + c) && b < (a + c) && c < (a + b);
    }

    // Вариант 2
    public static boolean isTriangle2(int a, int b, int c) {
        if ((a + b) > c && (a + c) > b && (c + b) > a) {
            return true;
        } else {
            return false;
        }
    }

    // Вариант 3
    public static boolean isTriangle3(int a, int b, int c) {return ((a + b) > c && (a + c) > b && (c + b) > a);}

    // Вариант 4
    public static boolean isTriangle4(int a, int b, int c) {
        return ((a + b) < c | (a + c) < b && (c + b) > a);
    }

    public static boolean isRightTriangle(int a, int b, int c) {
        System.out.println("Вызвана функция isRightTriangle с параметрами: " + a + ", " + b + ", " + c);
        boolean BLNisRightTriangle = false;
        if (Math.pow(a, 2) == (Math.pow(b, 2) + Math.pow(c, 2))) {
            BLNisRightTriangle = true;
        } else if (Math.pow(b, 2) == (Math.pow(a, 2) + Math.pow(c, 2))) {
            BLNisRightTriangle = true;
        } else if (Math.pow(c, 2) == (Math.pow(a, 2) + Math.pow(b, 2))) {
            BLNisRightTriangle = true;
        }
        System.out.println("Результат: " + BLNisRightTriangle);
        return BLNisRightTriangle;
    }
    public static boolean isIsoscelesTriangle(int a, int b, int c){
        System.out.println("Вызвана функция isIsoscelesTriangle с параметрами: " + a + ", " + b + ", " + c);
        boolean BLNisIsoscelesTriangle = false;
        if (a == b | b == c | a == c){
            BLNisIsoscelesTriangle = true;
        }
        System.out.println("Результат: " + BLNisIsoscelesTriangle);
        return BLNisIsoscelesTriangle;
    }
}