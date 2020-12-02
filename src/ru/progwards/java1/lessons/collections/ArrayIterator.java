package ru.progwards.java1.lessons.collections;
import java.util.Iterator;
/**
 * Сделать итератор по одномерному массиву, реализовать методы hasNext() и next().
 */
public class ArrayIterator<T> implements Iterator<T> {
    private T[] array;
    int hasNEXTnum = -1; // Текущий элемент одномерного массива
    boolean hn = true;

    ArrayIterator(T[] array) {this.array = array;}
    @Override
    public boolean hasNext() {return(hasNEXTnum < array.length-1);}

    @Override
    public T next() {
        hasNEXTnum++;
        return array[hasNEXTnum];
    }
}