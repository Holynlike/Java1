package ru.progwards.java1.lessons.test;

public class geometry_2D_3D {
    public static void main(String[] args) {
        Point2D myLine = new Point2D(2, 3);
        Point2D myLine2 = new Point3D(23, 12, 7);
        System.out.println(myLine.toString());
        System.out.println(myLine2.toString());
    }
}

class Point2D {
    int x;
    int y;

    Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return Integer.toString(x) + "," + Integer.toString(y);
    }
}

class Point3D extends Point2D {
    private int z;

    Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public String toString() {
        return super.toString() + "," + Integer.toString(z);
    }
}