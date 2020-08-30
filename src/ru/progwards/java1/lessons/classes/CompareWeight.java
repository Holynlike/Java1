package ru.progwards.java1.lessons.classes;

public interface CompareWeight {
    public CompareResult compareWeight(CompareWeight smthHasWeigt);

    public enum CompareResult {LESS, EQUAL, GREATER}
}