package ru.progwards.java1.lessons.bigints;

import java.math.BigInteger;

public class Test_Big_Number {
    public static void main(String[] args) {
//        IntInteger inti = new IntInteger("1");
//        ByteInteger byti = new ByteInteger( "2");
//        ShortInteger Shoti = new ShortInteger((short) 3);
//        System.out.println(Shoti.toString()+inti.toString() + byti.toString());
//        System.out.println(Shoti.getClass());
        ArrayInteger ai1 = new ArrayInteger(8);
        ai1.fromInt(new BigInteger("13934773"));
        ArrayInteger ai2 = new ArrayInteger(6);
        ai2.fromInt(new BigInteger("169985"));
        ai1.add(ai2);
        System.out.println(ai1.toInt());
        System.out.println("14045884 - должно быть ");
    }
}
