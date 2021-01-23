package ru.progwards.java1.lessons.queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class StackCalc {
    public ArrayDeque queue = new ArrayDeque();

    /**положить value на вершину стека*/
    public void push(double value){queue.add(value);}
    // TODO: Продумать алгоритм на NullPointException
    /** Извлечь из очереди **/
    public double pop(){
        return (double) queue.pollLast(); // Правкой приведено к LIFO - последним зашел - первым выходит.
    }
    /** Сложение **/
    public void add(){
        double tmp = pop();
        double tmp2 = pop(); // Попытки однострочной записи неудачны: оба последних значения меняются
        push  (tmp2 + tmp);
    }
    /** Разница **/
    public void sub(){
        double tmp = pop();
        double tmp2 = pop();
        push  (tmp2 - tmp);
    }
    /** Умножение **/
    public void mul(){
        double tmp = pop();
        double tmp2 = pop();
        push  (tmp2 * tmp);
    }
    /** Деление **/
    public void div(){
        double tmp = pop();
        double tmp2 = pop();
        push  (tmp2 / tmp);
    }
}