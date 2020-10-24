package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LineCount {
    /*Создать статический метод public static int calcEmpty(String fileName),
    в котором посчитать количество пустых строк в файле. В случае возникновения
    ошибок, вернуть -1
     */
    public static int calcEmpty(String fileName) throws IOException {
        int rez = 0;
        try{
            FileReader weader = new FileReader(fileName);
            Scanner scanner = new Scanner(weader);
            while (scanner.hasNextLine()) {
                String strFromFile = scanner.nextLine();
                if (strFromFile.length() ==0){
                    rez++;
                }
            }
            return rez;
        } catch (IOException e) {
            //throw new java.io.IOException("файл не найден", e);
            return -1;
        }
    }
}
