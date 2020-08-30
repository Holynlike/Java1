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
        public int n, fibo; // служебные переменные

        public CacheInfo(int n, int fibo) {
            this.n = n; // сохранение значений в переменных
            this.fibo = fibo;
        }
    }
}
