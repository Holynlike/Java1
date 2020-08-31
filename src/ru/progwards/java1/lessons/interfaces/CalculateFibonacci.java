package ru.progwards.java1.lessons.interfaces;

public class CalculateFibonacci {
    private static CacheInfo lastFibo = new CacheInfo(0, 0);
    public static CacheInfo getLastFibo() {
        if (lastFibo == null) {
           return null;
        } else {
            return lastFibo;
        }
    }

    public static void clearLastFibo() {lastFibo = null;}

    public static int fiboNumber(int n) {
        int fiboprev1 = 0, fiboprev2 = 1, RESfiboNumber = 0;
        if (n == lastFibo.n) {
            return lastFibo.fibo;
        } else {
            switch (n) {
                case 0:
                    RESfiboNumber = n;
                case 1:
                    RESfiboNumber = n;
                default:
                    for (int i = 2; i <= n; i++) {
                        RESfiboNumber = fiboprev1 + fiboprev2;
                        fiboprev1 = fiboprev2;
                        fiboprev2 = RESfiboNumber;
                    }
            }
        }
        lastFibo.fibo = RESfiboNumber;
        lastFibo.n = n;
        return RESfiboNumber;
    }

    public static class CacheInfo {
        public int n, fibo; // служебные переменные
        public CacheInfo(int n, int fibo) {
            this.n = n; // сохранение значений в переменных
            this.fibo = fibo;
        }
    }
}