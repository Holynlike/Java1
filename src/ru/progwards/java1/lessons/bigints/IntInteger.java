package ru.progwards.java1.lessons.bigints;

public class IntInteger extends AbsInteger {
    String base;
    public IntInteger(String value){
        base = value;
    }
    @Override
    public String toString(){
        return base;
    }
}
