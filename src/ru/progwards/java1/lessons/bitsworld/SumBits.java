package ru.progwards.java1.lessons.bitsworld;

public class SumBits {

    public static int sumBits(byte value) {
        int grade = 4;
        if (value > 15 || value < -15) {
            grade = 8;
        }
        int result = 0;
        int result2;
        result2 = value;

        for (int i = 0; i < grade; i++) {
            result += result2 & 1;
            result2 = result2 >>> 1;
        }
        return result;
    }
}