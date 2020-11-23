package ru.progwards.java1.lessons.test;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Напишите метод, с сигнатурой public List<Integer> filter(List<Integer> list) который работает по следующему алгоритму
 * суммирует значения всех элементов списка
 * удаляет из списка элементы, значение которых меньше суммы, деленной на 100 (целочисленное деление)
 * возвращает результирующий список
 **/

public class Arraylist_LinkedList {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }
        Arraylist_LinkedList AL = new Arraylist_LinkedList();
        System.out.println(AL.filter(arrayList));

    }

    public List<Integer> filter(List<Integer> list) {
        List listrez = new ArrayList();
        long res = 0;
        for (int i = 0; i < list.size(); i++) {
            res += list.get(i);
        }
        long res2 = res / 100;
        for (int num : list) {
            if (num < res2) {
                listrez.add(num);
            }
        }
        return listrez;
    }

    /**
     * Напишите метод с сигнатурой public void iterator3(ListIterator<Integer> iterator)
     * который заменяет значение каждого элемента, которое кратно 3 на значение его индекса.
     */
    public void iterator3(ListIterator<Integer> iterator) {
        int iters =-1;
        for (ListIterator<Integer> it = iterator; it.hasNext(); ) {
            int num = it.next();
            iters++;
            if (num%3 == 0) {
                iterator.set(iters);
            }
        }
    }

}

