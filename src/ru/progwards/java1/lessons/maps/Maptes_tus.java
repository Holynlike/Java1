package ru.progwards.java1.lessons.maps;

import java.util.HashMap;

public class Maptes_tus {


    public static void main(String[] args) {
        HashMap<String, String> hashmap = new HashMap<>();
        String key1;
        String entry1;
        key1 = "Один";
        entry1 = "Два";
        hashmap.put(key1,entry1);
        key1 = "Одиннадцать";
        entry1 = "Двадцать";
        hashmap.put(key1,entry1);
        System.out.println(hashmap.get("Один"));
        System.out.println(hashmap.get("Один-два"));
    }
}
