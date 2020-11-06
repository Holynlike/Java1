package ru.progwards.java1.lessons.io1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.*;

public class Coder {

    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) throws IOException {
        System.out.println("Вызван codeFile с параметрами:\ninFileName = " + inFileName + ";\noutFileName = " + outFileName + "\nlogName = " + logName);
        System.out.println("Корректность параметров:\n" + inFileName  + inFileName );
        String IN = ""; // Текст на ввод
        String OUT = ""; // Текст на вывод
        int vop; // для кода символа
        try {
            IN = read(inFileName); // Читаем файл
            try {
                char[] res = IN.toCharArray();
                for (int i = 0; i < res.length; i++) { // До конца файла
                    vop = res[i];// берем его символ, выясняем его код (Переводим в int)
                    OUT += code[vop];// по найденному индексу принимаем символ из code
                }
            } catch (ArrayIndexOutOfBoundsException out) {
                System.out.println("не указан файл ввода");
                to_log(out.getMessage(), logName);
            }

        } catch (IOException e) {
            to_log(e.getMessage(), logName);
            throw new IOException(e);
        }

        try { // Запись в файл
            FileWriter writerOUT = new FileWriter(outFileName);
            try {
                writerOUT.write(OUT);
            } catch (IOException f) {
                System.out.println("Не удалось записать файл " + outFileName + ". Пишем лог в файл " + logName);
                to_log(f.getMessage(), logName);
                throw new IOException (f);
            } finally {
                writerOUT.close();
            }

        } catch (NullPointerException NP) {
            System.out.println("Некорректный файл вывода ( " + outFileName + ")");
            String NPE = NP.getMessage();
            if (NPE == null) {
                NPE = NP.toString();
            }
            to_log(NPE, logName);
        } catch (IOException f2) {
            to_log(f2.getMessage(), logName);
            throw new IOException(f2);
        }
    }

    public static void to_log(String value, String fName) {
        System.out.println("Вызван to_log с параметрами:\nvalue = " + value + ";\nfName = " + fName);
        try {
            FileWriter writerOUT = new FileWriter(fName); // Запись в файл
            if (value == null){ throw new IOException();}
            try {
                writerOUT.write(value);
            } finally {
                writerOUT.close();
            }

        } catch (Exception w){
            System.out.println(w.getMessage() + " - ошибка записи лога");
        }
    }

    public static String read(String fileName) throws IOException { // Чтение
        System.out.println("\nСтарт функции read с параметрами:\nfileName " + fileName);
        if (fileName == null) {throw new IOException();} // Сразу выходим, если в качестве файла подан null!
        String rez = "";

        FileInputStream reader = new FileInputStream(fileName);
        byte[] arr = reader.readAllBytes();
        reader.close();
        for (int b = 0; b < arr.length;b++) {rez+=(char)arr[b];}

        System.out.println("Прочитан текст: " + rez);
        System.out.println("Из файла: " + fileName);
        return rez;
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