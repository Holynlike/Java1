package ru.progwards.java1.lessons.arrays;

public class DIntArray_TEST {
    public static void main(String[] args) {
        DIntArray Darr = new DIntArray();
        System.out.println(Darr.at(4));
        Darr.add(2);
        System.out.println(Darr.myLen() + ", " + Darr.at(Darr.myLen()));
        Darr.atInsert(4, 22);
        System.out.println(Darr.at(4));
        Darr.atDelete(4);
        System.out.println(Darr.at(4));
    }
}
