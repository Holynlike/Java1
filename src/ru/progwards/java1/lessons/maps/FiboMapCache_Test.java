package ru.progwards.java1.lessons.maps;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class FiboMapCache_Test {
    public static void main(String[] args) {

    }

    public static void poi() {
        Instant instant = Instant.now();
        ZonedDateTime zdt = instant.atZone(ZoneId.of("Europe/Moscow"));

        LocalDateTime ldt = zdt.toLocalDateTime();
        System.out.println(ldt);
    }

    HashMap<Integer, String> a2map(int[] akey, String[] aval) {
        HashMap<Integer, String> a = new HashMap<Integer, String>();
        for (int i = 0; i < akey.length; i++) {
            a.put(akey[i], aval[i]);
        }
        return a;
    }

    public static Date createDate() { //28 февраля 1986, 0 часов, 0 минут, 0 секунд, 0 миллисекунд
        return new Date(1986, 3, 28);
    }

    public static void ggg() {
        ZoneId zid1 = ZoneId.of("Europe/Moscow");
        System.out.println(zid1.getRules().getOffset(Instant.now()));
    }

    public static Instant createInstant() { // Instant, соответствующий 1 января 2020 года, 15 часов и одна наносекунда по Московскому времени
        return Instant.ofEpochSecond(1577901600).plusNanos(1);
    }
}