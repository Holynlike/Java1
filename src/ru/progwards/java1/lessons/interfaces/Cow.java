package ru.progwards.java1.lessons.interfaces;
public class Cow extends Animal implements CompareWeight {
    public Cow(double weight) {
        super(weight);
    }

    @Override
    public Cow.AnimalKind getKind() {
        return AnimalKind.COW;
    }

    @Override
    public Cow.FoodKind getFoodKind() {
        return FoodKind.HAY;
    }

    @Override
    public double getFoodCoeff() {
        return 0.05d;
    }
}
