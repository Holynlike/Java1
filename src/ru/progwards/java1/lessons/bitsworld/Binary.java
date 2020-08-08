package ru.progwards.java1.lessons.bitsworld;

public class Binary {
    public byte Bnum;

    public Binary(byte num) {
        this.Bnum = num;
    }

    public String toString() {
        int res2;
        String result = "";
        res2 = Bnum;
        for (int i = 0; i < 8; i++) {
            result = Integer.toString(res2 & 1) + result;
            res2 = res2 >> 1;
        }
        return result;
    }
}
