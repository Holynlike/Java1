package ru.progwards.java1.lessons.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class Insurance {
    public static void main(String[] args) {
        Insurance insurance = new Insurance("13.03.2021", FormatStyle.SHORT);
        insurance.setDuration(15,2,3); //Ожидаем 3060
    }
    public static enum FormatStyle {SHORT, LONG, FULL}

    private ZonedDateTime start;// - дата-время начала действия страховки.
    private Duration duration;// - продолжительность действия.

    // Конструкторы:
    public Insurance(ZonedDateTime start) {this.start = start;}

    public Insurance(String strStart, FormatStyle style){
        System.out.println("вызов конструктора Insurance; strStart = " + strStart + "FormatStyle = " + style.toString());
//        - установить дату-время начала действия страховки
//        SHORT соответствует ISO_LOCAL_DATE
//        LONG  - ISO_LOCAL_DATE_TIME
//        FULL - ISO_ZONED_DATE_TIME
//        Для вариантов, когда не задан явно часовой пояс использовать таковой по умолчанию.
        String ss = "";
        DateTimeFormatter dtf3 = DateTimeFormatter.BASIC_ISO_DATE;
        switch (style){
            case FULL : dtf3= DateTimeFormatter.ISO_ZONED_DATE_TIME;
            case LONG : dtf3= DateTimeFormatter.ISO_LOCAL_DATE_TIME;
           case SHORT : dtf3= DateTimeFormatter.ISO_LOCAL_DATE;
            default   : dtf3 = DateTimeFormatter.BASIC_ISO_DATE;
        }
        ZonedDateTime zdt2 = Instant.now().atZone(ZoneId.of("Europe/Moscow"));


        DateTimeFormatter dtf =  DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        TemporalAccessor ta = dtf.parse("12.12.2012 12:12:12");
        LocalDateTime ldt = LocalDateTime.from(ta);
        System.out.println(ldt);
    }
    public void setDuration(Duration duration){this.duration = duration;}
    public void setDuration(ZonedDateTime expiration) {
        duration = Duration.ofSeconds(expiration.getSecond());
    }

    public void setDuration(int months, int days, int hours) {
        int MontToHours = 0;
        int yea=months % 12;
        System.out.println(yea);
        int fullMonths = months - (months % 12); // задел на будущее если робот подаст больше 12 месяцев
        System.out.println(fullMonths);
        switch (yea){ //TODO: Вариант покрывает страховку не дольше года. Надо бы пилить на большее через деление по модулю и его остаток
            case 1: MontToHours = 31;
                break;
            case 2: MontToHours = 59;
                break;
            case 3: MontToHours = 90;
                break;
            case 4: MontToHours = 120;
                break;
            case 5: MontToHours = 151;
                break;
            case 6: MontToHours = 181;
                break;
            case 7: MontToHours = 212;
                break;
            case 8: MontToHours = 243;
                break;
            case 9: MontToHours = 273;
                break;
            case 10: MontToHours = 304;
                break;
            case 11: MontToHours = 334;
        }
        duration = Duration.ofDays(((fullMonths/12)*365) + MontToHours + days);
        duration = duration.plusHours(hours);
        System.out.println(duration.toMinutes());
    }

    public void setDuration(String strDuration, FormatStyle style) {

    }


    //1.4 Реализовать методы возврата информации:

    public boolean checkValid(ZonedDateTime dateTime){
        //- проверить действительна ли страховка на указанную дату-время.
        // Если продолжительность не задана считать страховку бессрочной.
        boolean blnRES;
        blnRES = (dateTime == null) ? true : false;
        return blnRES; //TODO:  DE LAT
    }

    public String toString() {
        //- вернуть строку формата "Insurance issued on " + start + validStr,
        // где validStr = " is valid", если страховка действительна на данный момент и
        // " is not valid", если она недействительна.
        ZonedDateTime zt = ZonedDateTime.now();
        String ret = "";
        if (this.start.plusNanos(duration.toNanos()).getNano() > System.nanoTime()){

        }
        return "true"; //TODO:  DE LAT
    }
}
