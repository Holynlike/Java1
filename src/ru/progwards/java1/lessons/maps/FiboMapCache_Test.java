package ru.progwards.java1.lessons.maps;

public class FiboMapCache_Test {
    public static void main(String[] args) {
        FiboMapCache fiboMapCache = new FiboMapCache(false);
        fiboMapCache.test();
        fiboMapCache.test();
        fiboMapCache.clearCahe();
        fiboMapCache.test();
    }
}
