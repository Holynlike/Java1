package ru.progwards.java1.lessons.bigints;

import java.math.BigInteger;

public class Test_Big_Number {
    public static void main(String[] args) {
        ArrayInteger ai1 = new ArrayInteger(1);
        ai1.fromInt(new BigInteger("-7"));
        ArrayInteger ai2 = new ArrayInteger(1);
        ai2.fromInt(new BigInteger("-7"));

        ai1.add(ai2);
        System.out.println(ai1.toInt());
        System.out.println("-14 - должно быть ");
    }
    public static String My_Random(int l){
        Double d = Math.random() * Math.pow(10,l);
        String[] a = String.valueOf(d.toString()).split("[.]");
        return a[0];
    }
}
