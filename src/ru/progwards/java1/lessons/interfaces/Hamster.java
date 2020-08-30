package ru.progwards.java1.lessons.interfaces;
public class Hamster extends Animal {
    public Hamster(double weight) {
        super(weight);
    }

    @Override
    public Hamster.AnimalKind getKind() {
        return AnimalKind.HAMSTER;
    }

    @Override
    public Hamster.FoodKind getFoodKind() {
        return FoodKind.CORN;
    }

    @Override
    public double getFoodCoeff() {
        return 0.03d;
    }
}
