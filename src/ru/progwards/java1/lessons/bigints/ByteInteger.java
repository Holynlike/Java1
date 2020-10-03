package ru.progwards.java1.lessons.bigints;

public class ByteInteger extends AbsInteger {
    String Base;
    ByteInteger(String Value){
        Base = Value;
    }
    @Override
    public String toString(){
        return Base;
    }

}
