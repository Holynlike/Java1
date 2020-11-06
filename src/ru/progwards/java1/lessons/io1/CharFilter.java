//                                     // начало ...-=-... CharFilter...-=-...
package ru.progwards.java1.lessons.io1;
import java.io.IOException;
import java.lang.*;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
/**
 * Класс удалит в тексте файла inFileName символы, поданные в filter, результат реплейса запишет в файл outFileName
 *
 * Класс для удобоюза содержит оболочки к методам чтения и записии файлов с пробросом ошибок
 */
public class CharFilter {
    public static void filterFile(String inFileName, String outFileName, String filter) throws Exception {
        String IN = read(inFileName);
        char rep;
        for (int i = 0; i < filter.length(); i++) {
            rep = filter.charAt(i);
            IN = IN.replace(Character.toString(rep), "");
        }
        write(outFileName, IN);
    }

    public static String read(String fileName) throws Exception{ // Чтение
        String rez = "";
        FileReader reader;
        try {
            reader = new FileReader(fileName);
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                String strFromFile = scanner.nextLine();
                rez += strFromFile;
            }
            reader.close();
        } catch (Exception e) {
            throw new Exception (e);
        }
        return rez;
    }

    public static void write(String fileName, String value) { // Запись
        try {
            FileWriter writer = new FileWriter(fileName);
            try {
                writer.write(value);
            } finally {
                writer.close();
            }
        } catch (IOException e) {
        }
    }

    public static boolean Exists(String Filename) { // Существует ли файл?
        if (Filename == null) {
            return false;
        }
        try {
            FileWriter FW = new FileWriter(Filename);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
//                                                                                        конец ...-=-... CharFilter...-=-...