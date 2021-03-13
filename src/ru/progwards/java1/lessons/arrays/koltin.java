package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class koltin {
    public static void main(String[] args) {
        for (double d = 0; d < 0.8; d= d + 0.1) {
            //System.out.println(d);
        }
        double res = 0, d = 1;
        while (d >0){
            res = d;
            d /=2;
        }
        System.out.println(res);
    }
}
