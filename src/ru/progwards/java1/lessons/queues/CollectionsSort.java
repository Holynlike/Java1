package ru.progwards.java1.lessons.queues;

import java.util.*;

public class CollectionsSort {
    public static void main(String[] args) {
//        Collection k = compareSort();
//        System.out.println(k);
        ArrayList <Integer>al = new ArrayList();
        al.add(43);
        al.add(80);
        al.add(5);
        al.add(52);
        al.add(69);
        al.add(80);
        minSort(al);
        System.out.println(al.toString());
    }

    public static void mySort(Collection<Integer> data){
        if(data == null){return;}               // Если подана пустая коллекция, сразу выходим
        Integer tmp = null;
        ArrayDeque<Integer> qu = new ArrayDeque();
        for (int j = data.size()-1; j >=0; j--) {
            tmp = Collections.min(data);        // Взяли минимальное значение коллекции
            qu.add(tmp);                        // сохранили его в очередь
            data.remove(Collections.min(data)); // и удалили его из коллекции
        }
        for (int i = qu.size(); i>0; i--) {     // Теперь бежим по очереди (Она уже отсортирована!
            tmp = qu.removeFirst();             // И таскаем оттуда первый (наименьший) элемент с удалением
            data.add(tmp);                      // И добавляем наименьший в коллекцию!
        }// Бинго! Очередь заодно с минимумом элегантно решает сортировку коллекции!
    }
    public static void minSort(Collection<Integer> data){
        List col = new ArrayList();
        for (int i = data.size()-1; i >=0; i--) {
            col.add(Collections.min(data));
            data.remove(Collections.min(data));
        }
        data.addAll(col);
    }
    static void collSort(Collection<Integer> data){Collections.sort((List) data);}
    public static Collection<String> compareSort() {
        int MySize = 5000;
        long start;
        List<String> strList = new ArrayList(); // Коллекция в три значения (здесь будут лежать названия методов сортировки)
        strList.add((String)"mySort");
        strList.add((String)"collSort");
        strList.add((String)"minSort");
        List<Integer> intList = new <Integer>ArrayList(); // Коллекция в три числа (здесь будут лежать значения времени сортировки)
        //----------
        Collection<Integer> c = Randomize(MySize);
        start = System.currentTimeMillis();
        mySort(c);
        intList.add((int) (System.currentTimeMillis() - start));
        //----------
        c = Randomize(MySize);
        start = System.currentTimeMillis();
        collSort(c);
        intList.add((int) (System.currentTimeMillis() - start));
        //----------
        c = Randomize(MySize);
        start = System.currentTimeMillis();
        minSort(c);
        intList.add((int) (System.currentTimeMillis() - start));
        //----------Теперь в трёх строках сортировка трехэлементной коллекции (Точнее двух коллекций)
        if (intList.get(0) > intList.get(1)){Collections.swap(intList,0,1); Collections.swap(strList,0,1);}
        if (intList.get(1) > intList.get(2)){Collections.swap(intList,1,2); Collections.swap(strList,1,2);}
        if (intList.get(0) > intList.get(1)){Collections.swap(intList,0,1); Collections.swap(strList,0,1);}
        //----------Теперь в трёх строках сортировка трехэлементной коллекции (в алфавитном порядке по именам функций-сортировщиков)
        if (intList.get(0) == intList.get(1) && strList.get(0).compareTo(strList.get(1)) == -1) {Collections.swap(strList,0,1);}
        if (intList.get(1) == intList.get(2) && strList.get(1).compareTo(strList.get(2)) == -1) {Collections.swap(strList,1,2);}
        if (intList.get(0) == intList.get(1) && strList.get(0).compareTo(strList.get(1)) == -1) {Collections.swap(strList,0,1);}
        System.out.println(intList);
        return strList;
    }

    static Collection<Integer> Randomize(int size){ // Создать коллекцию случайных чисел с size элементами
        ArrayList <Integer>al2 = new ArrayList();
        Integer I1;
        for (int i = 0; i < size; i++) {
            I1 = (int) Math.random()*1000;
            al2.add(I1);
        }// Наполнение коллекции случайными числами 1 - 1000
        return al2;
    }
}