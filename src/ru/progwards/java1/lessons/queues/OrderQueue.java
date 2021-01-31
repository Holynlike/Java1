package ru.progwards.java1.lessons.queues;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;

public class OrderQueue {
    PriorityQueue pq = new PriorityQueue<Order>(new Order.Checker());
    public void add(Order order){
        pq.add(order);
    }
    public Order get(){
        if(pq.size() ==0){return null;}
        return  (Order) pq.poll();
    }
    public String getSt(){
        Order  o2 = (Order) pq.poll();
        return o2.getSum() + " - " + o2.getNum();
    }
}
class Order{
    double sum;             // сумма заказа
    static int num = 0;     // номер заказа
    int thisnum = 0;

    public Order(double sum){num++; thisnum = num; this.sum = sum;} // Конструктор
    public double getSum(){return sum;} // Геттер
    public int getNum(){return thisnum;}// Геттер

    static class Checker implements Comparator<Order>
    {
        public int category(Order o){
            if(o ==null){return 0;}
            if(o.getSum() < 10000) {
                return 3;
            }else if(o.getSum() > 10000 & o.getSum() < 20000){
                return 2;
            }else{return 1;}

        }
        public int compare(Order o1, Order o2)
        {
            int a = category(o1);
            int b = category(o2);
            if(a < b){ // Сравниваем категорию товара
                return -1;
            }else if(a > b){
                return 1;
            }else{
                if(o1.getNum() > o2.getNum()){ // Если категории равны, сравниваем номер заказа
                    return 1;
                }else{return -1;}
            }
        }
    }
}
class testus{
    public static void main(String[] args) {
        dequeueTest();
        Order ord1 = new Order(5000);
        Order ord2 = new Order(27000);
        Order ord3 = new Order(12000);
        Order ord4 = new Order(7000);
        OrderQueue oq = new OrderQueue();

        oq.add(ord1);
        oq.add(ord2);
        oq.add(ord3);
        oq.add(ord4);
        System.out.println(oq.get().sum);
        System.out.println(oq.get().sum);
        System.out.println(oq.get().sum);
        System.out.println(oq.get().sum);
        Order o99 = oq.get();
        System.out.println(oq.get().sum);
    }
    static void dequeueTest() {
        PriorityQueue pQueue = new PriorityQueue<>();
        pQueue.offer(10);
        pQueue.offer(1);
        pQueue.offer(9);
        pQueue.offer(3);
        System.out.println(pQueue);
    }
}