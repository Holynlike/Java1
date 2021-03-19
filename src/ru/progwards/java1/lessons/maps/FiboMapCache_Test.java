package ru.progwards.java1.lessons.maps;
public class FiboMapCache_Test {
    public static void main(String[] args)
    {
        int too = 8;
        FiboMapCache fc = new FiboMapCache(false);
        for (int i = 1; i < too; i++) {
            System.out.println(i + " - " + fc.fiboNumber(i));
        }

        System.out.println();
        for (int i = 1; i < too; i++) {
            System.out.println(i + " - " + fc.fiboNumber(i));
        }
        System.out.println();

        fc = new FiboMapCache(true);
        for (int i = 1; i < too; i++) {
            System.out.println(i + " - " + fc.fiboNumber(i));
        }
        System.out.println();
        for (int i = 1; i < too; i++) {
            System.out.println(i + " - " + fc.fiboNumber(i));
        }
        System.out.println();
        for (int i = 1; i < too; i++) {
            System.out.println(i + " - " + fc.fiboNumber(i));
        }
    }
}