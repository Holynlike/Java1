package ru.progwards.java1.lessons.io1;
import java.lang.*;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
public class CharFilter {
public static void filterFile(String inFileName, String outFileName, String filter) {
    System.out.println(inFileName + " - inFileName");
    System.out.println(outFileName + " - outFileName");
    System.out.println(filter + " - filter");
    String IN = read(inFileName);
    char rep;
    for (int i = 0; i < filter.length(); i++) {
        rep = filter.charAt(i);
        IN = IN.replace(Character.toString(rep), "");
    }
    write(outFileName, IN);
}
    public static String read(String fileName)  { // Чтение
        System.out.println("Старт функции read");
        String rez = "";
        FileReader reader;
        try{
            reader = new FileReader(fileName);
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                String strFromFile = scanner.nextLine();
                rez+=strFromFile;
            }
            reader.close();
            System.out.println("Прочитан текст: " + rez);
            System.out.println("Из файла: " + fileName);
            return rez;
        } catch (Exception e) {
            System.out.println("Не удалось прочитать файл " + fileName);
            System.out.println("Причина: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("File not found", e);
        }
    }
    public static void write(String fileName, String value)  { // Запись
        FileWriter writer;
        try{
            System.out.println("Запись файла: " + fileName);
            System.out.println("Текст для записи: " + value);
            writer = new FileWriter(fileName);
            writer.write(value);
            writer.close();
        } catch (Exception e) {
            System.out.println("Не удалось записать файл: " + fileName);
            System.out.println("Текст для записи: " + value);
            throw new RuntimeException("File not found", e);
        }
    }
}