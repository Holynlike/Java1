package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class koltin {
    public static void main(String[] args) {
        Eratosthenes ERA = new Eratosthenes(106);
        String textus = "";
        for (int i = 2; i < 106; i++) {
            if (ERA.isSimple(i)) {
                textus += i + ", ";
            }
        }
        System.out.println(textus);
        System.out.println("2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103");
        //Эратосфен готов, тестируем ArraySort
        int randArr1[] = new int[9];
        int randArr2[] = new int[9];
        int randArr3[] = new int[9];
        for (int i = 0; i < 8; i++) {
            randArr1[i] = i; // первый массив наполняем по возрастанию
            randArr2[i] = 10 - i; // второй массив наполняем по убыванию
            randArr3[i] = (int) (Math.random() * 100); // третий массив наполняем рандомно
        }
        ArraySort.sort(randArr1);
        ArraySort.sort(randArr2);
        ArraySort.sort(randArr3);
        System.out.println(Arrays.toString(randArr1));
        System.out.println(Arrays.toString(randArr2));
        System.out.println(Arrays.toString(randArr3));
    }
}
