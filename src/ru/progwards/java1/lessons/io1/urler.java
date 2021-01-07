package ru.progwards.java1.lessons.io1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class urler {
    public static void main(String[] args) throws IOException {
        //URL url = new URL("https://static.tildacdn.com/tild3531-3437-4062-a266-613234626332/photo.jpg");
        URL CB = new URL("https://www.cbr.ru/currency_base/daily/");

        InputStream is = CB.openStream();
        ByteArrayOutputStream BAOS = new ByteArrayOutputStream();
        int b;
        while ((b = is.read()) != -1) {
            BAOS.write(b);
        }
        String CB_code = BAOS.toString();// Получен HTML-код страницы ЦентроБанка. Надо распарсить оттуда 34 валюты
        String[][] Courses = getcourse(CB_code);
    }

    public static String[][]getcourse(String text) {
        String[] splitter = text.split("table class=\"data\"");
        splitter = splitter[1].split("tbody>");
        splitter = splitter[1].split("<tr>");
        String[][] splitter2 = new String[splitter.length][6];
        String[] course ;
        for (int i = 2; i < splitter.length; i++) {
            course = splitter[i].split("<td>");
            for (int j = 1; j < 6; j++) {
                splitter2[i][j] = course[j].replaceAll("</t[d|r]>","").trim();
                splitter2[i][j] = splitter2[i][j].replaceAll("</","").trim();
            }

        }

        return splitter2;
    }
}