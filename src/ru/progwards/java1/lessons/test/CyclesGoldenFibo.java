package ru.progwards.java1.lessons.test;

public class CyclesGoldenFibo {
    public static void main(String[] args) {
        System.out.println(containsDigit(242, 3)); // Тестил, работает
        System.out.println(fiboNumber(6));
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
        int fiboprev1 = 0, fiboprev2 = 0;
        if (n == 0 | n == 1){
            RESfiboNumber = 1;
        } else {
            fiboprev1 = 0;
            fiboprev2 = 1;
            for (int i = 2; i == n; i++) {
                RESfiboNumber = fiboprev1 + fiboprev2;
                fiboprev1 = RESfiboNumber;
                fiboprev2 = fiboprev1;
            }
        }
        return RESfiboNumber;
    }
}
