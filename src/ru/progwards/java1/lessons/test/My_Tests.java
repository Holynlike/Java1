package ru.progwards.java1.lessons.test;

public class My_Tests {
    public static void main(String[] args){
        System.out.println(factorial(4));
    }
    static long factorial(long n){
        long lnSummator = 1;
        for (int i = 1; i <=n; i++){
            lnSummator = lnSummator*i;
        }
        return lnSummator;
    }
}
