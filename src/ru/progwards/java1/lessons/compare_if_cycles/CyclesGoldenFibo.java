package ru.progwards.java1.lessons.compare_if_cycles;

public class CyclesGoldenFibo {
    public static void main(String[] args) {
        System.out.println(containsDigit(242, 3)); // Тестил, работает
        System.out.println(fiboNumber(10)); // Тестил, работает
        System.out.println(isGoldenTriangle(1,2,3)); // Тестил, работает
        System.out.println(isGoldenTriangle(593,480,480)); // Тестил, работает
        for (int i = 0; i <= 15; i++) {
            System.out.println(fiboNumber(i)); // Фибо - цикл
        }
        for (int i = 1; i < 100; i++) { // Цикл поиска золотых треугольников
            for (int j = 1; j <= i; j++) { // Стремление к оптимизации цикла!  :)
                if (isGoldenTriangle(i,j,j)){
                    System.out.println("Найден золотой треугольник с параметрами: " + i + ", " + j + ", " + j);
                }
            }
        }
    }
    public static boolean containsDigit(int number, int digit){
        System.out.println("Вызвана функция containsDigit с агрументами: " + number + ", " + digit);
        //  будет возвращать true, если число number содержит цифру digit.
        String Stext = Integer.toString(number); // число number переведено в строку Stext
        String Sdigit = Integer.toString(digit); // число digit переведено в строку Sdigit
        boolean BLNRESULT = false;
        if (Stext.indexOf(Sdigit) > 0){
            BLNRESULT = true;
        }
        return BLNRESULT;
    }
    public static int fiboNumber(int n){ // Найти число Фибоначчи для n
        int RESfiboNumber = 0;
        int fiboprev1 = 1, fiboprev2 = 1;
        if (n == 0 | n == 1){
            RESfiboNumber = 1;
        } else {
            for (int i = 2; i <= n; i++) {
                RESfiboNumber = fiboprev1 + fiboprev2;
                fiboprev2 = fiboprev1;
                fiboprev1 = RESfiboNumber;
                //System.out.printf("i=%d, RESfiboNumber=%d;  ", i, RESfiboNumber);
            }
        }
        return RESfiboNumber;
    }
    public static boolean isGoldenTriangle(int a, int b, int c){
        boolean BLNisGoldenTriangle = false;
        double Da = (double) (b + c) /a, Db = (double) (a + c) /b, Dc = (double) (b + a) /c;
        if (a == b & Dc <= 1.61903 & Dc >= 1.61703 | c == b & Da <= 1.61903 & Da >= 1.61703 | a == c & Db <= 1.61903 & Db >= 1.61703) {
            BLNisGoldenTriangle = true;
        }
        return BLNisGoldenTriangle;
    }
}