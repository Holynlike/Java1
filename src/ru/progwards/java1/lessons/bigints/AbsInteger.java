package ru.progwards.java1.lessons.bigints;

import java.math.BigInteger;

public class AbsInteger {
    String base = "";
    public AbsInteger(String value){
        base = new BigInteger(value).toString();
    }

    public AbsInteger() {
    }

    @Override
    public String toString(){
        return base;
    }
//    2.3 У класса AbsInteger реализовать метод static AbsInteger add(AbsInteger num1, AbsInteger num2)
//    - который вычисляет сумму num1 и num2. При этом надо учесть, что num1 и num2 могут быть разных типов.
//    Для того, чтобы это реализовать продумать, какие дополнительные методы нужно сделать у AbsInteger и его потомков.

    static AbsInteger add(AbsInteger num1, AbsInteger num2){
        return new AbsInteger("123");  // ДОДЕ ЛАТЬ !!!!

    }
}


