package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class Eratosthenes {
    public int n;
    private boolean[] sieve;

    public Eratosthenes(int N) {
        this.n = N;
        sieve = new boolean[N];
        Arrays.fill(sieve, true);
        this.sift();
    }

    private void sift() {
        for (int i = 2; i < sieve.length; i++) {
            for (int j = 2; j * i < sieve.length; j++) {
                sieve[j * i] = false;
            }
        }
    }

    public boolean isSimple(int n) {
        return sieve[n];
    } //возвращает sieve[n], что бы можно было узнать, простое число n или составное
}
