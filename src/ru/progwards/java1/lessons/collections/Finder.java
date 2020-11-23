package ru.progwards.java1.lessons.collections;

import java.util.*;

public class Finder {
    /**
     * найти 2 соседних числа в коллекции, сумма которых минимальна, вернуть коллекцию, содержащую индексы этих чисел
     */
    public static void main(String[] args) {
        ArrayList<Integer> list3 = new ArrayList();
        list3.add(1);
        list3.add(1000);
        list3.add(10);
        list3.add(10);
        Collection<Integer> c = findMinSumPair(list3);
        System.out.println(c.toString());
    }

    public static Collection<Integer> findMinSumPair(Collection<Integer> numbers) {
        Integer TMP = Integer.MAX_VALUE;
        Integer THIS = 0;
        int step = -1;      // Шаг итератора
        Integer sum = 0;   // Сумма двух
        Integer Prev = 0; // Предыдущий элемент
        Integer TMPstep = 0;
        List<Integer> arrayList = new ArrayList();

        for (Iterator it = numbers.iterator(); it.hasNext(); ) {
            step++;
            THIS = (Integer) it.next();
            //System.out.println(THIS); Вывод текущего элемента (приггодится для бесед с роботом)
            if (step == 0) {
                Prev = THIS;
                sum = THIS;
            } else {
                sum = THIS + (Integer) Prev;
                Prev = THIS;
            }
            if (sum < TMP & step != 0) {
                TMP = sum;
                TMPstep = step;
            }
        }
        arrayList.add(TMPstep - 1);
        arrayList.add(TMPstep);
        return arrayList;
    } // Вродя сделал, на моих тестах работает
}