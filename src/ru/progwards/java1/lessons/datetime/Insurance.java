package ru.progwards.java1.lessons.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Insurance {
    // ====== Переменные класса
    public static enum FormatStyle {SHORT, LONG, FULL}
    private ZonedDateTime start;// - дата-время начала действия страховки.
    private Duration duration;// - продолжительность действия.
    // ======
    public static void main(String[] args) {
//========================
        Insurance insurance = new Insurance(ZonedDateTime.parse("2021-05-01T16:26:13.843932+03:00[Europe/Moscow]"));
        insurance.setDuration("1000000000", Insurance.FormatStyle.SHORT);
        System.out.println(insurance.toString());
        System.out.println("Ожидалось:\n" + "Insurance issued on 2021-05-01T16:26:13.843932+03:00[Europe/Moscow] is valid\n");
    }

    // Конструкторы:
    public Insurance(ZonedDateTime start) {this.start = start;}

    public Insurance(String strStart, FormatStyle style) {
        System.out.println("вызов конструктора Insurance; strStart = " + strStart + "FormatStyle = " + style.toString());
//        установить дату-время начала действия страховки
//        SHORT соответствует ISO_LOCAL_DATE
//        LONG  - ISO_LOCAL_DATE_TIME
//        FULL - ISO_ZONED_DATE_TIME
//        Для вариантов, когда не задан явно часовой пояс использовать таковой по умолчанию.
        DateTimeFormatter dtf;
        switch (style) {
            case FULL:
                dtf = DateTimeFormatter.ISO_ZONED_DATE_TIME;
                break;
            case LONG:
                dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                break;
            case SHORT:
                dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
// Чистый шорт она НИКАК не парсит - приходится ставить костыли (привешивать нулевые часы и минуты
                strStart+=" 00:00";
                break;
            default:
                dtf = DateTimeFormatter.BASIC_ISO_DATE;
        }
        LocalDateTime z = LocalDateTime.parse(strStart, dtf);
        start = z.atZone(ZoneId.of("Europe/Moscow"));
    }
    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public void setDuration(ZonedDateTime expiration) {
        duration = Duration.between(start, expiration);
    }

    public void setDuration(int months, int days, int hours) {
        try {
            System.out.println("Вызван метод: public void setDuration(int months, int days, int hours)");
            System.out.printf(String.valueOf(months), " - Monts", days, " - days", hours, " - Hours");
        }catch (Exception E){
            E.printStackTrace();
        }

        System.out.println("Вызван метод: public void setDuration(int months, int days, int hours)");
        System.out.printf(String.valueOf(months), " - Monts", days, " - days", hours, " - Hours");
        int MontToHours = 0;
        int yea = months % 12;
        int fullMonths = months - (months % 12); // задел на будущее если робот подаст больше 12 месяцев
        switch (yea) {
            case 1:
                MontToHours = 31;
                break;
            case 2:
                MontToHours = 59;
                break;
            case 3:
                MontToHours = 90;
                break;
            case 4:
                MontToHours = 120;
                break;
            case 5:
                MontToHours = 151;
                break;
            case 6:
                MontToHours = 181;
                break;
            case 7:
                MontToHours = 212;
                break;
            case 8:
                MontToHours = 243;
                break;
            case 9:
                MontToHours = 273;
                break;
            case 10:
                MontToHours = 304;
                break;
            case 11:
                MontToHours = 334;
        }
        duration = Duration.ofDays(((fullMonths / 12) * 365) + MontToHours + days);
        duration = duration.plusHours(hours);
    }

    public void setDuration(String strDuration, FormatStyle style) {
        System.out.println("вызов метода setDuration; strDuration = " + strDuration + "; FormatStyle = " + style.toString());
        if (strDuration.replaceAll("\\D+","") == strDuration) {// Если там одни числа
            long l = Long.valueOf(strDuration);
            System.out.println("В качестве strDuration  пришло число: " + l);
            duration = Duration.ofSeconds(l);
            return;
        }
//        установить дату-время начала действия страховки
//        SHORT соответствует ISO_LOCAL_DATE
//        LONG  - ISO_LOCAL_DATE_TIME
//        FULL - ISO_ZONED_DATE_TIME
//        Для вариантов, когда не задан явно часовой пояс использовать таковой по умолчанию.
        DateTimeFormatter dtf;
        switch (style) {
            case FULL: // FULL - стандартный формат Duration, который получается через toString()
                dtf = DateTimeFormatter.ISO_ZONED_DATE_TIME;
                break;
            case LONG:
                dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                break;
            default:
                dtf = DateTimeFormatter.BASIC_ISO_DATE;
        }

        LocalDateTime z = LocalDateTime.parse(strDuration, dtf);
        duration = Duration.parse(z.toString());
    }

    public boolean checkValid(ZonedDateTime dateTime) {
        if (duration == null){ // Если бессрочна, сравниваем только старт
            if (start.isBefore(dateTime)){ // Бессрочная страховка, ещё не вступила в действие
                return true;
            }else {
                return false;
            }
        }
        // Если продолжительность указана, сравниваем старт и окончание
        ZonedDateTime z = this.start.plusSeconds(duration.toSeconds()); // Здесь должно получиться время окончания страховки
        System.out.println(z);
        if (z.isAfter(dateTime) & start.isBefore(dateTime)){ // Если окончание страховки позднее, чем текущая дата, а старт страховки раньше текущего времени
            return true;
        }
        return false;
    }

    public String toString() {
        boolean b = checkValid(ZonedDateTime.now());
        if (b) {
            return "Insurance issued on " + this.start + " is valid";
        } else {
            return "Insurance issued on " + this.start + " is not valid";
        }
    }
}