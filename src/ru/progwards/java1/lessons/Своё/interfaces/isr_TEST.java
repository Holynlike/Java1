

// Демонстрация .Getclass по классам и их наследникам


package ru.progwards.java1.lessons.Своё.interfaces;

public class isr_TEST {
    public static void main(String[] args) {
        User user = new User(879745, "John");
        SpecificUser specificUser = new SpecificUser("1AAAA", 877777, "Jim");
        User anotherSpecificUser = new SpecificUser("1BBBB", 812345, "Jenny");

        System.out.println(user.getClass()); //Prints "class User"
        System.out.println(specificUser.getClass()); //Prints "class SpecificUser"
        System.out.println(anotherSpecificUser.getClass()); //Prints "class SpecificUser"
    }
}
