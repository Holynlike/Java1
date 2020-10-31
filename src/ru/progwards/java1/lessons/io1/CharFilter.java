//                                                                                        начало ...-=-... CharFilter...-=-...
package ru.progwards.java1.lessons.io1;
import java.io.IOException;
import java.lang.*;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
public class CharFilter {
public static void filterFile(String inFileName, String outFileName, String filter)throws IOException {
    System.out.println(inFileName + " - inFileName");
    System.out.println(outFileName + " - outFileName");
    System.out.println(filter + " - filter");
    String IN = read(inFileName);
    char rep;
    for (int i = 0; i < filter.length(); i++) {
        rep = filter.charAt(i);
        IN = IN.replace(Character.toString(rep), "");
    }
    write1(outFileName, IN);
}
    public static String read(String fileName)  { // Чтение
        System.out.println("\nСтарт функции read");
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
    public static void write1(String fileName, String value)  { // Запись
        try{
            FileWriter writer = new FileWriter(fileName);
            System.out.println("\n\nЗапись файла: " + fileName);
            System.out.println("Текст для записи: " + value + "\n\n");
            try {
                writer.write(value);
                System.out.println("\n\nзаписано успешно\n\n" + value);
//            }catch (Exception e) {
//                System.out.println("Ошибка! Текст для записи: \n" + value);
//
            }finally{
                writer.close();
            }
        } catch (IOException e) {
            System.out.println("Не удалось записать файл: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
}
//                                                                                        конец ...-=-... CharFilter...-=-...