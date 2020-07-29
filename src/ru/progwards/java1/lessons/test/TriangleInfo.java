package ru.progwards.java1.lessons.test;

public class TriangleInfo {
    public static void main(String[] args) {
        isTriangle(1,2,8);
        isTriangle(1,2,1);
        isRightTriangle(1,2,1);
        isRightTriangle(3,4,5);
        isIsoscelesTriangle(1,2,1);
        isIsoscelesTriangle(1,2,3);
    }
    public static boolean isTriangle(int a, int b, int c){
        System.out.println("Вызвана функция isTriangle с параметрами: " + a + ", " + b + ", " + c);
        boolean BLNistriangle = true;
        if (a > (b + c) | b > (a+c) | c > (a+b)) {
            BLNistriangle = false;
        }
        System.out.println("Результат: " + BLNistriangle);
        return BLNistriangle;
    }
    public static boolean isRightTriangle(int a, int b, int c) {
        System.out.println("Вызвана функция isRightTriangle с параметрами: " + a + ", " + b + ", " + c);
        boolean BLNisRightTriangle = false;
        double Da = a, Db = b, Dc = c;
        if (Math.pow(Da, 2) == (Math.pow(Db, 2) + Math.pow(Dc, 2))) {
            BLNisRightTriangle = true;
        } else if (Math.pow(Db, 2) == (Math.pow(Da, 2) + Math.pow(Dc, 2))) {
            BLNisRightTriangle = true;
        } else if (Math.pow(Dc, 2) == (Math.pow(Da, 2) + Math.pow(Db, 2))) {
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
