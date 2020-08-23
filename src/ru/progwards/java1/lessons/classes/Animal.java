package ru.progwards.java1.lessons.classes;

public class Animal implements FoodCompare {

    public double getFood1kgPrice() {
        FoodKind FK = FoodKind.UNKNOWN;
        double myReturn = 0.0;
        switch (FK) {
            case HAY:
                myReturn = 20.0;
                break;
            case CORN:
                myReturn = 50.0;
                break;
            case UNKNOWN:
                myReturn = 0.0;
        }
        return myReturn;
    }

    public double getFoodPrice() {
        return calculateFoodWeight() * getFood1kgPrice();
    }

    public int compareFoodPrice(Animal aminal) {
        return Double.compare(this.getFood1kgPrice(), aminal.getFood1kgPrice());
    }

    @Override
    public boolean equals(Object anObject) {
        if (anObject.getClass() == this.getClass()) {// Проверка, является ли анобжект Анималом
            Animal beast = (Animal) anObject; // Если да, то объявляем объект beast, ссылающийся на anObject и явно указанный как Animal
            return (beast.getWeight() == this.getWeight()); // И у двух полученных Animal сравниваем веса. Бинго!
        } else {
            return false;
        }
    }


    private double getWeight(Object anObject) {
        return weight;
    }

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
        return "I am " + getKind() + ", eat " + getFoodKind();
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
        return "I am " + getKind() + ", eat " + getFoodKind() + " " + calculateFoodWeight();
    }

    enum AnimalKind {ANIMAL, COW, HAMSTER, DUCK}

    enum FoodKind {UNKNOWN, HAY, CORN}
}