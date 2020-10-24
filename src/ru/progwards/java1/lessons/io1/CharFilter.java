package ru.progwards.java1.lessons.io1;
import java.lang.*;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class CharFilter {
//    Задача 3. Класс CharFilter
//    Создать статический метод public static void filterFile(String inFileName, String outFileName, String filter),
//    в котором прочитать файл inFileName и удалить символы, содержащиеся в String filter, результат записать в
//    выходной файл. В случае возникновения ошибки, пробросить стандартное исключение выше, корректно закрыв все ресурсы
//
//    Например файл содержит:
//    Java — строго типизированный объектно-ориентированный язык программирования, разработанный компанией
//    Sun Microsystems (в последующем приобретённой компанией Oracle).
//    obscene = " -,.()"
//    Должен выдать результат:
//    JavaстроготипизированныйобъектноориентированныйязыкпрограммированияразработанныйкомпаниейSunMicrosystemsвпоследующемприобретённойкомпаниейOracle
//public static void main(String[] args) throws IOException {
//    filterFile("C:\\JAVATemp\\infile.txt","C:\\JAVATemp\\out.txt","C:\\JAVATemp\\filter.txt");
//}
public static void filterFile(String inFileName, String outFileName, String filter) throws Exception {
    String FILT = read(filter);
    String IN = read(inFileName);
    String OUT;
    char[] repl = FILT.toCharArray();
    char rep;
    for (int i = 0; i < FILT.length(); i++) {
        rep = FILT.charAt(i);
        IN = IN.replace(Character.toString(rep), "");
    }
    write(outFileName, IN);
}
    public static String read(String fileName) throws Exception { // Чтение
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
            return rez;
        } catch (IOException e) {
            throw new java.io.IOException("File not found", e);
        }
    }
    public static void write(String fileName, String value) throws Exception { // Запись
        FileWriter writer;
        try{
            writer = new FileWriter(fileName);
            writer.write(value);
            writer.close();
        } catch (IOException e) {
            throw new java.io.IOException("File not found", e);
        }
    }
}