package ru.progwards.java1.lessons.io1;

import java.io.FileWriter;
import java.io.IOException;

public class Coder extends CharFilter {
    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) throws IOException {
        System.out.println("Вызван to_log с параметрами:\ninFileName = " + inFileName + ";\noutFileName = " + outFileName + "\nlogName = " + logName);
        String IN = ""; // Текст на ввод
        String OUT = ""; // Текст на вывод
        String LOG = ""; // Текст ЛОГа
        int vop; // для кода символа
        try {
            try {
                IN = read(inFileName); // Читаем файл
            } catch (Exception r) {
                System.out.println("не указан файл ввода");
                to_log(r.getMessage(), logName);
                throw new Exception (r);
                //return;
            }
            char[] res = IN.toCharArray();
            for (int i = 0; i < res.length; i++) { // До конца файла
                vop = res[i];// берем его символ, выясняем его код (Переводим в int)
                OUT += code[vop];// по найденному индексу принимаем символ из code
            }
        } catch (Exception e) {
            System.out.println("Ошибка - не найден файл чтения");
            try {
                FileWriter IN_LOG = new FileWriter(logName);
                IN_LOG.write(LOG);
                IN_LOG.close();
            } catch (Exception e11) {
                System.out.println("Не указан файл-источник");
            }
        }

        try {
            FileWriter writerOUT = new FileWriter(outFileName); // Запись в файл
            try {
                writerOUT.write(OUT);
            } catch (Exception f) {
                System.out.println("Не удалось записать  файл " + outFileName + ". Пишем лог в файл " + logName);
                to_log(f.getMessage(), logName);
            } finally {
                writerOUT.close();
            }

        } catch (NullPointerException NP){
            System.out.println("Некорректный файл вывода ( " + outFileName + ")");
            String NPE = NP.getMessage();
            if (NPE == null){NPE = NP.toString();}
            to_log(NPE, logName);
        } catch (Exception f2) {
            to_log(f2.getMessage(), logName);
        }
    }

    public static void to_log(String value, String fName) {
        System.out.println("Вызван to_log с параметрами:\nvalue3 = " + value + ";\nfName = " + fName);
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
}