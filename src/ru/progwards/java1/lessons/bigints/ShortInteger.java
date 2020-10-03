package ru.progwards.java1.lessons.bigints;

public class ShortInteger extends AbsInteger {
    short base;
    public ShortInteger(short value){
        base = value;
    }
    @Override
    public String toString(){
        return Integer.toString(base);
    }
}
