package ru.progwards.java1.lessons.bitsworld;

public class SumBits {

    public static int sumBits(byte value) {
        int result = 0;
        int result2 = value;
        for (int i = 0; i < 8; i++) {
            result += result2 & 1;
            result2 = result2 >> 1;
        }
        return result;
    }
}