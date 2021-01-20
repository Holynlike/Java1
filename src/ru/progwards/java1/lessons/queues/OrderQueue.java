package ru.progwards.java1.lessons.queues;
import java.util.PriorityQueue;

public class OrderQueue {
    PriorityQueue<Order> pq = new PriorityQueue();
    public void add(Order order){
        pq.offer(order);
    }
}
class Order{
    double sum;      // сумма заказа
    static int num = 0;     // номер заказа

    public Order(double sum){num++; this.sum = sum;} // Конструктор
    public double getSum(){return sum;} // Геттер
    public int getNum(){return num;}    // Геттер
}
class testus{
    public static void main(String[] args) {
        Order ord1 = new Order(10000);
        Order ord2 = new Order(20000);
        Order ord3 = new Order(30000);
        OrderQueue oq = new OrderQueue();

        oq.add(ord1);
        oq.add(ord2);
        oq.add(ord3);
    }
}