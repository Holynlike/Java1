package ru.progwards.java1.lessons.test;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSet_User_Test {
    public static void main(String[] args) {
        doTreeSet();
    }
    public static void doTreeSet() {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(9);
        treeSet.add(1);
        treeSet.add(5);
        treeSet.add(2);
        treeSet.add(4);
        treeSet.add(8);

        String s = "";
        Iterator<Integer> iterator = treeSet.descendingIterator();
        while (iterator.hasNext())
            s += iterator.next();
        System.out.println(s);
    }
}
