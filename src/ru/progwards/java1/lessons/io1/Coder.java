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
          String LOG; // Текст ЛОГа
          String OUT ="";
          try{
               String IN = read(inFileName); // Читаем файл
               System.out.println("Прочитан файл: " + inFileName + " содержимое файла:\n" + IN + "\n\"");
               int vop;
               char[] res = IN.toCharArray();
               try{
                    for (int i = 0; i < res.length; i++) { // До конца файла
                         vop = res[i];// берем его символ, выясняем его код (Переводим в int)
                         OUT+=code[vop];// по найденному индексу принимаем символ из code
                    }
                    Mywrite(outFileName, OUT); // Запись файла-вывода
               }catch(Exception e){ // Если записать файл не получилось
                    System.out.println("Возникло исключение в блоке try ... catch метода coder");
                    LOG = e.getMessage(); // Если ошибка, пишем ошибку в лог
                    System.out.println(LOG);
                    Mywrite(logName, LOG);  // Пишем в лог-файл
               }

          }catch(Exception e){
               Mywrite(outFileName, OUT);  // всё равно пытаемся записать файл
               LOG = e.getMessage(); // Если ошибка, пишем ошибку в лог
               System.out.println(LOG);
               Mywrite(logName, LOG);  // Пишем в лог-файл
          }
     }
     public static void Mywrite(String fileName, String value)  { // Запись
          try{
               FileWriter writer = new FileWriter(fileName);
               System.out.println("\n\nЗапись файла: " + fileName);
               System.out.println("Текст для записи: " + value + "\n\n");
               try {
                    writer.write(value);
                    System.out.println("\n\nзаписано успешно\n\n" + value);
//            }catch (Exception e) {
//                System.out.println("Ошибка! Текст для записи: \n" + value);
//
               }finally{
                    writer.close();
               }
          } catch (IOException e) {
               System.out.println("Не удалось записать файл: " + e.getMessage());
               //throw new RuntimeException(e.getMessage());
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