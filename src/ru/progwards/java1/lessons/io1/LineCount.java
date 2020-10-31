//                                                                                        начало ...-=-... LineCount...-=-...
package ru.progwards.java1.lessons.io1;
import java.io.FileReader;
import java.util.Scanner;
public class LineCount {
    public static int calcEmpty(String fileName) {
        //System.out.println(fileName + " - fileName");
        int rez = 0;
        try{
            FileReader weader = new FileReader(fileName);
            Scanner scanner = new Scanner(weader);
            while (scanner.hasNextLine()) {
                String strFromFile = scanner.nextLine();
                if (strFromFile.length() ==0){rez++;}
            }
            return rez;
        } catch (Exception e) {
            rez = -1;
            e.printStackTrace();
            throw new RuntimeException("файл не найден", e);
        }finally{return rez;}
    }
}//                                                                                        конец ...-=-... LineCount...-=-...

