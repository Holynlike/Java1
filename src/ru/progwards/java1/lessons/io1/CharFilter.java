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
    /** Пользовательская оболочка для функционала чтения файла (в строковом режиме)
     * @param fileName имя файла
     */
    public static String read(String fileName) throws Exception{ // Чтение
        System.out.println("\nСтарт функции read");
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
            System.out.println("Прочитан текст: " + rez);
            System.out.println("Из файла: " + fileName);
        } catch (Exception e) {
            System.out.println("Не удалось прочитать файл " + fileName);
            System.out.println("Причина: " + e.getMessage());
            throw new Exception (e);
        }
        return rez;
    }

    /** Пользовательская оболочка для функционала записи файла (в строковом режиме)
     *
     * @param fileName имя файла
     * @param value строка в запись
     */
    public static void write(String fileName, String value) { // Запись
        try {
            FileWriter writer = new FileWriter(fileName);
            System.out.println("\n\nЗапись файла: " + fileName);
            System.out.println("Текст для записи: " + value + "\n\n");
            try {
                writer.write(value);
                System.out.println("\n\nзаписано успешно\n\n" + value);
            } finally {
                writer.close();
            }
        } catch (IOException e) {
            System.out.println("Не удалось записать файл: " + e.getMessage());
        }
    }

    /**
     * Проверка существования файла
     * @param Filename Имя файла, доступность которого необходимо проверить
     */
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