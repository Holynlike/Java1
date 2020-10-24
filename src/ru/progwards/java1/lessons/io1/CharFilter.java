package ru.progwards.java1.lessons.io1;
import java.lang.*;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
public class CharFilter {
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
        } catch (Exception e) {
            e.printStackTrace();
            throw new java.io.IOException("File not found", e);
        }
    }
    public static void write(String fileName, String value) throws Exception { // Запись
        FileWriter writer;
        try{
            writer = new FileWriter(fileName);
            writer.write(value);
            writer.close();
        } catch (Exception e) {
            throw new java.io.IOException("File not found", e);
        }
    }
}