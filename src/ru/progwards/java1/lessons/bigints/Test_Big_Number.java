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
        for (int i = 2; i < 9; i++) {
            ai1 = new ArrayInteger(i);
            ai1.fromInt(new BigInteger(My_Random(i)));
            ai2 = new ArrayInteger(i);
            ai2.fromInt(new BigInteger(My_Random(i)));
            ai1.add(ai2);
        }

        ai1.add(ai2);
        System.out.println(ai1.toInt());
        System.out.println("14104758 - должно быть ");
    }
    public static String My_Random(int l){
        Double d = Math.random() * Math.pow(10,l);
        String[] a = String.valueOf(d.toString()).split("[.]");
        return a[0];
    }
}
