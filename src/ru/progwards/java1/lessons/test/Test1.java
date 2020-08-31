package ru.progwards.java1.lessons.test;

import ru.progwards.java1.lessons.interfaces.Animal;
import ru.progwards.java1.lessons.interfaces.CalculateFibonacci;
import ru.progwards.java1.lessons.interfaces.Duck;
import ru.progwards.java1.lessons.Своё.interfaces.Родитель;

public class Test1 {

    public static void main(String[] args) {
        int r = CalculateFibonacci.fiboNumber(10);
        System.out.println(CalculateFibonacci.getLastFibo().n + " " + CalculateFibonacci.getLastFibo().fibo);

    }

    static int addAsStrings(int n1, int n2) {
        String Sn1 = Integer.toString(n1);
        String Sn2 = Integer.toString(n2);
        return Integer.valueOf(Sn1 + Sn2);
    }

    static String textGrade(int grade) {
        String Result = "";
        if (grade == 0)
            Result = "не оценено";
        else if (grade > 0 & grade <= 20)
            Result = "очень плохо";
        else if (grade > 20 & grade <= 40)
            Result = "плохо";
        else if (grade > 40 & grade <= 60)
            Result = "удовлетворительно";
        else if (grade > 60 & grade <= 80)
            Result = "хорошо";
        else if (grade > 80 & grade <= 100)
            Result = "отлично";
        else
            Result = "не определено";
        return Result;
    }
}
