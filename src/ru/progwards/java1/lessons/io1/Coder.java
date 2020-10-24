package ru.progwards.java1.lessons.io1;
public class Coder extends CharFilter{
     public static void codeFile(String inFileName, String outFileName, char[] code, String logName)  {
          System.out.println(inFileName + " - inFileName");
          System.out.println(outFileName + " - outFileName");
          System.out.println(logName + " - logName");

          String charINFO = new String(code);
          System.out.println(charINFO);
          String IN = read(inFileName); // Читаем файл
          String LOG; // Текст ЛОГа
          try{
               for (int i = 0; i < code.length; i++) {
                    IN = IN.replace(Character.toString(code[i]), "");
               }
          }catch(Exception e){
               LOG = e.getMessage(); // Если ошибка, пишем ошибку в лог
               write(LOG, logName);  // И выводим лог в файл
               e.printStackTrace();
               throw new RuntimeException("Выход за пределы массива или массив не существует", e);
          }
          write(outFileName, IN);
     }
}