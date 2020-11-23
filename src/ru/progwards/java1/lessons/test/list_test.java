package ru.progwards.java1.lessons.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.list;

/**Напишите метод с сигнатурой public List<Integer> listAction(List<Integer> list), который выполняет следующие действия:
 удаляет минимальный элемент коллекции
 по индексу 0 добавляет число равное количеству элементов
 по индексу 2 добавляет максимальный элемент из list
 возвращает list как результат метода
 **/

public class list_test {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList();
        for (int i = 0; i < 6; i++) {
            arrayList.add(i);
            System.out.println(i);
        }
        System.out.println("--------------");
        List<Integer> integers = listAction(arrayList);
    }
    public static List<Integer> listAction(List<Integer> list){
        int I = Integer.MAX_VALUE;
        Integer I_ = 0;
        int I2 = Integer.MIN_VALUE;
        int I2_;

        for (Integer i : list) {
            if (i < I ){
                I = i; // Поиск минимального
                I_ = i;
            }
            if(i>I2){
                I2 = i; // Поиск максимального
                I2_ = i;
            }
        }
        list.remove(I_); // Удаление минимального
        list.add(0, list.size()); // Добавление количества элементов в нулевую позицию.
        list.add(2, I2); // Добавление максимального элемента во вторую позицию.
        for (Integer i : list) {
            System.out.println(i);
        }
        return list;
    }

}
