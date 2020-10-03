package ru.progwards.java1.lessons.bigints;

public class Test_Big_Number {
    public static void main(String[] args) {
        IntInteger inti = new IntInteger("1");
        ByteInteger byti = new ByteInteger( "2");
        ShortInteger Shoti = new ShortInteger((short) 3);
        System.out.println(Shoti.toString()+inti.toString() + byti.toString());
        System.out.println(Shoti.getClass());
    }
}
