package ru.progwards.java1.lessons.io1;
public class Coder extends CharFilter{
//     Задача 2. Класс Coder
//     Создать статический метод public static void codeFile(String inFileName,
//     String outFileName, char[] code, String logName), в котором прочитать
//     файл inFileName и перекодировать его посимвольно в соответствии с заданным шифром,
//     результат записать в outFileName. Шифр задается маcсивом char[] code, где каждому
//     символу symbol оригинального файла соответствует символ code[(int)symbol] выходного
//     файла. В случае ошибок, в файл с именем logName вывести название ошибки через метод
//     класса Exception - getMessage()
     public static void codeFile(String inFileName, String outFileName, char[] code, String logName) throws Exception {
          String charINFO = new String(code);
          System.out.println(charINFO);
          String IN = read(inFileName); // Читаем файл
          String LOG; // Текст ЛОГа
          try{
               for (int i = 0; i < code.length; i++) {
                    IN = IN.replace(Character.toString(code[i]), "");
               }
          }catch(RuntimeException e){
               LOG = e.getMessage(); // Если ошибка, пишем ошибку в лог
               write(LOG, logName);  // И выводим лог в файл
               throw new RuntimeException("Выход за пределы массива или массив не существует", e);
          }
          write(outFileName, IN);
     }
}