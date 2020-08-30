package ru.progwards.java1.lessons.interfaces;

public class Food implements CompareWeight {
    private int weight;

    public Food(int weight) {
        this.weight = weight;
    } // сохранить вес

    public double getWeight() {
        return weight;
    } // Показать вес

    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeigt) {
        Food unknownFOOD = (Food) smthHasWeigt;
        int difFood = Double.compare(this.getWeight(), unknownFOOD.getWeight());             //2
        switch (difFood) {
            case (-1):
                return CompareResult.LESS;
            case (0):
                return CompareResult.EQUAL;
            default:
                return CompareResult.GREATER;
        }
    }
}
