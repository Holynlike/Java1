package ru.progwards.java1.lessons.test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Maps {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1, "Один");
        map.put(9, "Девять");
        checkAndAdd(map, 0, "Zero");
        checkAndAdd(map, 3, "Три");
        checkAndAdd(map, 2, "Два");
        checkAndAdd(map, 3, "Three");
        checkAndAdd(map, 10, "Ten");
        System.out.println(map);

        TreeMap<Integer, String> map2 = new TreeMap<>();
        checkAndAdd(map2, 0, "Zero");
        checkAndAdd(map2, 0, "Zero");
        System.out.println(map2);
    }
    static HashMap<Integer, String> a2map(int[] akey, String[] aval){
        HashMap<Integer, String> rez = new HashMap<>();
        for (int i = 0; i < akey.length; i++) {
            rez.put(akey[i],aval[i]);
        }
        return rez;
    }
    static int fillHoles(Map<Integer, String> map, int size){
        int mySize = 0;
        for (int i = 1; i <= size; i++) {
            if(!map.containsKey(i)){map.put(i,"Число " + i); mySize++;}
        }
        return mySize;
    }
    static void checkAndAdd(TreeMap<Integer, String> map, Integer key, String value){
/**     значение с таким key должно отсутствовать
        значение key долно быть больше головы TreeMap
        значение key долно быть меньше хвоста TreeMap
*/
    if(map.isEmpty()) { return;}
    if(!map.containsKey(key)){
            if(key <= map.lastKey()){
                if (key >= map.firstKey()){map.put(key,value);
                }
            }
        }
    }
}
