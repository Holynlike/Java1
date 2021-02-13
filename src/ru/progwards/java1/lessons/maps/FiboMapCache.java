package ru.progwards.java1.lessons.maps;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class FiboMapCache {
    static Map<Integer, BigDecimal> fiboCache = new HashMap<>();
    boolean fibocache;

    public static void main(String[] args) {test();}
    public FiboMapCache(boolean cacheOn) {fibocache = cacheOn;}

    public BigDecimal fiboNumber(int n) {
        BigDecimal fiboprev1 = new BigDecimal("0");
        BigDecimal fiboprev2 = new BigDecimal("1");
        BigDecimal RESfiboNumber = new BigDecimal("0");
        if (fiboCache != null && fiboCache.containsKey(n)) {
            return fiboCache.get(n);
        }
        switch (n) {
            case 0:
                RESfiboNumber = new BigDecimal(String.valueOf(n));
            case 1:
                RESfiboNumber = new BigDecimal(String.valueOf(n));
            default:
                for (int i = 2; i <= n; i++) {
                    RESfiboNumber = fiboprev1.add(fiboprev2);
                    fiboprev1 = fiboprev2;
                    fiboprev2 = RESfiboNumber;
                }
        }
        if (fibocache && fiboCache != null && !fiboCache.containsValue(RESfiboNumber)) {
            fiboCache.put(fiboCache.size(), RESfiboNumber);
        }
        return RESfiboNumber;
    }

    public void clearCahe() {
        fiboCache = null;
    } // устанавливает переменную fiboCache в null

    public static void test() {
        FiboMapCache fiboMapCache = new FiboMapCache(false); // Первый тест - кэш выключен
        long in = System.currentTimeMillis();
        for (int i = 1; i <= 1000; i++) {
            fiboMapCache.fiboNumber(i);
        }
        in = System.currentTimeMillis() - in;
        System.out.println("fiboNumber cacheOn=false время выполнения " + in);

        FiboMapCache fiboMapCache2 = new FiboMapCache(true); // Первый тест - кэш включен
        in = System.currentTimeMillis();
        for (int i = 1; i <= 1000; i++) {
            fiboMapCache.fiboNumber(i);
        }
        in = System.currentTimeMillis() - in;
        System.out.println("fiboNumber cacheOn=true время выполнения " + in);
    }
}