package ru.progwards.java1.lessons.collections;

import java.util.Iterator;

public class MatrixIterator<T> implements Iterator<T> {
    /**
     * Сделать итератор MatrixIterator по двумерному массиву (матрице), который разворачивает матрицу в линейную
     * последовательность построчно: a[0][0], a[0][1], ...a[0][N],a[1][0], a[1][1]...a[1][N]... a[M][N]
     * Шаблон для итератора взять от ArrayIterator
     **/

    public T[][] array;
    int hasNEXTnum = -1; // Текущее значение итератора
    int tmp;             // Текущее значение поискового итератора
    boolean hn = true;
    int myLEN = 0;

    MatrixIterator(T[][] array) {
        this.array = array;
        for (int i = 0; i < array.length; i++) {
            myLEN += array[i].length;
        } // Подсчёт количества элементов двумерного массива (работает)
    }// конструктор

    @Override
    public boolean hasNext() {
        return (hasNEXTnum < myLEN-1);
    } // Истина, если меньше количества элементов

    @Override
    public T next() {
        int COL = 0;
        hasNEXTnum++;
        tmp = hasNEXTnum;
        for (int i = 0; i < array.length; i++) {
            if (tmp >= array[i].length) {
                tmp -= array[i].length;
                COL++;
            }
            if (tmp == hasNEXTnum) {
                break;
            }
        }
        return array[COL][tmp];
    }
}