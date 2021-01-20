package ru.progwards.java1.lessons.queues;

public class Calculate {
    public static void main(String[] args) {
        System.out.println(calculation1());
    }
    public static double calculation1(){
        StackCalc stackCalc = new StackCalc();
        stackCalc.push(3.0);
        stackCalc.push(12.1);
        stackCalc.push(2.2);
        stackCalc.add();
        stackCalc.mul();
        return stackCalc.pop();
    }
    public static double calculation2(){
        // (737.22+24)/(55.6-12.1)+(19-3.33)*(87+2*(13.001-9.2))

        // Ожидаем 94,602
        StackCalc stackCalc = new StackCalc();
        stackCalc.push(737.22);
        stackCalc.push(24.0);
        stackCalc.push(55.6);
        stackCalc.push(12.1);
        stackCalc.push(19.0);
        stackCalc.push(3.33);
        stackCalc.push(87.0);
        stackCalc.push(2.0);
        stackCalc.push(13.001);
        stackCalc.push(9.2);
        return 94.602;
    }
}
