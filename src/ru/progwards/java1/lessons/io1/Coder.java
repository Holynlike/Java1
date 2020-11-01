package ru.progwards.java1.lessons.io1;
//                              Начало ...-=-... Coder...-=-...

import java.io.FileWriter;
import java.io.IOException;

/**      жавадок =)
*        Задача 2. Класс Coder
*        Создать статический метод public static void codeFile
*        (String inFileName, String outFileName, char[] code,
*        String logName),
*        в котором прочитать файл inFileName и перекодировать его посимвольно
*        в соответствии с заданным шифром, результат записать в outFileName.
*        Шифр задается маcсивом char[] code, где каждому символу symbol
*        оригинального файла соответствует символ code[(int)symbol] выходного файла.
*        В случае ошибок, в файл с именем logName вывести название ошибки через
*        метод класса Exception - getMessage()
*/
public class Coder extends CharFilter{
     /**
      * String inFileName - путь к кодируемому файлу
      * String outFileName - путь к файлу с результатом кодирования
      * char[] code - массив символов char - код шифрования (кодовая страница, ожидаем 256 символов)
      * String logName - путь к файлу, куда будет записан лог ошибок
      */
     public static void codeFile(String inFileName, String outFileName, char[] code, String logName)  {
          DebugTrace(inFileName, outFileName, code, logName); // Вывод отладочной инфы на консольку
          //String LOG =""; // Текст ЛОГа
          String OUT ="";
          int vop;
          String IN = read(inFileName); // Читаем файл
          char[] res = IN.toCharArray();
          for (int i = 0; i < res.length; i++) { // До конца файла
               vop = res[i];// берем его символ, выясняем его код (Переводим в int)
               OUT+=code[vop];// по найденному индексу принимаем символ из code
          }
// Файл перекодирован, приступаем к записи
          try{
               FileWriter writerOUT = new FileWriter(outFileName); // Запись в файл
               writerOUT.write(OUT);
               writerOUT.close();
          } catch (Exception e) {
               try {
                    FileWriter writerOUT = new FileWriter(logName);
                    try {
                         writerOUT.write(e.getMessage()); // И пишем его в файл ЛОГа
                    } finally {
                         writerOUT.close();
                    }
               }catch (IOException e2) {
                    System.out.println(e.getMessage()); // Если и лог не удается записать
               }
          }
     }
     public static void DebugTrace(String inFileName, String outFileName, char[] code, String logName){
          System.out.println(inFileName + " - inFileName");
          System.out.println(outFileName + " - outFileName");
          System.out.println(logName + " - logName");
          String charINFO = new String(code);
          System.out.println("Длина массива символов: " + code.length);
          System.out.println("Сами символы:\n" + charINFO + "\n");
          System.out.println("Коды символов: ");
          for (int i = 0; i < code.length; i++) {
               System.out.print((int) code[i] + " | ");
          }
          // Код выше - отладочная часть (вывод в консоль аргументов ProgWards'кого робота)
     }

}
//                                конец ...-=-... Coder...-=-...