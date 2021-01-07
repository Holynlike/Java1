package ru.progwards.java1.lessons.test;

public class Figure {
    String figDetect(Figure fig) {
        String mes = "Неизвестная фигура";
        if (fig instanceof Square) {
            Square square = (Square) fig;
            mes = "Сторона квадрата " + square.getSide();
        } else if (fig instanceof Round ) {
            Round round = (Round) fig;
            mes = "Диаметр круга " + round.getDiameter();
        }
        return mes;
    }
}
