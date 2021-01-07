package ru.progwards.java1.lessons.test;

public class Square extends Figure {
    private double side;
    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }
//    public String figDetect(Figure fig){
//        if (fig.getClass() == this.getClass()){
//            return "Сторона квадрата "+side;
//        }
//        return "Неизвестная фигура";
//    }
}
