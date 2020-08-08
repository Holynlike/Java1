package ru.progwards.java1.lessons.arrays;

public class DIntArray_TEST {
    public static void main(String[] args) {
        DIntArray Darr = new DIntArray();
        Darr.add(3);
        Darr.add(2);
        Darr.add(1);
        System.out.println(Darr.myLen() + ", " + Darr.at(Darr.myLen()));
        Darr.atInsert(1, 22);
        System.out.println(Darr.at(1));
        Darr.atDelete(1);
        System.out.println(Darr.at(1));
    }
}
