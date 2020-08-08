package ru.progwards.java1.lessons.bitsworld;

public class CheckBit {
    public static int checkBit(byte value, int bitNumber) {
        int result = value;
        for (int i = 0; i < bitNumber; i++) {
            result = result >> 1;
        }
        return result & 1;
    }
}
