package ru.progwards.java1.lessons.collections;

import java.util.*;

public class Finder {
    /**
     * найти 2 соседних числа в коллекции, сумма которых минимальна, вернуть коллекцию, содержащую индексы этих чисел
     */
    public static void main(String[] args) {
        ArrayList<Integer> list4 = new ArrayList();
        list4.add(1);
        list4.add(2);
        list4.add(3);

        ArrayList<Integer> list3 = new ArrayList();
        list3.add(1);
        list3.add(1000);
        list3.add(10);
        list3.add(20);
        list3.add(30);
        list3.add(40);
        list3.add(50);
        list3.add(10);

        ArrayList<String> list5 = new ArrayList();
        // Василий:3, Иван:2, Ганнибал:2, Франкл:3, Никита:4, Фридрих:1 (Показываем Никиту - его последовательность наибольшая)
        list5.add("Василий");  //  00
        list5.add("Василий");  //  01
        list5.add("Василий");  //  02
        list5.add("Иван");     //  03
        list5.add("Иван");     //  04
        list5.add("Ганнибал"); //  05
        list5.add("Ганнибал"); //  06
        list5.add("Франкл");   //  07
        list5.add("Франкл");   //  08
        list5.add("Франкл");   //  09
        list5.add("Никита");   //  10
        list5.add("Никита");   //  11
        list5.add("Никита");   //  12
        list5.add("Никита");   //  13
        list5.add("Фридрих");  //  14

        Collection<Integer> c = findMinSumPair(list3);
        System.out.println(c.toString() + " - Индексы минимальных");
        Collection<Integer> c2 = findLocalMax(list3);
        System.out.println(c2.toString() + " - Индексы локальных максимумов");
        System.out.println(findSimilar(list5));

        boolean b = findSequence(list4);
        if (b) {
            System.out.println("Коллекция содержит все числа  номеров элементов!");
        } else {
            System.out.println("Коллекция не содержит все числа номеров элементов!");
        }
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

    /**
     * 2.2 Реализовать метод
     * public static Collection<Integer> findLocalMax(Collection<Integer> numbers)
     * - найти локальные максимумы - числа, которые больше соседа справа и слева.
     * Первый и последний элемент коллекции не может являться локальным  максимумом,
     * вернуть коллекцию, содержащую значения этих максимумов.
     */
    public static Collection<Integer> findLocalMax(Collection<Integer> numbers) {
        Integer[] toar = numbers.toArray(new Integer[0]); // Переводим коллекцию в массив для удобства прохода по элементам
        List<Integer> arrayList = new ArrayList();
        try {
            for (int i = 0; i < toar.length; i++) {
                if (i > 0 && i < toar.length) {
                    if (toar[i + 1] < toar[i] && toar[i] > toar[i - 1]) {
                        arrayList.add(i);
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException OUT) {
        } // Просто подавляем исключение выхода за границы массива
        return arrayList;
    }

    /**
     * 2.3 Реализовать метод
     * public static boolean findSequence(Collection<Integer> numbers)
     * проверить, содержит ли коллекция все числа от 1 до size(), порядок может быть произвольный
     */
    public static boolean findSequence(Collection<Integer> numbers) {
        boolean result = false;
        Integer THIS = 0;
        Integer Bound = numbers.size();
        Integer step = 0;
        for (int i = 0; i < Bound; i++) {
            step++; // Следующее искомое число
            result = false;
            for (Iterator it = numbers.iterator(); it.hasNext(); ) {
                THIS = (Integer) it.next(); // в цикле проверяем, есть ли искомое число
                if (!result) {
                    result = ((Integer) THIS == step);
                }
            }
            if (!result) {
                return false;
            } // Если на текущем цикле не нашлось число, сразу останавливаем выполнение
        }
        return true; // Если выполнение дошло до этой строки, то все числа найдены, смело отдаем Истину.
    }

    /**
     * 2.4 Реализовать метод
     * <p>
     * public static String findSimilar(Collection<String> names) - найдите максимальное количество повторяющихся подряд элементов.
     * Результат вернуть в виде строки <элемент>:<количество>, например Василий:5.
     * При равенстве максимального количества у разных повторяющихся элементов, вернуть результат для элемента,
     * повторяющаяся последовательность которого началась с наименьшего индекса.
     */
    public static String findSimilar(Collection<String> names) {
        if (names.size() ==0){return "null:0";}
        String[] toar = names.toArray(new String[0]); // Переводим коллекцию в массив для удобства прохода по элементам
        int[] intnames = new int[toar.length]; // Массив целых чисел
        String ActualName = toar[0]; // Текущее значение коллекции
        int OneI = 0;
        int prev = 0;
        int tmp = 0; // для подсчета очередной последовательности
        intnames[0] = 1;
        try {
            while (OneI < toar.length) {
                while (ActualName == toar[prev]) {
                    OneI++;
                    ActualName = toar[OneI];
                } // Последовательность пройдена
                for (int i = prev; i < OneI; i++) {
                    intnames[i] = OneI - prev; // Прописываем в массив целых чисел значения последовательности
                    if(intnames[i] ==0){intnames[i] = 1;}
                }
                prev = OneI;
            }
        }catch (Exception E){
            System.out.println("Исключамба в симиларе!" + OneI + ":" + toar.length);
        }
        int MAX = intnames[0];
        int mystep = 0;
        for (int i = 0; i < toar.length; i++) {
            if(intnames[i]> MAX){
                mystep = i;
                MAX = intnames[i];
            }
        }
        return toar[mystep] + ":" + MAX;
    } // Решено!
}