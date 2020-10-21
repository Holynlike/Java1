package ru.progwards.java1.lessons.bigints;

public class ByteInteger extends AbsInteger {
    String Base;
    ByteInteger(byte Value){
        Base = Integer.toString(Value);
    }
    @Override
    public String toString(){
        return Base;
    }

}
