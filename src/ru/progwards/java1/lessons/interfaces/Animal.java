package ru.progwards.java1.lessons.interfaces;

public class Animal implements FoodCompare, CompareWeight {
    public CompareWeight CW;
    double weight;

    public Animal(double weight) {
        this.weight = weight;
    }

    public int compareFoodPrice(Animal aminal) {
        return Double.compare(this.getFoodPrice(), aminal.getFoodPrice());
    }

    enum FoodKind {UNKNOWN, HAY, CORN}

    public double getFood1kgPrice() { // Цена за кило еды
        FoodKind FK = getFoodKind();
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

    @Override // Кто больше весит
    public CompareResult compareWeight(CompareWeight smthHasWeigt) {
        Animal Beast = (Animal) smthHasWeigt;
        switch (Double.compare(this.getWeight(), Beast.getWeight())) {
            case (-1):
                return CompareResult.LESS;
            case (0):
                return CompareResult.EQUAL;
            default:
                return CompareResult.GREATER;
        }
    }

    enum AnimalKind {ANIMAL, COW, HAMSTER, DUCK}// Переменны объявлены

    @Override
    public boolean equals(Object anObject) {
        if (anObject.getClass() == this.getClass()) {// Проверка, является ли анобжект Анималом
            Animal beast = (Animal) anObject; // Если да, то объявляем объект beast, ссылающийся на anObject и явно указанный как Animal
            return (beast.getWeight() == this.getWeight()); // И у двух полученных Animal сравниваем веса. Бинго!
        } else {
            return false;
        }
    }

    public double getFoodPrice() {
        return calculateFoodWeight() * getFood1kgPrice();
    }

    private double getWeight(Object anObject) {
        return weight;
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
}