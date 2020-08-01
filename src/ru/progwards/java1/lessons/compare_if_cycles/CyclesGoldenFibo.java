package ru.progwards.java1.lessons.compare_if_cycles;

public class CyclesGoldenFibo {
    private static int[] FIBOarr = new int[16]; // Массив для чисел Фибоначчи

    public static void main(String[] args) {
        System.out.println(fiboNumber(17));
        for (int i = 1; i <= 15; i++) {
            System.out.println(i + " - " + fiboNumber(i)); // Фибо - цикл
        }

        for (int i = 1; i < 100; i++) {    // Цикл поиска золотых треугольников
            for (int j = 1; j <= i; j++) { // Стремление к оптимизации цикла!  :)
                if (isGoldenTriangle(i,i,j)){
                    System.out.println("Найден золотой треугольник с параметрами: " + i + ", " + i + ", " + j);
                }
            }
        }
    }
    public static boolean containsDigit(int number, int digit){ //  будет возвращать true, если число number содержит цифру digit.
        return Integer.toString(number).contains(Integer.toString(digit));
    }
    public static int fiboNumber(int n){ // Найти число Фибоначчи для n
        // Оптимальнее всего будет сохранять найденные числа в общий для CyclesGoldenFibo массив
        // и если n-й элемент массива не равен 0, то брать ответ из массива, так избегая избыточное использование цикла
        int RESfiboNumber = 0;
        int fiboprev1 = 0, fiboprev2 = 1; // Переменные для двух предыдущих значений

        if (n < FIBOarr.length - 1) {    // Если n не выходит за пределы массива
            if (FIBOarr[n] != 0) { // и n-й элемент не равен 0
                RESfiboNumber = FIBOarr[n]; // Если в массиве уже есть найденное число Фибоначчи, просто без цикла выбираем его
            }
        }else{
            if (n == 0 | n == 1) RESfiboNumber = n; // Для 0 и 1 Фибоначчи совпадает с n
            FIBOarr[1] = 1;
            for (int i = 2; i <= n; i++) { // Для бОльших чисел организуем "ханойский" цикл
                RESfiboNumber = fiboprev1 + fiboprev2;
                if (i < FIBOarr.length - 1 ) { // Пока счетчик цикла не превышает размер массива
                    if (FIBOarr[i] == 0) FIBOarr[i] = RESfiboNumber; // Наполняем массив FIBOarr, избегая исключения выхода за границы массива
                }
                fiboprev1 = fiboprev2;
                fiboprev2 = RESfiboNumber;
            }
        }
        return RESfiboNumber;
    }
    public static boolean isGoldenTriangle(int a, int b, int c){//Хочется уложить функцию в одну строку
        return (a == b & (double)a/c >= 1.61703d & (double)a/c <= 1.61903d | a == c & (double)a/b  >= 1.61703d & (double)a/b  <= 1.61903d | b == c & (double)b/a  >= 1.61703d & (double)b/a  <= 1.61903d);
    }
}