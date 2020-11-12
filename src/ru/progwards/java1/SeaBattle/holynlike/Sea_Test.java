package ru.progwards.java1.SeaBattle.holynlike;

import ru.progwards.java1.SeaBattle.SeaBattle;

/**
 * My Projects
 * 13.11.2020
 * Magic
 */
public class Sea_Test {
    public static void main(String[] args) {
        System.out.println("Sea battle");
        SeaBattle seaBattle = new SeaBattle(true);
        new SeaBattleAlg().battleAlgorithm(seaBattle);
        System.out.println(seaBattle.getResult());
    }
}
