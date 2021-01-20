package ru.progwards.java1.lessons.queues;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackCalc {
    double Lastnum;
    int Count = 0;
    public static void main(String[] args) {
        StackCalc stackCalc = new StackCalc();
        stackCalc.push(10.0);
        stackCalc.push(2.0);
        stackCalc.sub();
        System.out.println(stackCalc.pop());
        System.out.println(stackCalc.pop());
        System.out.println(stackCalc.pop());
    }
    

    Queue queue = new ArrayDeque();

    /**положить value на вершину стека*/
    public void push(double value){queue.add(value); Lastnum = value;}//TODO: Проработать во всех функциях исключения NullPointException

    public double pop(){return (double) queue.poll();}

    public void add(){push ((double) queue.poll() + (double) queue.poll());}

    public void sub(){
        double tmp = (double) queue.poll();
        push ((double) queue.poll() - tmp);
    }

    public void mul(){push((double) queue.poll() * (double) queue.poll());}
    public void div(){
        double tmp = (double) queue.poll();
        push ((double) queue.poll() / tmp);
    }
}
