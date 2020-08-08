package ru.progwards.java1.lessons.arrays;

public class DIntArray_TEST {
    public static void main(String[] args) {
        DIntArray Darr = new DIntArray();
        System.out.println(Darr.myLen());
        //*-22,-80,-56,32,-5,-35,-26,63,26,24,-62,10,94,57,-4,-72,82,6,-10
        Darr.add(-22);
        Darr.add(-80);
        Darr.add(-56);
        Darr.add(32);
        Darr.add(-5);
        Darr.add(-35);
        Darr.add(-26);
        Darr.add(63);
        Darr.add(26);
        Darr.Show();
        Darr.atDelete(5);
        Darr.Show();
        System.out.println(Darr.at(5)); // ожидаем -26

        System.out.println(Darr.myLen() + ", " + Darr.at(Darr.myLen() - 1));
        Darr.atInsert(1, 22);
        System.out.println(Darr.at(1));
        Darr.atDelete(1);
        System.out.println(Darr.at(1));
    }
}
