package ru.progwards.java1.lessons.datetime;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Реализовать класс для ручной профилировки производительности
 * программного кода. Профилировка программного кода - измерение
 * времени выполнения отдельных фрагментов кода с целью выявления
 * узких мест в производительности.
 */
public class Profiler {
    static LocalDateTime Start;
    static LocalDateTime Stop;
    public static ArrayList<StatisticInfo> list = new ArrayList();

    public static void main(String[] args) {
        String s = "";
        Profiler.enterSection("ВасисДас!");
        for (int i = 0; i < 405_00; i++) { // Примерно секунда выполнения на моём ПК
            s+=" 0123456789";
        }
        Profiler.exitSection("ВасисДас");
    }

    public static void enterSection(String name) {
        // войти в профилировочную секцию, замерить время входа.
        Start = LocalDateTime.now();
        System.out.println(Start + " - Время входа в сессию");
        StatisticInfo sa = new StatisticInfo(name);
        StatisticInfo findSA; // поисковая переменная

        sa = new StatisticInfo(name);
        boolean b = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).sectionName == sa.sectionName){
                b = true;
                list.get(i).count += sa.count;
                list.get(i).fullTime += LocalDateTime.now().getNano() - list.get(i).Date_Time_Start.getNano();
                //list.get(i).fullTime += sa.fullTime;
                list.get(i).selfTime += sa.selfTime;
            }
        }
        if(!b){list.add(sa);}

    }

    public static void exitSection(String name) {
        // выйти из профилировочной секции. Замерить время выхода,
        // вычислить промежуток времени между входом и выходом в миллисекундах.
        Stop = LocalDateTime.now();
        System.out.println(Stop + " - Время выхода из сессии");
        System.out.println(Duration.between(Start, Stop).toSeconds());
    }

    /**
     * получить профилировочную статистику, отсортировать по наименованию секции
     */
    public static List<StatisticInfo> getStatisticInfo(){
        return list; //TODO: Доделать!
        }
    }

class StatisticInfo {
    /**
     * Блок переменных=======================================================
     */
    LocalDateTime Date_Time_Start;
    public String sectionName; //- имя секции
    public int fullTime = 0;   //- полное время выполнения секции в миллисекундах.
    public int selfTime = 0;   //- чистое время выполнения секции в миллисекундах.

    // Для вложенных секций, из времени выполнения
    // внешней секции нужно вычесть времена выполнения вложенных секций.
    public int count = 0; //- количество вызовов. В случае, если вызовов более одного,

    // fullTime и selfTime содержат суммарное время выполнения всех вызовов.
    /**
     * Точка входа в программу===============================================
     */
    public static void main(String[] args) {
        System.out.println(args[0] + " - Время входа в сессию");
    }
    /**
     * Методы класса==========================================================
     */
    public StatisticInfo(String sectionName) {
        this.sectionName = sectionName;
        count++;
        Date_Time_Start = LocalDateTime.now();// Здесь будет дата и время начала
    }
}
