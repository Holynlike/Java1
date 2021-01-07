package ru.progwards.java1.lessons.sets;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SetOperations {
    public static void main(String[] args) {
        Set<Integer> s1 = new TreeSet<>();
        Set<Integer> s2 = new TreeSet<>();
        s1.add(1);
        s1.add(2);
        s1.add(3);
        s2.add(1);
        s2.add(50);
        s2.add(30);

        System.out.println(union(s1, s2) + " - Объединение");
        System.out.println(intersection(s1, s2) + " - Пересечение");
        System.out.println(difference(s1, s2) + " - Разница");
        System.out.println(symDifference(s1, s2) + " - Симметричная Разница");
    }

    public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) {
        // пересечение
        SortedSet<Integer> unionSet = new TreeSet();
        for (int num : set1) {
            unionSet.add(num);
        }
        for (int num : set2) {
            unionSet.add(num);
        }
        return unionSet; // готово!
    }

    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {
        // объединение
        SortedSet<Integer> interSet = new TreeSet();
        for (int num : set1) {
            if (set2.contains(num)) {
                interSet.add(num);
            }
        }
        return interSet; // готово!
    }

    public static Set<Integer> difference(Set<Integer> set1, Set<Integer> set2) {
        // Разница
        SortedSet<Integer> diffSet = new TreeSet();
        for (int num : set1) {
            if (!set2.contains(num)) {
                diffSet.add(num);
            }
        }
        return diffSet;
    }
    public static Set<Integer> symDifference(Set<Integer> set1, Set<Integer> set2){
        // Симметрическая разница
        SortedSet<Integer> symDiffSet = new TreeSet();
        for (int num : set1) {
            if (!set2.contains(num)) {
                symDiffSet.add(num);
            }
        }
        for (int num : set2) {
            if (!set1.contains(num)) {
                symDiffSet.add(num);
            }
        }
        return symDiffSet;
    }

}
