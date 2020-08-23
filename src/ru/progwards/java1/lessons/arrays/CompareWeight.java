package ru.progwards.java1.lessons.arrays;

public interface CompareWeight {
    public CompareResult compareWeight(CompareWeight smthHasWeigt);

    public enum CompareResult {LESS, EQUAL, GREATER}


}
