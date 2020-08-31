package ru.progwards.java1.lessons.Person;

public class person {
    public static void main(String[] args) {
        System.out.println(Child1.Hello());
        person People = new person();
        People.Mani();
    }

    public void Mani(){
        Child2 C2 = new Child2();
        System.out.println(C2.Hello());

    }
    public class Child2{
        public String Hello(){
            return "servus";
        }
    }
    static class Child1{
        public static String Hello(){
            return "привет";
        }
    }
}
