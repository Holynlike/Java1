package ru.progwards.java1.lessons.register1;
public class Bit {
    boolean value = false;
    public Bit(){this.value = false;}
    public Bit(boolean value){this.value = value;}
    public String toString(){
        String toret = "0";
        if(value){return "1";}
        return toret;
    }
}