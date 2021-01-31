package ru.progwards.java1.lessons.maps;

import ru.progwards.java1.lessons.io2.Censor;

import java.io.FileReader;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UsageFrequency {
    public static String h = "";
    public static void main(String[] args) {
        UsageFrequency UF = new UsageFrequency();
        UF.processFile("D:/forexp/пример.csv");
    }
    public void processFile(String fileName){
        // загрузить содержимое файла
        String inout = "";
        try {
            inout = read(fileName); // Читаем файл
        } catch (Exception e) {
            e.printStackTrace();
        }
        h = inout;
    }
    public Map<Character, Integer> getLetters(){
        // вернуть Map, который содержит все найденные буквы и цифры, и
        // количество раз, которое встретился каждый искомый символ.
        // Знаки препинания, такие как “.,!? @” и др не учитывать
        Map map = new TreeMap<Character, Integer>();
        return map;
    }

    public Map<String, Integer> getWords(){
        // вернуть Map, который содержит все
        // найденные слова и количество раз,
        // которое каждое слово встретилось.
        // Знаки препинания, такие как “.,!? @”
        // и др являются разделителями.
        Map map = new TreeMap<String, Integer>();
        return map;
    }

    public static String read(String fileName) throws Exception { // Чтение
        String rez = "";
        int stroka = 0;
        FileReader reader;
        try {
            reader = new FileReader(fileName);
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                String strFromFile = scanner.nextLine();
                stroka++;
                rez += strFromFile;
            }
            reader.close();
        } catch (Exception e) {
            throw new Censor.CensorException(e, fileName, stroka);
            //throw new Exception(e);
        }
        return rez;
    }
}
