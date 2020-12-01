package ru.progwards.java1.lessons.collections;

import java.util.Iterator;

/**
 * Сделать итератор по одномерному массиву, реализовать методы hasNext() и next().
 */
public class ArrayIterator<T> implements Iterator<T> {

    private T[] array;

    ArrayIterator(T[] array) {
        this.array = array;
    }

    public ArrayIterator() {

    }

    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public T next() {
        // TODO Auto-generated method stub
        return null;
    }
}
