package ru.progwards.java1.lessons.bigints;

public class Russia {
    public static void main(String[] args) {

        System.out.println(summ(0, 9));
        System.out.println(125 +  397 + 942);
        System.out.println(summ(396, 399));
    }
    public static long summ(long num1, long num2){
        long l = 0;
        for (long i = num1; i <= num2; i++) {
            l+=i;
        }
        return l;
    }
}
