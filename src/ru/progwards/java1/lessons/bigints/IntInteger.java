package ru.progwards.java1.lessons.bigints;

public class IntInteger extends AbsInteger {
    String base;
    public IntInteger(int value){
        base = Integer.toString(value);
    }
    @Override
    public String toString(){
        return base;
    }
}
