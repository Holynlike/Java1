package ru.progwards.java1.lessons.test;

class Rectangle {
    double b;
    private double a;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double area() {
        return a * b;
    }

    //@Override
    public int compareTo(Rectangle anRectangle) {
        int intResult;
        if (anRectangle.area() < this.area()) {
            intResult = 1;
        } else if (anRectangle.area() > this.area()) {
            intResult = -1;
        } else {
            intResult = 0;
        }
        return intResult;
    }
}
