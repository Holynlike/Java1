package ru.progwards.java1.lessons.compare_if_cycles;

public class CyclesGoldenFibo {
    private static int[] FIBOarr = new int[16]; // Массив для чисел Фибоначчи

    public static void main(String[] args) {
        for (int i = 0; i < 40; i++) {
            System.out.println(fiboNumber(i));
        }

        for (int i = 1; i <= 15; i++) {
            System.out.println(i + " - " + fiboNumber(i)); // Фибо - цикл
        }
        for (int i = 1; i < 100; i++) {    // Цикл поиска золотых треугольников
            for (int j = 1; j <= i; j++) { // Стремление к оптимизации цикла! Так как заведомо ясно, что при j >= i необходимое соотношение не выполнится
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

        if (n == 0 | n == 1){
            RESfiboNumber = n;// Для n == 0 и 1 Фибоначчи совпадает с n
        }else{
            if (n < FIBOarr.length - 1) {// Если n не выходит за пределы массива и n-й элемент не равен 0
                if (FIBOarr[n] != 0) {
                    RESfiboNumber = FIBOarr[n]; // То просто без цикла выбираем его
                }else {
                    for (int i = 2; i <= n; i++) {
                        RESfiboNumber = fiboprev1 + fiboprev2; // Здесь идет вычисление числа Фибоначчи
                        fiboprev1 = fiboprev2;
                        fiboprev2 = RESfiboNumber;
                    }
                }
            } else { // Если в массиве нет готового ответа (или n больше размера массива)
                for (int i = 2; i <= n; i++) { // Для бОльших чисел организуем "ханойский" цикл
                    RESfiboNumber = fiboprev1 + fiboprev2;
                    fiboprev1 = fiboprev2;
                    fiboprev2 = RESfiboNumber; // Здесь снова идет вычисление числа Фибоначчи, пытался построить ветвление без повторов блоков кода, но не смог (
                    if (i < FIBOarr.length - 1) { // Пока счетчик цикла не превышает размер массива
                        if (FIBOarr[i] == 0) {
                            FIBOarr[i] = RESfiboNumber; // Наполняем массив FIBOarr, избегая исключения выхода за границы массива
                        }
                    }
                }
            }
        }
        return RESfiboNumber;
    }
    public static boolean isGoldenTriangle(int a, int b, int c){ //Хочется уложить функцию в одну строку
        return (a == b & (double)a/c >= 1.61703d & (double)a/c <= 1.61903d | a == c & (double)a/b  >= 1.61703d & (double)a/b  <= 1.61903d | b == c & (double)b/a  >= 1.61703d & (double)b/a  <= 1.61903d);
    }
}