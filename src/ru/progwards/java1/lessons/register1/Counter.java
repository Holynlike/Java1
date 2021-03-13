package ru.progwards.java1.lessons.register1;

public class Counter {
    public static ByteRegister value1;

    public static void main(String[] args) {
        ByteRegister br = new ByteRegister((byte) 5);
        byte b = 0;
        for (int i = 1; i <= 265; i++) {
            b++;
            System.out.println(b);
        }

        for (int i = 0; i < 7; i++) {
            dec(br);
            br = Counter.value1;
            System.out.println(br.toDecString());
        }
    }

    public static void inc(ByteRegister value) {
        byte tmp = (byte) Integer.parseInt(value.toDecString());
        tmp++;
        if (tmp < 255) {
            value1 = new ByteRegister(tmp);
        } else {
            value1 = new ByteRegister((byte) 0);
        }
    }

    public static void dec(ByteRegister value) {
        byte tmp = (byte) Integer.parseInt(value.toDecString());
        tmp--;
        if (tmp >= 0) {
            value1 = new ByteRegister(tmp);
        } else {
            value1 = new ByteRegister((byte) 255);
        }
    }
}