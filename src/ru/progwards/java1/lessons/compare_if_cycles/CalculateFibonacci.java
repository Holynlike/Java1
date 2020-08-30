package ru.progwards.java1.lessons.compare_if_cycles;

public class CalculateFibonacci {

    private static CacheInfo lastFibo;

    public static CacheInfo getLastFibo() {
        return lastFibo;

    }

    public static void clearLastFibo() {
        lastFibo = null;
    }

    public static class CacheInfo {
        public int n;       // число, для которого рассчитываем Фибоначчи
        public int fibo;    // результат расчета

    }
}
