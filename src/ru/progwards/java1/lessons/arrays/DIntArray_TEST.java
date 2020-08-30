package ru.progwards.java1.lessons.arrays;

import ru.progwards.java1.lessons.interfaces.Animal;
import ru.progwards.java1.lessons.interfaces.Duck;
import ru.progwards.java1.lessons.interfaces.Hamster;

public class DIntArray_TEST {
    public static void main(String args[]) {
        //System.out.println(intToGrade(4));
        Animal pig = new Animal(70);
        Animal bat = new Animal(4);
        System.out.println("Сравнение двух Animal с разным весом " + pig.equals(bat));
        Animal bug = new Animal(4);
        System.out.println("Сравнение двух Animal с одинаковым весом " + bug.equals(bat));

        Duck Donald = new Duck(4);
        Hamster RAT = new Hamster(4);
        System.out.println("Сравнение хомяка и утки с одинаковым весом " + RAT.equals(Donald));
        System.out.println("Цена еды существа: " + RAT.getFood1kgPrice());
    }

    public static Grade intToGrade(int grade) {
        switch (grade) {
            case 1:
                return Grade.VERYBAD;
            case 2:
                return Grade.BAD;
            case 3:
                return Grade.SATISFACTORILY;
            case 4:
                return Grade.GOOD;
            case 5:
                return Grade.EXCELLENT;
            default:
                return Grade.NOTDEFINED;
        }
    }

    enum Grade {VERYBAD, BAD, SATISFACTORILY, GOOD, EXCELLENT, NOTDEFINED}
}