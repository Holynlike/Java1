package ru.progwards.java1.lessons.compare_if_cycles;

public class TriangleSimpleInfo {
    public static void main(String[] args) {
        maxSide(1,2,3);
        maxSide(1,20,3);
        maxSide(10,2,3);
        minSide(1,2,3);
        minSide(1,20,3);
        minSide(10,2,3);
        System.out.println(isEquilateralTriangle(6,6,6));
        System.out.println(isEquilateralTriangle(6,6,5));
    }
    public static int maxSide(int a, int b, int c){
        System.out.println("Вызвана функция maxSide с параметрами " + a + ", " + b + ", " + c);
        int result = a;
        if (result < b) {
            result = b;
        }
        if (result < c) {
            result = c;
        }
        System.out.println("Самая длинная сторона треугольника =  " + result);
        return result;
    }
    public static int minSide(int a, int b, int c){
        System.out.println("Вызвана функция minSide с параметрами " + a + ", " + b + ", " + c);
        int result = a;
        if (result > b) {
            result = b;
        }
        if (result > c) {
            result = c;
        }
        System.out.println("Самая короткая сторона треугольника =  " + result);
        return result;
    }
    public static boolean isEquilateralTriangle(int a, int b, int c){
        boolean BLNResult = false;
        if (a == b & b == c) {
            BLNResult = true;
        }
            return BLNResult;
        }
}