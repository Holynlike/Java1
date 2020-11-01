package ru.progwards.java1.lessons.interfaces;

/**
 * Интерфейсный жавадок
 */


public interface CompareWeight {
    public CompareResult compareWeight(CompareWeight smthHasWeigt);
    public enum CompareResult {LESS, EQUAL, GREATER}
}