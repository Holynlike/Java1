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

    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) return true;
        if (anObject == null || getClass() != anObject.getClass()) return false;
        Rectangle r = (Rectangle) anObject;
        return Double.compare(r.area(), this.area()) == 0;
    }
}
