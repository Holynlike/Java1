package ru.progwards.java1.lessons.test;

public class My_Tests {
    public static void main(String[] args) {
        Rectangle ree = new Rectangle(1, 2);
        Rectangle ree1 = new Rectangle(2, 1);
        Rectangle ree2 = new Rectangle(2, 2);

        System.out.println(ree.equals(ree1));
        System.out.println(ree.equals(ree2));

        System.out.println(addAsStrings(1, 7));
        System.out.println(factorial(7));

    }

    static long factorial(long n) {
        long lnSummator = 1;
        for (int i = 1; i <= n; i++) lnSummator = lnSummator * i;
        return lnSummator;
    }

    static int addAsStrings(int n1, int n2) {
        return Integer.valueOf(Integer.toString(n1) + Integer.toString(n2));
    }
}

