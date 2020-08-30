package ru.progwards.java1.lessons.interfaces;
public class Duck extends Animal implements FoodCompare {
    public Duck(double weight) {
        super(weight);
    }

    @Override
    public Duck.AnimalKind getKind() {
        return AnimalKind.DUCK;
    }

    @Override
    public Duck.FoodKind getFoodKind() {
        return FoodKind.CORN;
    }

    @Override
    public double getFoodCoeff() {
        return 0.04d;
    }

    public int compareFoodPrice() {
        return 0;
    } // Для задачи 8 - юзаем интерфейсы

    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeigt) {
        return null;
    }
}
