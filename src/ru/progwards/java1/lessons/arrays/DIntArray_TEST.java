package ru.progwards.java1.lessons.arrays;
public class DIntArray_TEST {
    public static void main(String args[]) {
        System.out.println(intToGrade(4));
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