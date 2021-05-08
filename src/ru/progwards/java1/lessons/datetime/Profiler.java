package ru.progwards.java1.lessons.datetime;

import java.time.LocalDateTime;

/**
 * Реализовать класс для ручной профилировки производительности
 * программного кода. Профилировка программного кода - измерение
 * времени выполнения отдельных фрагментов кода с целью выявления
 * узких мест в производительности.
 */

public class Profiler {
    public static void enterSection(String name) {
        // войти в профилировочную секцию, замерить время входа.
        LocalDateTime l = LocalDateTime.now();
        System.out.println(l + " - Время входа в сессию");
    }

    public static void exitSection(String name) {
        // - выйти из профилировочной секции. Замерить время выхода,
        // вычислить промежуток времени между входом и выходом в миллисекундах.
        LocalDateTime l = LocalDateTime.now();
        System.out.println(l + " - Время выхода из сессии");
    }
}


class StatisticInfo {
    public String sectionName; //- имя секции
    public int fullTime = 0;   //- полное время выполнения секции в миллисекундах.

    public int selfTime = 0;   //- чистое время выполнения секции в миллисекундах.
    // Для вложенных секций, из времени выполнения
    // внешней секции нужно вычесть времена выполнения вложенных секций.

    public int count = 0; //- количество вызовов. В случае, если вызовов более одного,
    // fullTime и selfTime содержат суммарное время выполнения всех вызовов.
    public static void main(String[] args) {
        System.out.println(args[0] + " - Время входа в сессию");
    }
}