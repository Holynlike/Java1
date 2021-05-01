package ru.progwards.java1.lessons.test;

public class Slosh_Proc {
    public static void main(String[] args) {
        System.out.println(sloz_rez(1000,0.1,39));
        System.out.println(sloz_found(1000,0.1,2000*20));
    }

    public static double sloz_Cikl(double depo, double proc, long periodes){
        double k = depo;
        for (int i = 1; i <= periodes; i++) {
            k+=(k*proc);
            System.out.println(i + " - " + k);
        }
        return k;
    }

    public static double sloz_rez(double depo, double proc, long periodes){
        double k = depo;
        for (int i = 1; i <= periodes; i++) {
            k+=(k*proc);
        }
        return k;
    }
    public static double sloz_found(double depo, double proc, double result){
        double k = depo;
        long l = 0;
        while (k <= result) {
            l++;
            k+=(k*proc);
        }
        return l;
    }
}