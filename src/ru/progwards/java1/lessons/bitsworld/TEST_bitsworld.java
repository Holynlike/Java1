package ru.progwards.java1.lessons.bitsworld;

public class TEST_bitsworld {
    public static void main(String[] args) {
        System.out.println(SumBits.sumBits((byte) 98)); // Тестируем sumBits
        for (int i = 0; i < 8; i++) {
            System.out.print(CheckBit.checkBit((byte) 170, i)); // Ожидается 1010 1010
        }
        Binary BIN = new Binary((byte) -128);
        System.out.println();
        System.out.println(BIN.toString());
    }
}
