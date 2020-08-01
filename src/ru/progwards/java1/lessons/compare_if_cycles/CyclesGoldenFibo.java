package ru.progwards.java1.lessons.compare_if_cycles;

public class CyclesGoldenFibo {
    public static void main(String[] args) {
        System.out.println(containsDigit(242, 3)); // Тестил, работает
        System.out.println(containsDigit(12345, 1)); // Тестил, работает
        System.out.println(containsDigit(0, 0)); // Тестил, работает
        System.out.println(fiboNumber(10)); // Тестил, работает
        System.out.println(isGoldenTriangle(1,2,3)); // Тестил, работает
        System.out.println(isGoldenTriangle(55,55,34)); // Тестил, работает
        for (int i = 1; i <= 15; i++) {
            System.out.println(i + " - " + fiboNumber(i)); // Фибо - цикл
        }
        for (int i = 1; i < 100; i++) { // Цикл поиска золотых треугольников
            for (int j = 1; j <= i; j++) { // Стремление к оптимизации цикла!  :)
                if (isGoldenTriangle(i,i,j)){
                    System.out.println("Найден золотой треугольник с параметрами: " + i + ", " + i + ", " + j);
                }
            }
        }
    }
    public static boolean containsDigit(int number, int digit){

        System.out.println("Вызвана функция containsDigit с агрументами: " + number + ", " + digit);
        //  будет возвращать true, если число number содержит цифру digit.
        String Stext = Integer.toString(number); // число number переведено в строку Stext
        String Sdigit = Integer.toString(digit); // число digit переведено в строку Sdigit
        return Stext.contains(Sdigit); //Java String contains()- метод чтобы проверить, содержит ли String указанную последовательность
    }
    public static int fiboNumber(int n){ // Найти число Фибоначчи для n
        int RESfiboNumber = 0;
        int fiboprev1 = 0, fiboprev2 = 1; // Переменные для двух предыдущих значений
        if (n == 0 | n == 1){
            RESfiboNumber = n; // Для 0 и 1 Фибоначчи совпадает с n
        } else { // Для бОльших чисел организуем "ханойский" цикл
            for (int i = 2; i <= n; i++) {
                RESfiboNumber = fiboprev1 + fiboprev2;
                fiboprev1 = fiboprev2;
                fiboprev2 = RESfiboNumber;
            }
        }
        return RESfiboNumber;
    }
    public static boolean isGoldenTriangle(int a, int b, int c){
        return (a == b & (double)a/c >= 1.61703d & (double)a/c <= 1.61903d | a == c & (double)a/b  >= 1.61703d & (double)a/b  <= 1.61903d | b == c & (double)b/a  >= 1.61703d & (double)b/a  <= 1.61903d);
    }
}