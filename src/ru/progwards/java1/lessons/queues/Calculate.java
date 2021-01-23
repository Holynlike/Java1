package ru.progwards.java1.lessons.queues;

public class Calculate {
    public static void main(String[] args) {
        System.out.println(calculation1());
        System.out.println(calculation2());
    }
    public static double calculation1(){
        // 2.2*(3+12.1)

        StackCalc stackCalc = new StackCalc();
        stackCalc.push(2.2);
        stackCalc.push(3);
        stackCalc.push(12.1);
        stackCalc.add();
        stackCalc.mul();
        return stackCalc.pop();
    }
    public static double calculation2(){
        // (737,22+24)/(55,6-12,1)+(19-3,33)*(87+2*(13,001-9,2))

        StackCalc stackCalcMirrow = new StackCalc(); // Основная рабочая очередь
        StackCalc stackCalc = new StackCalc();       // Служебная очередь для сложной арифметики

        stackCalc.push(737.22);
        stackCalc.push(24.0);
        stackCalc.push(55.6);
        stackCalc.push(12.1); // Первая часть выражения

        stackCalc.push(19.0);
        stackCalc.push(3.33);
        stackCalc.push(87.0);
        stackCalc.push(2.0);
        stackCalc.push(13.001);
        stackCalc.push(9.2); // Вторая часть выражения

        stackCalc.sub(); // (13,001-9,2)=3,801
        stackCalc.mul(); // 2*(13,001-9,2) = 7,602
        stackCalc.add(); // 7,602+87 = 94,602
        // выбрать полученное в отдельную очередь (для манипуляции с двумя последующими)
        stackCalcMirrow.push(stackCalc.pop()); // Отправим часть результата в другую очередь на передержку
        stackCalc.sub(); // 19-3.33 = 15,67
        stackCalcMirrow.push(stackCalc.pop()); // Ещё часть выражения в другую очередь
        stackCalcMirrow.mul(); // Умножение в служебной очереди
        stackCalc.sub(); // 55.6-12.1 = 43.5
        stackCalcMirrow.push(stackCalc.pop());
        stackCalc.add(); // 737.22 + 24 = 761.22 (это последние два числа в очереди
        stackCalc.push(stackCalcMirrow.pop()); // возвращаем из служебной очереди последнее для деления
        stackCalc.div(); // (737,22+24)/(55,6-12,1) = 17,499...
        stackCalc.push(stackCalcMirrow.pop());
        stackCalc.add();
        return stackCalc.pop(); //Ожидаем: 1499,9126503448276
    }
}
