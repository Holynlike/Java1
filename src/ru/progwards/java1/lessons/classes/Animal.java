package ru.progwards.java1.lessons.classes;

public class Animal {
    double weight;

    public Animal(double weight) {
        this.weight = weight;
    }

    public AnimalKind getKind() {
        return AnimalKind.ANIMAL;
    }

    public FoodKind getFoodKind() {
        return FoodKind.UNKNOWN;
    }

    @Override
    public String toString() {
        return "i am " + getKind() + ", eat " + getFoodKind();
    }

    public double getWeight() {
        return weight;
    }

    public double getFoodCoeff() {
        return 0.02d;
    }

    public double calculateFoodWeight() {
        return getFoodCoeff() * weight;
    }

    public String toStringFull() {
        return "i am " + getKind() + ", eat " + getFoodKind() + " " + calculateFoodWeight();
    }

    enum AnimalKind {ANIMAL, COW, HAMSTER, DUCK}

    enum FoodKind {UNKNOWN, HAY, CORN}
}