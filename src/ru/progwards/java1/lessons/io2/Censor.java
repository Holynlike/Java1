package ru.progwards.java1.lessons.io2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Создать статический метод public static void censorFile(String inoutFileName, String[] obscene),
 * в котором прочитать файл inoutFileName и заменить слова, содержащиеся в String[] obscene на '*',
 * соответствующие количеству символов в слове, изменения записать в исходный файл. В случае
 * возникновения ошибки, выбросить свое собственное исключение CensorException в котором сохранить
 * - строку, полученную у оригинального exception через метод getMessage() и имя файла, в котором
 * возникла ошибка. В классе перекрыть метод toString(), вернув <имя файла>:<строка ошибки>.
 * <p>
 * Класс CensorException разместить в классе Censor
 * <p>
 * Например файл содержит:
 * Java — строго типизированный объектно-ориентированный язык программирования, разработанный
 * компанией Sun Microsystems (в последующем приобретённой компанией Oracle).
 * obscene = {"Java", "Oracle", "Sun", "Microsystems"}
 * <p>
 * Должен выдать результат:
 * *** — строго типизированный объектно-ориентированный язык программирования, разработанный
 * компанией *** ************ (в последующем приобретённой компанией ******).
 **/
public class Censor {

    public static class CensorException extends Exception {
        String FILE;
        int ROW; // Две переменные - имя файла и строка
        Exception E;
        public CensorException(Exception mc2, String filename, int row) {
            ROW = row;      // Конструктор
            FILE = filename;
            E = mc2; // Не смог удержаться от шутки! =))
        }
        public String tostring(Exception e, String filename, int row) {
            return E.getMessage() + ":" + FILE + ":" + ROW;
        }
    }

    public static void censorFile(String inoutFileName, String[] obscene) throws Exception {
        String inout = "";
        try {
            inout = read(inoutFileName); // Читаем файл
        } catch (Exception e) {
            throw new CensorException(e, inoutFileName, 23);
        }
        System.out.println(inout); // Тестовый вывод прочтенного файла
        for (int i = 0; i < obscene.length; i++) {
            inout = inout.replaceAll(obscene[i], star(obscene[i])); // Заменяем слова на звездочки
        }
        System.out.println(inout); // Тестовый вывод цензурированного файла
        write(inoutFileName, inout); // записываем результат в файл
    }

    public static String star(String in) { // Превратить строку в набор звездочек!
        return in.replaceAll(".", "*");
    }

    public static String read(String fileName) throws Exception { // Чтение
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
            throw new Exception(e);
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
}