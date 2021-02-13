package ru.progwards.java1.lessons.maps;
import java.util.*;
import java.util.AbstractMap.SimpleEntry;
public class FiboMapCache_Test {
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void main(String[] args)
    {
        FiboMapCache fc = new FiboMapCache(true);
        for (int i = 0; i < 8; i++) {
            System.out.println(i + " - " + fc.fiboNumber(i));
        }
        System.out.println();
        for (int i = 0; i < 8; i++) {
            System.out.println(i + " - " + fc.fiboNumber(i));
        }
//        ArrayList<AbstractMap.SimpleEntry<Integer, Integer> >arrayList = new ArrayList<AbstractMap.SimpleEntry<Integer, Integer> >();
//        arrayList.add(new AbstractMap.SimpleEntry(0, 123));
//        arrayList.add(new AbstractMap.SimpleEntry(1, 130));
//        arrayList.add(new AbstractMap.SimpleEntry(2, 994));
//        // печатаем ключи
//        for (int i = 0; i < arrayList.size(); i++) {
//            // получить карту из списка
//            AbstractMap.SimpleEntry<Integer, Integer>
//                    map = arrayList.get(i);
//            // получить значение из карты с помощью getValue ()
//            int value = map.getValue();
//            System.out.println("Value " + value);
//        }
    }
}